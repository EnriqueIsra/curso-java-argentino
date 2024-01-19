package org.eitorresmendoza.carrosupermercado;

import java.util.ArrayList;
import java.util.List;

public class BolsaSuperMercado<T> {

    private List<T> productos;
    private int indiceProductos;
    private int max = 5;

    public BolsaSuperMercado(){
        this.productos = new ArrayList<>();
    }
    public void addProducto(T genericProduct){
        if (this.productos.size() <= max){
            this.productos.add(genericProduct);
        } else {
            throw new RuntimeException("No hay más espacio en la boulsa.");
        }
    }

    public List<T> getProductos() {
        return productos;
    }
}
