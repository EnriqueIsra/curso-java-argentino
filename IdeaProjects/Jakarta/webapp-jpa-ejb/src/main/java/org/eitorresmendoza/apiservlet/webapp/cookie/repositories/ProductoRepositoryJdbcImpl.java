package org.eitorresmendoza.apiservlet.webapp.cookie.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.MysqlConn;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.Repository;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Categoria;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
@RepositoryJdbc
public class ProductoRepositoryJdbcImpl implements CrudRepository<Producto> {

    @Inject
    private Logger log;


    @Inject
    @MysqlConn
//    @Named("conn")
    private Connection conn;

//    public ProductoRepositoryJdbcImpl(Connection conn) {
//        this.conn = conn;
//    }

    @PostConstruct
    public void inicializar(){
        log.info("inicializando el beans " + this.getClass().getName());
    }

    @PreDestroy
    public void destruir(){
        log.info("destruyendo el beans " + getClass().getName());
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Statement sentencia = conn.createStatement();
             ResultSet rs = sentencia.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     " inner join categorias as c ON (p.categoria_id = c.id) order by p.id ASC")) {
            while (rs.next()) {
                Producto p = getProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }


    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement sentencia = conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ? ")) {
            sentencia.setLong(1, id);
            try (ResultSet rs = sentencia.executeQuery()) {
                if (rs.next()) {
                    producto = getProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "update productos set nombre=?, precio=?, sku=?, categoria_id=? where id=?";
        } else {
            sql = "insert into productos (nombre, precio, sku, categoria_id, fecha_registro) values (?,?,?,?,?) ";
        }
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getPrecio());
            statement.setString(3, producto.getSku());
            statement.setLong(4, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0) {
                statement.setLong(5, producto.getId());
            } else {
                statement.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }
            statement.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from productos where id=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    private static Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setSku(rs.getString("sku"));
        p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        Categoria c = new Categoria();
        c.setId(rs.getLong("categoria_id"));
        c.setNombre(rs.getString("categoria"));
        p.setCategoria(c);
        return p;
    }
}
