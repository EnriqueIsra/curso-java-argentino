package org.eitorresmendoza.poointerfaces.repositorio.lista;

import org.eitorresmendoza.poointerfaces.modelo.Cliente;
import org.eitorresmendoza.poointerfaces.modelo.Producto;
import org.eitorresmendoza.poointerfaces.repositorio.AbstractaListRepositorio;
import org.eitorresmendoza.poointerfaces.repositorio.Direccion;
import org.eitorresmendoza.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion direccion) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(direccion == Direccion.ASC){
                resultado = ordenar(campo, a, b);
            }else if (direccion == Direccion.DESC){
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }
    public static int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;
        switch (campo) {
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
