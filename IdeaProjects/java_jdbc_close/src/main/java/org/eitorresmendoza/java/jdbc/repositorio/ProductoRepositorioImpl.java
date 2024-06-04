package org.eitorresmendoza.java.jdbc.repositorio;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;
import org.eitorresmendoza.java.jdbc.util.ConexionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionDataBase.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try (Connection connection = getConnection();
            Statement sentencia = connection.createStatement();
             ResultSet resultSet = sentencia.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id)")){
            while (resultSet.next()) {
                Producto producto = crearProducto(resultSet);
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement
                     ("SELECT p.*, c.nombre as categoria FROM productos as p " +
                        "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            sentencia.setLong(1, id);
            try (ResultSet resultSet = sentencia.executeQuery()) {
                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES (?, ?, ?, ?)";
        }
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)){
            sentencia.setString(1, producto.getNombre());
            sentencia.setLong(2, producto.getPrecio());
            sentencia.setLong(3, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0) {
                sentencia.setLong(4, producto.getId());
            }
                else{
                    sentencia.setDate(4, new Date(producto.getFechaRegistro().getTime()));
                }
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement("DELETE FROM productos WHERE id = ?")){
            sentencia.setLong(1, id);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getInt("precio"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setNombre(resultSet.getString("categoria"));
        producto.setCategoria(categoria);
        return producto;
    }
}
