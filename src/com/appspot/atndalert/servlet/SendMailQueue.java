package com.appspot.atndalert.servlet;

import static com.google.appengine.api.labs.taskqueue.TaskOptions.Builder.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.appengine.api.labs.taskqueue.Queue;
import com.google.appengine.api.labs.taskqueue.QueueFactory;

public class SendMailQueue extends HttpServlet {
    private static Logger logger = Logger.getLogger(SendMailQueue.class
        .getName());
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // キューに名前を付けてキューを取得する
        Queue queue = QueueFactory.getQueue("sendMail");

        String url = "http://api.atnd.org/events/?count=100&format=xml";
        // URLからfeed内容を取得
        URL feedUrl;
        InputSource is;
        NodeList hash = null;
        NodeList events = null;
        try {
            resp.getWriter().println("Start queues.");
            logger.info("Start queues.");
            
            feedUrl = new URL(url);

            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();
            is = new InputSource(feedUrl.openStream());
            // parse event info
            hash =
                (NodeList) xPath.evaluate("/hash", is, XPathConstants.NODESET);
            Element hashElement = (Element) hash.item(0);
            events =
                (NodeList) xPath.evaluate(
                    "events/event",
                    hashElement,
                    XPathConstants.NODESET);
            logger.info("eventNum:" + events.getLength());
            for (int i = 0; i < events.getLength(); i++) {
                Element event = (Element) events.item(i);
                queue.add(url("/sendmail")
                    .param("id", xPath.evaluate("event_id", event))
                    .param("title", xPath.evaluate("title", event))
                    .param("catch", xPath.evaluate("catch", event))
//                    .param("description", xPath.evaluate("description", event))
                    .param("url", xPath.evaluate("event_url", event))
                    .param("started_at", xPath.evaluate("started_at", event))
                    .param("ended_at", xPath.evaluate("ended_at", event))
                    .param("limit", xPath.evaluate("limit", event))
                    .param("address", xPath.evaluate("address", event))
                    .param("place", xPath.evaluate("place", event))
                    .param("lat", xPath.evaluate("lat", event))
                    .param("lon", xPath.evaluate("lon", event))
                    .param("owner_id", xPath.evaluate("owner_id", event))
                    .param(
                        "owner_nickname",
                        xPath.evaluate("owner_nickname", event))
                    .param(
                        "owner_twitter_id",
                        xPath.evaluate("owner_twitter_id", event))
                    .param("accepted", xPath.evaluate("accepted", event))
                    .param("waiting", xPath.evaluate("waiting", event))
                    .param("updated_at", xPath.evaluate("updated_at", event)));
                
                logger.info("title:" + xPath.evaluate("title", event));
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

}
