package org.eitorresmendoza.anotaciones.ejemplo;

import org.eitorresmendoza.anotaciones.ejemplo.models.Producto;
import org.eitorresmendoza.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;
public class EjemploAnotacion {
    public static void main(String[] args) {
        
        Producto producto = new Producto();
        producto.setFecha(LocalDate.now());
        producto.setNombre("mesa de centro de roble");
        producto.setPrecio(1000L);

        System.out.println("json = " + JsonSerializador.convertirJson(producto));
    }
}
