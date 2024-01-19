package org.eitorresmendoza.carrosupermercado;

public class Lacteo extends Producto{
    private Integer cantidad, proteinas;

    public Lacteo(String nombre, Double precio, Integer cantidad, Integer proteinas) {
        super(nombre, precio);
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public Integer getProteinas() {
        return proteinas;
    }
}
