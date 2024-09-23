package org.eitorresmendoza.apiservlet.webapp.cookie.services;

import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Categoria;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Alternative
public class ProductoServiceImplList implements ProductoService {
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

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
