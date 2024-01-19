package org.eitorresmendoza.poointerfaces.repositorio;

import org.eitorresmendoza.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion direccion);
}
