package org.eitorresmendoza.poointerfaces.repositorio;

import org.eitorresmendoza.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
