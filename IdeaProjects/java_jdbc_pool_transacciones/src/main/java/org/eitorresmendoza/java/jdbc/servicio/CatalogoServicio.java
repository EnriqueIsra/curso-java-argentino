package org.eitorresmendoza.java.jdbc.servicio;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;
import org.eitorresmendoza.java.jdbc.modelo.Producto;
import org.eitorresmendoza.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eitorresmendoza.java.jdbc.repositorio.Repositorio;
import org.eitorresmendoza.java.jdbc.util.ConexionDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoServicio implements Servicio{
    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoServicio() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listarProducto() throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            productoRepositorio.setConexion(conexion);
            return productoRepositorio.listar();
        }
    }

    @Override
    public Producto buscarProductoById(Long id) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            productoRepositorio.setConexion(conexion);
            return productoRepositorio.porId(id);

        }
    }

    @Override
    public Producto guardarProducto(Producto producto) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            productoRepositorio.setConexion(conexion);
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try {
                nuevoProducto = productoRepositorio.guardar(producto);
                conexion.commit();
            } catch (SQLException e){
                conexion.rollback();
                e.printStackTrace();
            }
            return nuevoProducto;
        }
    }

    @Override
    public void eliminarProducto(Long id) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            productoRepositorio.setConexion(conexion);
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            try {
                productoRepositorio.eliminar(id);
                conexion.commit();
            } catch (SQLException e){
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            categoriaRepositorio.setConexion(conexion);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria buscarCategoriaById(Long id) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            categoriaRepositorio.setConexion(conexion);
            return categoriaRepositorio.porId(id);
        }
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            categoriaRepositorio.setConexion(conexion);
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try {
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                conexion.commit();
            } catch (SQLException e){
                conexion.rollback();
                e.printStackTrace();
            }
            return nuevaCategoria;
        }
    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            categoriaRepositorio.setConexion(conexion);
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            try {
                categoriaRepositorio.eliminar(id);
                conexion.commit();
            } catch (SQLException e){
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try (Connection conexion = ConexionDataBase.getConexion()) {
            productoRepositorio.setConexion(conexion);
            categoriaRepositorio.setConexion(conexion);
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            try {
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                productoRepositorio.guardar(producto);
                conexion.commit();
            } catch (SQLException e){
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }
}
