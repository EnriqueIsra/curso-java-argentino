package org.eitorresmendoza.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eitorresmendoza.webapp.ejb.models.Producto;
import org.eitorresmendoza.webapp.ejb.services.ServiceEjb;
import org.eitorresmendoza.webapp.ejb.services.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {
//        @Inject
//        private ServiceEjbLocal service;

//        @Inject
//        private ServiceEjbLocal service2;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjbLocal service = null;
        ServiceEjbLocal service2 = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.eitorresmendoza.webapp.ejb.services.ServiceEjbLocal");
            service2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.eitorresmendoza.webapp.ejb.services.ServiceEjbLocal");
        } catch (NamingException e) {
                throw new RuntimeException(e);
        }

        Producto p = service.crear(new Producto("uvas"));
        System.out.println("nuevo producto " + p);

        System.out.println("service igual a service2 ?: " + service.equals(service2));
        req.setAttribute("saludo", service.saludar("Enrique"));
        req.setAttribute("saludo2", service2.saludar("Santi"));
        req.setAttribute("listado", service2.listar());

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
