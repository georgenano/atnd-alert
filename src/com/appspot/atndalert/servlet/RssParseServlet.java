package com.appspot.atndalert.servlet;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.appspot.atndalert.meta.AlertWordMeta;
import com.appspot.atndalert.meta.AtndEventMeta;
import com.appspot.atndalert.model.AlertWord;
import com.appspot.atndalert.model.AtndEvent;
import com.appspot.atndalert.util.AtndDate;
import com.appspot.atndalert.util.NgramTokenizer;
import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;

@SuppressWarnings("serial")
public class RssParseServlet extends HttpServlet {
    static final AtndEventMeta atndEventMeta = AtndEventMeta.get();
    static final AlertWordMeta alertWordMeta = AlertWordMeta.get();

    private static final NgramTokenizer nt = new NgramTokenizer(2, 6);

    private static Logger logger = Logger.getLogger(RssParseServlet.class
        .getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        try {
            String id = req.getParameter("id");
            String title = req.getParameter("title");
            String catchStr = req.getParameter("catch");
//            String description = req.getParameter("description");
            String url = req.getParameter("url");
            String startedAt = req.getParameter("started_at");
            String endedAt = req.getParameter("ended_at");
            String limit = req.getParameter("limit");
            String address = req.getParameter("address");
            String place = req.getParameter("place");
            String lat = req.getParameter("lat");
            String lon = req.getParameter("lon");
            String ownerId = req.getParameter("owner_id");
            String ownerNickname = req.getParameter("owner_nickname");
            String ownerTwitterId = req.getParameter("owner_twitter_id");
            String accepted = req.getParameter("accepted");
            String waiting = req.getParameter("waiting");
            String updatedDate = req.getParameter("updated_at");
            List<AtndEvent> results =
                Datastore
                    .query(atndEventMeta)
                    .filter(
                        atndEventMeta.title.equal(title),
                        atndEventMeta.url.equal(url))
                    .asList();

            // feed情報がBigtableに存在するか検索
            if (results.isEmpty()) {
                // 再送信防止のため、bigtableに存在しなければ、feed内容を永続化
                AtndEvent ae = new AtndEvent();
                ae.setId(getInt(id));
                ae.setTitle(title);
                ae.setCatchSentence(catchStr);
//                ae.setDescription(description);
                ae.setUrl(url);
                ae.setStartedAt(getDate(startedAt));
                ae.setEndedAt(getDate(endedAt));
                ae.setLimit(getInt(limit));
                ae.setAddress(address);
                ae.setPlace(place);
                ae.setLat(lat);
                ae.setLon(lon);
                ae.setOwnerId(ownerId);
                ae.setOwnerNickname(ownerNickname);
                ae.setOwnerTwitterId(ownerTwitterId);
                ae.setAccepted(getInt(accepted));
                ae.setWaiting(getInt(waiting));
                ae.setUpdatedAt(getDate(updatedDate));
                Datastore.put(ae);
                logger.info("add Title:" + title + ", URL:" + url);

                // titleとcatchをトークン化
                List<String> tokens = nt.tokenize(title);
                tokens.addAll(nt.tokenize(catchStr));
                for (String token : tokens) {
                    List<AlertWord> aws =
                        Datastore
                            .query(alertWordMeta)
                            .filter(alertWordMeta.alertWord.equal(token))
                            .asList();
                    for (AlertWord aw : aws) {
                        MailService.Message msg = new MailService.Message();
                        msg.setSender("georgenano@gmail.com");
                        msg.setTo(aw.getMailAddress());
                        msg.setSubject("【ATND-Alert】  '"
                            + aw.getAlertWord()
                            + "'のイベントです！ 「"
                            + title + "」");
                        msg.setTextBody("アラートキーワード: "
                            + aw.getAlertWord()
                            + "\nイベント名:"
                            + title
                            + "\nURL:"
                            + url
                            + "\n概要: "
                            + catchStr
                            + "\nイベント開催日: "
                            + AtndDate.getDateString(startedAt)
                            + "\n場所: "
                            + place
                            + "\n更新日: "
                            + AtndDate.getDateString(updatedDate));

                        MailService mailservice =
                            MailServiceFactory.getMailService();
                        mailservice.send(msg);

                        String loginName = aw.getLoginName();
                        String mailAdrress = aw.getMailAddress();
                        logger.info("sendMail to [User:"
                            + loginName
                            + ", Mail:"
                            + mailAdrress
                            + ", AlertWord:"
                            + aw.getAlertWord()
                            + ", Title:"
                            + title
                            + "]");
                    }
                }
            } else {
                logger.info("exist Title:" + title + ", URL:" + url);
            }
        } catch (Exception e) {
            resp.getWriter().print(e.toString());
        }
    }

    private static int getInt(String intStr) {
        int value = 0;
        if (intStr == null || intStr.equals("")) {
            return 0;
        }
        value = Integer.parseInt(intStr);
        return value;
    }

    private static Date getDate(String dateStr) {
        Date value = null;
        if (dateStr == null || dateStr.equals(""))
            return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy-MM-dd'T'HH:mm:ssZ");
            // escape SimpleDateFormat unsupported ISO8601 problem
            String noColon = "";
            noColon += dateStr.substring(0, 22);
            noColon += dateStr.substring(23);
            value = sdf.parse(noColon);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

}
