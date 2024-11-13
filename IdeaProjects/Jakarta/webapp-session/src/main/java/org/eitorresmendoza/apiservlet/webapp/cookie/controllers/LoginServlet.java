package org.eitorresmendoza.apiservlet.webapp.cookie.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.Usuario;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginService;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginServiceSessionImpl;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.UsuarioService;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.UsuarioServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {

    @Inject
    private UsuarioService service;
    @Inject
    private LoginService auth;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        if (usernameOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset = \"UTF-8\" >");
                out.println("        <title>Hola " + usernameOptional.get() + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + usernameOptional.get() + ", has iniciado sesión con éxito</h1>");
                out.println("           <p><a href='" + req.getContextPath() + "/index.jsp'>volver</a></p>");
                out.println("           <p><a href='" + req.getContextPath() + "/logout'>logout</a></p>");
                out.println("    </body>");
                out.println("</html>");

            }
        } else {
            req.setAttribute("title", req.getAttribute("title") + ": Login");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Usuario> usuarioOptional = service.login(username, password);

        if (usuarioOptional.isPresent()) {

            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no estas autorizado para ingresar a esta página");
        }
    }
}