package org.eitorresmendoza.java.jdbc.servicio;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Servicio {
    List<Producto> listarProducto() throws SQLException;
    Producto buscarProductoById(Long id) throws SQLException;
    Producto guardarProducto(Producto producto) throws SQLException;
    void eliminarProducto(Long id) throws SQLException;


    List<Categoria> listarCategoria() throws SQLException;
    Categoria buscarCategoriaById(Long id) throws SQLException;
    Categoria guardarCategoria(Categoria categoria) throws SQLException;
    void eliminarCategoria(Long id) throws SQLException;
    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;
}
