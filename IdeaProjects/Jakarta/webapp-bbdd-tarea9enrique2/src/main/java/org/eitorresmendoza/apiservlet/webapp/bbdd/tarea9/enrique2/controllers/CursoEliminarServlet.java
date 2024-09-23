package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.models.Curso;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.services.CursoService;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.services.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/cursos/eliminar")
public class CursoEliminarServlet extends HttpServlet {
    @Inject
    private CursoService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0L;
        }
        if (id > 0){
            Optional<Curso> optionalCurso = service.porId(id);
            if (optionalCurso.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/cursos");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: el curso no existe en la base de datos");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: el id del curso es null, debe enviarse como parámetro en la url");
        }
    }
}
