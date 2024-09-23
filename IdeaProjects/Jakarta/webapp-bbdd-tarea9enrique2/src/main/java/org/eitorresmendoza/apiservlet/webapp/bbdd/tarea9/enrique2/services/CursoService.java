package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.services;

import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
    Optional<Curso> porId(Long id);
    void guardar(Curso curso);
    void eliminar(Long id);
}
