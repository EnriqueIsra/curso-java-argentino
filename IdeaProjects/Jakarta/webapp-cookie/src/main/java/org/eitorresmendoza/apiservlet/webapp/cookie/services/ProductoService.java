package org.eitorresmendoza.apiservlet.webapp.cookie.services;

import org.eitorresmendoza.apiservlet.webapp.cookie.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> buscarProducto(String nombre);
}