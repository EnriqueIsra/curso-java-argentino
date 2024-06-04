package org.eitorresmendoza.java8.lambda;

import org.eitorresmendoza.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
            System.out.println("nombre: " + nombre + "\nEdad: " + edad + " años");
        };
        consumidorBi.accept("Enrique", 20);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("pepe", "luz", "vicky", "sebas", "santi");
        nombres.forEach(consumidor2);

        Supplier<Usuario> crearUsario = Usuario::new;
        Usuario usuario = crearUsario.get();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Enrique");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola mundo lambda Supplier";
        System.out.println(proveedor.get());
    }
}
