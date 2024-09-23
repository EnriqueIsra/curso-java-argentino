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
import java.util.List;

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {
    @Inject
    private CursoService service;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");

        List<Curso> cursos = service.porNombre(nombre);
        req.setAttribute("titulo", "Tarea 9. Listado de cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
