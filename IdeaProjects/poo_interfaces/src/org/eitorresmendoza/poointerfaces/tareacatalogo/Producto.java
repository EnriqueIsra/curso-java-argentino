package org.eitorresmendoza.poointerfaces.tareacatalogo;

public abstract class Producto implements IProducto{
    int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }
}
