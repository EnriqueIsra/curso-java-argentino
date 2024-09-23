package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.services;

import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.models.Curso;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.repositories.CursoRepositorioImpl;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CursoServiceImpl implements CursoService{
    private Repository<Curso> repository;

    public CursoServiceImpl(Connection connection) {
        this.repository = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

}
