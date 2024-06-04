package org.eitorresmendoza.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {
        Stream<String > nombres = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres",
                        "sebas torres",
                        "sebas torres",
                        "sebas torres")
                .distinct();

        String resultado = nombres.reduce("Resultado de concatenación ", (a, b) -> a + " # " + b);
        System.out.println(resultado);

    }
}
