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
public class ReferenceAlertWordServlet extends HttpServlet {
    static final AlertWordMeta meta = AlertWordMeta.get();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
        doPost(req, resp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        UserService service = UserServiceFactory.getUserService();
        User user = service.getCurrentUser();
        String loginName = user.getNickname();
        String mailAddress = user.getEmail();

        List<AlertWord> aws =
            Datastore
                .query(meta)
                .filter(
                    meta.loginName.equal(loginName),
                    meta.mailAddress.equal(mailAddress))
                .asList();
        req.setAttribute("alertWords", aws);
        
        RequestDispatcher rd = req.getRequestDispatcher("./referenceAlertWords.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
