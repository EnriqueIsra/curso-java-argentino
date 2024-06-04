package org.eitorresmendoza.optional.ejemplo.repositorio;

import org.eitorresmendoza.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar (String nombre);
}
