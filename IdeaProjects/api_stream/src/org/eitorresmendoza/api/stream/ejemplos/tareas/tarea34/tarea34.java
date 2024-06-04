package org.eitorresmendoza.api.stream.ejemplos.tareas.tarea34;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class tarea34 {
    public static void main(String[] args) {
        Random precioRandom = new Random();
        Random cantidadRandom = new Random();
        Producto[] arregloProductos = new Producto[5];
        for (int i = 0; i < arregloProductos.length; i++) {
            arregloProductos[i] = new Producto(precioRandom.nextDouble(100), cantidadRandom.nextInt(1, 6));
            System.out.println("Producto " + (i + 1) + ": " + arregloProductos[i].toString());
        }

        List<Producto> facturas = Arrays.asList(arregloProductos);
        double total = facturas.stream()
                .map(p -> p.getCantidad() * p.getPrecio())
                .reduce(0d, Double::sum);
        System.out.println("total = " + total);
    }
}
