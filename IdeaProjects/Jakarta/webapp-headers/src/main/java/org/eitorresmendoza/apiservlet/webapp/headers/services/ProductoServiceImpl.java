package org.eitorresmendoza.apiservlet.webapp.headers.services;

import org.eitorresmendoza.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L, "notebook", "computacion", 45000),
                new Producto(2L, "escritorio vidrio", "oficina", 98000),
                new Producto(3L, "teclado mecanico", "computacin", 32000));
    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {
        return listar().stream().filter(p -> {
            if (nombre == null || nombre.isBlank()) {
                return false;
            }
            return p.getNombre().contains(nombre);
        }).findFirst();
    }
}
