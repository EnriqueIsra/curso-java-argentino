package org.eitorresmendoza.apiservlet.webapp.cookie.controllers;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.ProductoServicePrincipal;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.Carro;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.ItemCarro;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.Producto;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.ProductoService;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.ProductoServiceImpl;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/carro/agregar"})
public class AgregarCarroServlet extends HttpServlet {
    @Inject
    @ProductoServicePrincipal
    private ProductoService service;
    @Inject
    private Carro carro;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
//        Connection conn = (Connection) req.getAttribute("conn");
//        ProductoService service = new ProductoServiceJdbcImpl(conn);
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
//            HttpSession session = req.getSession();
//            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
