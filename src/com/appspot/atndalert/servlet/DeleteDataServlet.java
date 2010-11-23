package com.appspot.atndalert.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;


@SuppressWarnings("serial")
public class DeleteDataServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String[] keyStrs = req.getParameterValues("key");
        for(String keyStr : keyStrs){
            Key key = Datastore.stringToKey(keyStr);
            Datastore.deleteAll(key);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("./refer");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
