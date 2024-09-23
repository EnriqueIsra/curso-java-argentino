package org.eitorresmendoza.webapp.form.tarea2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet({"/crear", ""})
public class RegistroProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String nombre = req.getParameter("nombre");
        String fabricante = req.getParameter("fabricante");
        Integer precio = null;
        try {
            precio = Integer.valueOf(req.getParameter("precio"));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        Integer categoria = null;

        try {
            categoria = Integer.valueOf(req.getParameter("categoria"));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }


        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank()){
            errores.put("nombre", "El nombre del producto es requerido");
        }
        if (fabricante == null || fabricante.isBlank()){
            errores.put("fabricante", "El fabricante es requerido");
        } else if ( !(fabricante.length() >= 4) ) {
            errores.put("fabricante", "El fabricante no puede tener menos de 4 caracteres");
        } else if ( !(fabricante.length() <= 10) ) {
            errores.put("fabricante", "El fabricante no puede tener más de 10 caracteres");
        }
        if (precio == null){
            errores.put("precio", "El precio es requerido y debe ser un valor numérico");
        } else if (precio == 0) {
            errores.put("precio", "El precio no puede ser de 0");
        } else if (precio < 0) {
            errores.put("precio", "El precio no puede tener un valor negativo");
        }
        if (categoria == null){
            errores.put("categoria", "La categoría es requerida");
        }

        if (errores.isEmpty()){
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("       <meta charset = \"UTF-8\" >");
                out.println("       <title>Resultado form</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Resultado form</h1>");
                out.println("       <ul>");
                out.println("           <li>Nombre del producto: " + nombre + "</li>");
                out.println("           <li>Precio : $" + precio + "</li>");
                out.println("           <li>Fabricante: " + fabricante + "</li>");
                out.println("           <li>Categoría: " + categoria + "</li>");
                out.println("       </ul>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
