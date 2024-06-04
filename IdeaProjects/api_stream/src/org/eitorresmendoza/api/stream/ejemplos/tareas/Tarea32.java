package org.eitorresmendoza.api.stream.ejemplos.tareas;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Tarea32 {
    public static void main(String[] args) {
        Function<Integer[], Integer> max = arr -> Arrays.stream(arr).reduce(0, (a, b) ->
            (a > b) ? a : b);

        Random numeroRandom = new Random();

        Integer[] arregloNumerosRandom = new Integer[10];
        for (int i = 0; i < arregloNumerosRandom.length; i++) {
            arregloNumerosRandom[i] = numeroRandom.nextInt(500);
            System.out.println("número " + (i + 1) + ": " + arregloNumerosRandom[i]);
        }

        int resultado = max.apply(arregloNumerosRandom);
        System.out.println("el número mayor es: " + resultado);
    }
}
