package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.services;

import org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.models.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
