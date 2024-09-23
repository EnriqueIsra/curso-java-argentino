package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.interceptors.TransactionalJdbc;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.models.Curso;
import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.repositories.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CursoServiceImpl implements CursoService {
    @Inject
    private Repository<Curso> repository;


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

    @Override
    public Optional<Curso> porId(Long id) {
        try {
            return Optional.ofNullable(repository.podId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    @TransactionalJdbc
    public void guardar(Curso curso) {
        try {
            repository.guardar(curso);
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    @TransactionalJdbc
    public void eliminar(Long id) {
        try {
            repository.eliminar(id);
        } catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
