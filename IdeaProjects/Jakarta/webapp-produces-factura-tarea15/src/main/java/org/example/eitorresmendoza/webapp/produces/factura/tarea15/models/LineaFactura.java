package org.example.eitorresmendoza.webapp.produces.factura.tarea15.models;

public class LineaFactura {
    private Producto producto;
    private Integer cantidad;

    public LineaFactura(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public Double calcularImporte(){
        return cantidad * producto.getPrecio();
    }
}
