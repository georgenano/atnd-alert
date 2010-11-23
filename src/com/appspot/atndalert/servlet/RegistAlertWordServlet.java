package com.appspot.atndalert.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.appspot.atndalert.meta.AlertWordMeta;
import com.appspot.atndalert.model.AlertWord;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class RegistAlertWordServlet extends HttpServlet {
    static final AlertWordMeta meta = AlertWordMeta.get();

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        UserService service = UserServiceFactory.getUserService();
        User user = service.getCurrentUser();
        String loginName = user.getNickname();
        String mailAddress = user.getEmail();
        String alertWord = req.getParameter("alertWord");

        List<AlertWord> results =
            Datastore
                .query(meta)
                .filter(
                    meta.loginName.equal(loginName),
                    meta.mailAddress.equal(mailAddress),
                    meta.alertWord.equal(alertWord))
                .asList();
        if (results.isEmpty()) {
            AlertWord aw = new AlertWord();
            aw.setLoginName(loginName);
            aw.setMailAddress(mailAddress);
            aw.setAlertWord(alertWord);
            Datastore.put(aw);
            req.setAttribute("result", "正常に「" + alertWord + "」を追加しました");
        } else {
            req.setAttribute("result", "すでに「" + alertWord + "」は存在しています");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/searchEvent");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
