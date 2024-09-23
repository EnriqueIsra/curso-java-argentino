package org.eitorresmendoza.apiservlet.webapp.cookie.services;

import jakarta.inject.Inject;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.ProductoServicePrincipal;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.Service;
import org.eitorresmendoza.apiservlet.webapp.cookie.interceptors.TransactionalJpa;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Categoria;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Producto;
import org.eitorresmendoza.apiservlet.webapp.cookie.repositories.CrudRepository;
import org.eitorresmendoza.apiservlet.webapp.cookie.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
@TransactionalJpa
public class ProductoServiceImpl implements ProductoService {
    @Inject
    @RepositoryJpa
    private CrudRepository<Producto> productoRepositoryJdbc;
    @Inject
    @RepositoryJpa
    private CrudRepository<Categoria> categoriaRepositoryJdbc;

//    public ProductoServiceJdbcImpl(Connection connection) {
//        this.productoRepositoryJdbc = new ProductoRepositoryJdbcImpl(connection);
//        this.categoriaRepositoryJdbc = new CategoriaRepositoryJdbcImpl(connection);
//    }

    @Override
    public List<Producto> listar() {
        try {
            return productoRepositoryJdbc.listar();
        } catch (Exception throwable) {
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
        } catch (Exception throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            productoRepositoryJdbc.guardar(producto);
        } catch (Exception throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            productoRepositoryJdbc.eliminar(id);
        } catch (Exception throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return categoriaRepositoryJdbc.listar();
        } catch (Exception throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(categoriaRepositoryJdbc.porId(id));
        } catch (Exception throwable) {
            throw new ServiceJdcbException(throwable.getMessage(), throwable.getCause());
        }
    }
}
