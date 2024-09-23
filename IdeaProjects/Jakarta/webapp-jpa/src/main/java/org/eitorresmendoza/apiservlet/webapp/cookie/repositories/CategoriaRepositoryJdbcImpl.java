package org.eitorresmendoza.apiservlet.webapp.cookie.repositories;

import jakarta.inject.Inject;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.MysqlConn;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.Repository;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RepositoryJdbc
@Repository
public class CategoriaRepositoryJdbcImpl implements org.eitorresmendoza.apiservlet.webapp.cookie.repositories.CrudRepository<Categoria> {

    private Connection conn;

    @Inject
    public CategoriaRepositoryJdbcImpl(@MysqlConn Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from categorias")) {
            while (resultSet.next()){
                Categoria categoria = getCategoria(resultSet);

                categorias.add(categoria);
            }

        }
        return categorias;
    }


    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement statement = conn.prepareStatement("select * from categorias as c where c.id = ?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){
                    categoria = getCategoria(resultSet);
                }
            }
        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }
    private static Categoria getCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNombre(resultSet.getString("nombre"));
        categoria.setId(resultSet.getLong("id"));
        return categoria;
    }
}
