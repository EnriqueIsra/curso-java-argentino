package org.eitorresmendoza.java.jdbc;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;
import org.eitorresmendoza.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.Repositorio;
import org.eitorresmendoza.java.jdbc.servicio.CatalogoServicio;
import org.eitorresmendoza.java.jdbc.servicio.Servicio;
import org.eitorresmendoza.java.jdbc.util.ConexionDataBase;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("============ listar ============");
        servicio.listarProducto().forEach(System.out::println);

        Categoria catIluminacion = servicio.buscarCategoriaById(13L);
        Categoria catDeporte = servicio.buscarCategoriaById(1L);

        System.out.println("============ insertar nuevo producto ============");
        Producto producto = new Producto();
        producto.setNombre("Balon de Basket Jordan");
        producto.setPrecio(1200);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefghij");

        servicio.guardarProductoConCategoria(producto, catDeporte);
        System.out.println("Producto guardado exitosamente con id = " + producto.getId());
        System.out.println("Guardado en la categoría " + catDeporte.getNombre());
        servicio.listarProducto().forEach(System.out::println);
    }
}
