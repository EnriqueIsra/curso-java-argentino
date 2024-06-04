package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {
        long count = Stream
                .of("","ale sanchez", "", "sebas torres")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();
        System.out.println("count = " + count);

    }
}
