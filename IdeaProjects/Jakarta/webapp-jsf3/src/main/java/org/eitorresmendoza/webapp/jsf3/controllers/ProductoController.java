package org.eitorresmendoza.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eitorresmendoza.webapp.jsf3.entities.Producto;
import org.eitorresmendoza.webapp.jsf3.services.ProductoService;

import java.util.Arrays;
import java.util.List;

@Model
public class ProductoController {

    @Inject
    private ProductoService service;

    @Produces
    @Model
    public String titulo (){
        return "Hola mundo JavaServer Face 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll(){
//        return Arrays.asList(new Producto("preas"), new Producto("manzanas"), new Producto("mandarinas"));
        return service.listar();
    }
}
