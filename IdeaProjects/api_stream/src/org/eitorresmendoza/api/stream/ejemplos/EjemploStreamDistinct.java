package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {
        Stream<String > nombres = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres",
                        "sebas torres",
                        "sebas torres",
                        "sebas torres")
                .distinct();
        nombres.forEach(System.out::println);


    }
}
