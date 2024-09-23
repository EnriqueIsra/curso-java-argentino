package org.eitorresmendoza.apiservlet.webapp.cookie.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginService;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginServiceCookieImpl;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    private LoginService auth;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
