package org.eitorresmendoza.api.stream.ejemplos.tareas;

import java.util.Arrays;

public class Tarea31 {
    public static void main(String[] args) {
        int[] arregloDe100 = new int[100];

        for (int i = 0; i < arregloDe100.length; i++){
            arregloDe100[i] = i + 1;
        }
        double total = Arrays.stream(arregloDe100)
                .filter(value -> value % 10 != 0)
                .mapToDouble(value -> (double) value/2)
                .reduce(0, (a, b) -> a + b);


        System.out.println("total = " + total);

    }
}
