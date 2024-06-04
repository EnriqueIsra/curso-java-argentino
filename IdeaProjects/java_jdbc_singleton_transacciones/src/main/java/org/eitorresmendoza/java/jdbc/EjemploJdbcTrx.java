package org.eitorresmendoza.java.jdbc;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;
import org.eitorresmendoza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.Repositorio;
import org.eitorresmendoza.java.jdbc.util.ConexionDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConexionDataBase.getInstance()) {

            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

                System.out.println("============ listar ============");
                repositorio.listar().forEach(System.out::println);


                System.out.println("============ obtener por id ============");
                System.out.println(repositorio.porId(1L));

                System.out.println("============ insertar nuevo producto");
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM mecánico");
                producto.setPrecio(1550);
                producto.setFechaRegistro(new Date());

                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);

                producto.setSku("abcde12344");

                repositorio.guardar(producto);
                System.out.println("producto guardado con éxito");

                System.out.println("============ editar producto ============");
                producto = new Producto();
                producto.setId(5L);
                producto.setNombre("Teclado corsair k95 mecánico");
                producto.setPrecio(1000);
                producto.setSku("abcdef1234");
                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);

                repositorio.guardar(producto);
                System.out.println("producto editado con éxito");
                repositorio.listar().forEach(System.out::println);

                connection.commit();

            } catch (SQLException exception) {
                connection.rollback();
                exception.printStackTrace();
            }
        }
    }
}
