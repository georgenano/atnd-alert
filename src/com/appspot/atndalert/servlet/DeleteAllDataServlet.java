package com.appspot.atndalert.servlet;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.appspot.atndalert.meta.AtndEventMeta;
import com.google.appengine.api.datastore.Key;


@SuppressWarnings("serial")
public class DeleteAllDataServlet extends HttpServlet {
    static final AtndEventMeta atndEventMeta = AtndEventMeta.get();
    private static Logger logger = Logger.getLogger(SendMailQueue.class
        .getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.getWriter().println("Start delete.");
        List<Key> keys = Datastore.query(atndEventMeta).asKeyList();
        int i = 0;
        for(Key key : keys){
            Datastore.deleteAll(key);
            logger.info("delete:" + i);
        }
        
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        
    }

}
