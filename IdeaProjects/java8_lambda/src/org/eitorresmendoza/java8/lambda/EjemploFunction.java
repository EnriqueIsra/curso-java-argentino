package org.eitorresmendoza.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        Function<String, String> function1 = param -> "Hola que tal " + param;
        String resultado = function1.apply("Enrique");
        System.out.println(resultado);

        Function<String, String> function2 = String::toUpperCase;
        System.out.println(function2.apply("enrique"));

        BiFunction<String, String, String> function3 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        String resultadoF3 = function3.apply("enrique ", "torres");
        System.out.println(resultadoF3);

        BiFunction<String, String, Integer> function4 = String::compareTo; //(a, b) -> a.compareTo(b);
        System.out.println(function4.apply("enrique", "enrique"));

        BiFunction<String, String, String> function5 = String::concat; //(a, b) -> a.concat(b);
        System.out.println(function5.apply("enrique ", "torres"));
    }
}
