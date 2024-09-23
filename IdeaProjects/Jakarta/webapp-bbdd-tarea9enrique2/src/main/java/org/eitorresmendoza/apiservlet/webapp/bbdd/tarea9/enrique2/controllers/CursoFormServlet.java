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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {
    @Inject
    private CursoService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }
        Curso curso = new Curso();
        if (id > 0){
            Optional<Curso> optionalCurso = service.porId(id);
            if (optionalCurso.isPresent()){
                curso = optionalCurso.get();
            }
        }
        req.setAttribute("curso", curso);
        req.setAttribute("titulo", id > 0 ? "Tarea 10 con estilos bootstrap. Editar curso": "Tarea 10 con estilos bootstrap. Crear curso");
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String instructor = req.getParameter("instructor");
        double duracion;
        try {
            duracion = Double.parseDouble(req.getParameter("duracion"));
        } catch (NumberFormatException e){
            duracion = 0D;
        }
        // validación formulario
        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()){
            errores.put("nombre", "el nombre no puede ser vacío");
        }
        if (descripcion == null || descripcion.isBlank()){
            errores.put("descripcion", "la descripción no puede ser vacía");
        }
        if (instructor == null || instructor.isBlank()){
            errores.put("instructor", "el instructor no puede ser vacío");
        }
        if (duracion <= 0 ){
            errores.put("duracion", "la duración no puede ser vacía ni con un valor menor o igual a cero. además debe tener un valor numérico(sin letras)");
        }
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0L;
        }
        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setInstructor(instructor);
        curso.setDuracion(duracion);

        if (errores.isEmpty()) {
            service.guardar(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("curso", curso);
            req.setAttribute("titulo", id > 0 ? "Tarea 10. Editar curso": "Tarea 10. Crear curso");
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
