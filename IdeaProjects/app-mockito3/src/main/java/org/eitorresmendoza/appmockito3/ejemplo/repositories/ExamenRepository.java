package org.eitorresmendoza.appmockito3.ejemplo.repositories;

import org.eitorresmendoza.appmockito3.ejemplo.models.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen guardar(Examen examen);
    List<Examen> findAll();
}
