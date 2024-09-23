package org.eitorresmendoza.appmockito3.ejemplo.repositories;

import java.util.List;

public interface PreguntaRepository {

    List<String> findPreguntaPorExamenId(Long Id);
    void guardarVarias(List<String> preguntas);
}
