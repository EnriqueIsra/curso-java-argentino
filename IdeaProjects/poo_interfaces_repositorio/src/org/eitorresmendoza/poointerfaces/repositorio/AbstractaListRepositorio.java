package org.eitorresmendoza.poointerfaces.repositorio;

import org.eitorresmendoza.poointerfaces.modelo.BaseEntity;
import org.eitorresmendoza.poointerfaces.repositorio.excepciones.*;
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
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if ( id == null || id <= 0){
            throw new LecturaAccesoDatoException("Id inválido, debe ser mayor que cero.");
        }
        T clienteFind = null;
        for (T clienteLookFor: dataSource){
            if(clienteLookFor.getId() != null && clienteLookFor.getId().equals(id)){
                clienteFind = clienteLookFor;
                break;
            }
        }
        if (clienteFind == null){
            throw new LecturaAccesoDatoException("No existe el registro con id: " + id);
        }
        return clienteFind;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if(t == null){
            throw new EscrituraAccesoDatoException("Error, no se puede insertar un objeto nulo");
        }
        if (this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error, el objeto con id " +
                    t.getId() + " ya existe en el repositorio");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException{
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
