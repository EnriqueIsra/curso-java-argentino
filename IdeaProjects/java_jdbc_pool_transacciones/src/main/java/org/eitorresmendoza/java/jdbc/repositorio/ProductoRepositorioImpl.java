package org.eitorresmendoza.java.jdbc.repositorio;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection conexion;

    public ProductoRepositorioImpl(Connection connection) {
        this.conexion = connection;
    }

    public ProductoRepositorioImpl() {
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Statement sentencia = conexion.createStatement();
             ResultSet resultSet = sentencia.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id)")) {
            while (resultSet.next()) {
                Producto producto = crearProducto(resultSet);
                productos.add(producto);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement sentencia = conexion.prepareStatement
                     ("SELECT p.*, c.nombre as categoria FROM productos as p " +
                             "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            sentencia.setLong(1, id);
            try (ResultSet resultSet = sentencia.executeQuery()) {
                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }
            }

        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=?, sku=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, sku, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        }
        try (PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            sentencia.setString(1, producto.getNombre());
            sentencia.setLong(2, producto.getPrecio());
            sentencia.setLong(3, producto.getCategoria().getId());
            sentencia.setString(4, producto.getSku());

            if (producto.getId() != null && producto.getId() > 0) {
                sentencia.setLong(5, producto.getId());
            } else {
                sentencia.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }
            sentencia.executeUpdate();

            if (producto.getId() == null){
                try (ResultSet resultSet = sentencia.getGeneratedKeys()) {
                    if (resultSet.next()){
                        producto.setId(resultSet.getLong(1));
                    }
                }
            }
        }
        return producto;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM productos WHERE id = ?")) {
            sentencia.setLong(1, id);
            sentencia.executeUpdate();
        }
    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getInt("precio"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro"));
        producto.setSku(resultSet.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setNombre(resultSet.getString("categoria"));
        producto.setCategoria(categoria);
        return producto;
    }
}
