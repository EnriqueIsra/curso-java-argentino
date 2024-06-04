package org.eitorresmendoza.java.jdbc;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;
import org.eitorresmendoza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.Repositorio;
import org.eitorresmendoza.java.jdbc.util.ConexionDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection connection = ConexionDataBase.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println("============ listar ============");
            repositorio.listar().forEach(System.out::println);


            System.out.println("============ obtener por id ============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============ editar producto ============");
            Producto producto = new Producto();
            producto.setId(4L);
            producto.setNombre("Teclado corsair k95 mecánico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("producto editado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
