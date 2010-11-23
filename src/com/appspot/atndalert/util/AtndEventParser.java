package com.appspot.atndalert.util;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.appspot.atndalert.model.AtndEvent;

public class AtndEventParser {

    public static List<AtndEvent> parseAtndEvent(String urlStr) {
        List<AtndEvent> aes = new ArrayList<AtndEvent>();
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        NodeList hash;
        try {
            URL feedUrl = new URL(urlStr);
            InputSource is = new InputSource(feedUrl.openStream());
            hash =
                (NodeList) xPath.evaluate("/hash", is, XPathConstants.NODESET);
            Element hashElement = (Element) hash.item(0);
            NodeList events =
                (NodeList) xPath.evaluate(
                    "events/event",
                    hashElement,
                    XPathConstants.NODESET);
            for (int i = 0; i < events.getLength(); i++) {
                Element eventElm = (Element) events.item(i);
                String id = xPath.evaluate("event_id", eventElm);
                String title = xPath.evaluate("title", eventElm);
                String catchSentence = xPath.evaluate("catch", eventElm);
                String description = xPath.evaluate("description", eventElm);
                String eventUrl = xPath.evaluate("event_url", eventElm);
                String started_at = xPath.evaluate("started_at", eventElm);
                String ended_at = xPath.evaluate("ended_at", eventElm);
                String limit = xPath.evaluate("limit", eventElm);
                String address = xPath.evaluate("address", eventElm);
                String place = xPath.evaluate("place", eventElm);
                String lat = xPath.evaluate("lat", eventElm);
                String lon = xPath.evaluate("lon", eventElm);
                String ownerId = xPath.evaluate("owner_id", eventElm);
                String ownerNickname =
                    xPath.evaluate("owner_nickname", eventElm);
                String ownerTwitterId =
                    xPath.evaluate("owner_twitter_id", eventElm);
                String accepted = xPath.evaluate("accepted", eventElm);
                String waiting = xPath.evaluate("waiting", eventElm);
                String updatedAt = xPath.evaluate("updated_at", eventElm);

                AtndEvent ae = new AtndEvent();
                ae.setId(toInt(id));
                ae.setTitle(title);
                ae.setCatchSentence(catchSentence);
  //              ae.setDescription(description);
                ae.setUrl(eventUrl);
                ae.setStartedAt(toDate(started_at));
                ae.setEndedAt(toDate(ended_at));
                ae.setLimit(toInt(limit));
                ae.setAddress(address);
                ae.setPlace(place);
                ae.setLat(lat);
                ae.setLon(lon);
                ae.setOwnerId(ownerId);
                ae.setOwnerNickname(ownerNickname);
                ae.setOwnerTwitterId(ownerTwitterId);
                ae.setAccepted(toInt(accepted));
                ae.setWaiting(toInt(waiting));
                ae.setUpdatedAt(toDate(updatedAt));

                aes.add(ae);
            }
        } catch (XPathExpressionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return aes;
    }

    private static int toInt(String intStr) {
        int value = 0;
        if (intStr == null || intStr.equals("")) {
            return 0;
        }
        value = Integer.parseInt(intStr);
        return value;
    }

    private static Date toDate(String dateStr) {
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
