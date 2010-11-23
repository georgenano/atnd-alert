package com.appspot.atndalert.servlet;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.atndalert.model.AtndEvent;
import com.appspot.atndalert.util.AtndEventParser;


public class SearchAtndEventServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(SearchAtndEventServlet.class
        .getName());
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String keyWord = req.getParameter("alertWord");     
        String urlStr = "http://api.atnd.org/events/?keyword=" + keyWord + "&count=5&format=xml";
        List<AtndEvent> aes = AtndEventParser.parseAtndEvent(urlStr);
        
        req.setAttribute("searchResult", aes);
        RequestDispatcher rd = req.getRequestDispatcher("./registResult.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
