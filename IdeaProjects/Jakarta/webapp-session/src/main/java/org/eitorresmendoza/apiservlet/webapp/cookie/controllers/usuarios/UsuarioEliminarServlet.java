package org.eitorresmendoza.apiservlet.webapp.cookie.controllers.usuarios;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.Usuario;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.UsuarioService;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {
    @Inject
    private UsuarioService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Connection conn = (Connection) req.getAttribute("conn");
//        UsuarioService service = new UsuarioServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        if (id > 0) {
            Optional<Usuario> o = service.porId(id);
            if (o.isPresent()) {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/usuarios");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: el usuario no existe en la base de datos");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: el id del usuario es null, debe enviarse como parámetro en la url");
        }
    }
}
