package org.eitorresmendoza.apiservlet.webapp.headers.services;

import org.eitorresmendoza.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> buscarProducto(String nombre);
}
