package org.eitorresmendoza.appmockito3.ejemplo.services;

import org.eitorresmendoza.appmockito3.ejemplo.models.Examen;

import java.util.Optional;

public interface ExamenService {
    Optional<Examen> findExamenPorNombre(String nombre);
    Examen findExamenPorNombreConPreguntas(String nombre);

    Examen guardarExamen(Examen examen);
}
