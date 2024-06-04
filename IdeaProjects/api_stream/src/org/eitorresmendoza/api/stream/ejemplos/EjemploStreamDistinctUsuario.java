package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {
        IntStream largoNombres = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres",
                        "enrique torres", "enrique torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);
        IntSummaryStatistics estadisticas = largoNombres.summaryStatistics();
        System.out.println("total: " + estadisticas.getCount());
        System.out.println("máximo: " + estadisticas.getMax());
        System.out.println("mínimo: " + estadisticas.getMin());
        System.out.println("promedio: " + estadisticas.getAverage());
    }
}
