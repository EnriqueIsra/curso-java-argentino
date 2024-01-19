package org.eitorresmendoza.carrosupermercado;

public class SinCaducidad extends Producto{
    private Integer contenido, calorias;
    public SinCaducidad(String nombre, Double precio, Integer contenido, Integer calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }
    public Integer getContenido() {
        return contenido;
    }
    public Integer getCalorias() {
        return calorias;
    }
}
