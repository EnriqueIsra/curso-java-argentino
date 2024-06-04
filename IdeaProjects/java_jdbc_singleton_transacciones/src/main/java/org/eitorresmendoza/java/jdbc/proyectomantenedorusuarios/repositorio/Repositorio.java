package org.eitorresmendoza.java.jdbc.proyectomantenedorusuarios.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();
    T buscarById(Long id);
    void guardar(T t);
    void eliminar(Long id);
}
