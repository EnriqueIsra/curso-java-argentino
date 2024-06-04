package org.eitorresmendoza.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {
        System.out.println("Stream ****************.");
        Stream<String> nombres = Stream.of("enrique", "ale", "santi", "sebas");
        nombres.forEach(System.out::println);

        System.out.println("Stream desde un arreglo ****************.");
        String[] unArreglo = {"enrique", "ale", "santi", "sebas"};
        nombres = Arrays.stream(unArreglo);
        nombres.forEach(System.out::println);

        System.out.println("StreamBuilder ****************.");
        Stream<String> nombresBuilder = Stream.<String>builder()
                .add("enrique")
                .add("ale")
                .add("santi")
                .add("sebas")
                .build();
        nombresBuilder.forEach(System.out::println);

        System.out.println("Stream desde una lista ****************.");

        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("enrique");
        listaNombres.add("ale");
        listaNombres.add("santi");
        listaNombres.add("sebas");

        Stream<String> nombresDeLista = listaNombres.stream();
        nombresDeLista.forEach(System.out::println);

        System.out.println("Iterando en Lista para abreviar código *****************");
        listaNombres.stream().forEach(System.out::println);
    }
}
