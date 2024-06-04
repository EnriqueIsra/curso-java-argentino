package org.eitorresmendoza.java.jdbc;

import org.eitorresmendoza.java.jdbc.modelo.Producto;
import org.eitorresmendoza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.Repositorio;
import org.eitorresmendoza.java.jdbc.util.ConexionDataBase;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        try (Connection connection = ConexionDataBase.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

            System.out.println("============ listar ============");
            repositorio.listar().forEach(System.out::println);


            System.out.println("============ obtener por id ============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============ eliminar producto ============");
            repositorio.eliminar(3L);
            System.out.println("producto eliminado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
