package org.eitorresmendoza.poointerfaces.repositorio;

import org.eitorresmendoza.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements AllRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>(); // se debe inicializar el array que se utilizará para la lista dataSource
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        T clienteFind = null;
        for (T clienteLookFor: dataSource){
            if(clienteLookFor.getId() != null && clienteLookFor.getId().equals(id)){
                clienteFind = clienteLookFor;
                break;
            }
        }
        return clienteFind;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
