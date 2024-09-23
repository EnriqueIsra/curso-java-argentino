package org.example.eitorresmendoza.webapp.produces.factura.tarea15.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.example.eitorresmendoza.webapp.produces.factura.tarea15.models.LineaFactura;
import org.example.eitorresmendoza.webapp.produces.factura.tarea15.models.Producto;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ProduceResources {

    @Produces
    private List<LineaFactura> beansLineas(){
        Producto producto1 = new Producto("Monitor Samgsung", 3500D);
        Producto producto2 = new Producto("Escritorio LG", 6000D);
        Producto producto3 = new Producto("Laptop Acer Aspire", 15000D);
        Producto producto4 = new Producto("Mouse Logitec", 300D);

        LineaFactura linea1 = new LineaFactura(producto1, 5);
        LineaFactura linea2 = new LineaFactura(producto2, 5);
        LineaFactura linea3 = new LineaFactura(producto3, 10);
        LineaFactura linea4 = new LineaFactura(producto4, 10);

        return Arrays.asList(linea1, linea2, linea3, linea4);
    }

}
