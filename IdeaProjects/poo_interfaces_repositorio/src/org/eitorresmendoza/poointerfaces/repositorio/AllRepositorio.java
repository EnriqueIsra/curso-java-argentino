package org.eitorresmendoza.poointerfaces.repositorio;

public interface AllRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>,
        CrudRepositorio<T>, ContableRepositorio {
}
