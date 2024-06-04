package org.eitorresmendoza.api.stream.ejemplos.tareas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tarea33 {
    public static void main(String[] args) {
        String[][] lenguajes = {{"java", "javascript"}, {"groovy", "c#", "java", "php"},
                {"html", "css", "javascript"}, {"c#", "c++"}, {"kotlin", "php", "java"}, {"css", "python"}, {}};
        Arrays.stream(lenguajes)
                .flatMap(arreglo -> Arrays.stream(arreglo))
                .distinct()
                .forEach(System.out::println);

        // otro modo usando Funcion lambda
        System.out.println("*****************");
        String[][] lenguajes2 = {{"java", "javascript"}, {"groovy", "c#", "java", "php"},
                {"html", "css", "javascript"}, {"c#", "c++"}, {"kotlin", "php", "java"}, {"css", "python"}, {}};
        Function<String[][], List<String>> flatten = arr -> Arrays.stream(arr).flatMap(a -> Arrays.stream(a))
                .distinct()
                .collect(Collectors.toList());

        flatten.apply(lenguajes2).forEach(System.out::println);
    }
}
