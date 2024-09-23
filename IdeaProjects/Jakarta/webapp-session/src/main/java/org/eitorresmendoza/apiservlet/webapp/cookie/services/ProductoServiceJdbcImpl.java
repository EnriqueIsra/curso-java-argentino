package org.eitorresmendoza.apiservlet.webapp.cookie.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.ProductoServicePrincipal;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.Service;
import org.eitorresmendoza.apiservlet.webapp.cookie.interceptors.Logging;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.Categoria;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.Producto;
import org.eitorresmendoza.apiservlet.webapp.cookie.repositories.CrudRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
public class ProductoServiceJdbcImpl implements ProductoService {
    @Inject
    private CrudRepository<Producto> productoRepositoryJdbc;
    @Inject
    private CrudRepository<Categoria> categoriaRepositoryJdbc;

//    public ProductoServiceJdbcImpl(Connection connection) {
//        this.productoRepositoryJdbc = new ProductoRepositoryJdbcImpl(connection);
//        this.categoriaRepositoryJdbc = new CategoriaRepositoryJdbcImpl(connection);
//    }

    @Override
    public List<Producto> listar() {
        try {
            return productoRepositoryJdbc.listar();
        } catch (SQLException throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(productoRepositoryJdbc.porId(id));
        } catch (SQLException throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            productoRepositoryJdbc.guardar(producto);
        } catch (SQLException throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            productoRepositoryJdbc.eliminar(id);
        } catch (SQLException throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return categoriaRepositoryJdbc.listar();
        } catch (SQLException throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(categoriaRepositoryJdbc.porId(id));
        } catch (SQLException throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }
}
