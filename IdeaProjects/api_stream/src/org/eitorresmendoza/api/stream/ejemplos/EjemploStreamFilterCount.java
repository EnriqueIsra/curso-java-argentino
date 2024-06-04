package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {
        long existe = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .count();
        System.out.println(existe);

    }
}
