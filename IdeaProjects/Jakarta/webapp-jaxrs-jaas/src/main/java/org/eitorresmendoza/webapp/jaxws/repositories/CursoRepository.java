package org.eitorresmendoza.webapp.jaxws.repositories;

import org.eitorresmendoza.webapp.jaxws.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Curso porId(Long id);
    void eliminar(Long id);
}
