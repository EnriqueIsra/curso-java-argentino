package org.eitorresmendoza.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamReduceRange {
    public static void main(String[] args) {
        IntStream rangoNumeros = IntStream.range(5, 20).peek(System.out::println); // definimos el rango con .range
        IntStream rangoNumerosRangeClosed = IntStream.rangeClosed(5, 20).peek(System.out::println); // definimos el rango con .range

        // int resultado = rangoNumeros.reduce(0, Integer::sum);
        // System.out.println("resultado = " + resultado);
        // int resultado = rangoNumeros.sum();
        // System.out.println("resultado = " + resultado);
        IntSummaryStatistics estadisticas = rangoNumeros.summaryStatistics();
        System.out.println("máximo = " + estadisticas.getMax() );
        System.out.println("mínimo = " + estadisticas.getMin() );
        System.out.println("suma = " + estadisticas.getSum() );
        System.out.println("promedio = " + estadisticas.getAverage() );
        System.out.println("total = " + estadisticas.getCount() );




    }
}
