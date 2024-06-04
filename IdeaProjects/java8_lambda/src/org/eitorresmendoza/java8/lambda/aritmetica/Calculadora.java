package org.eitorresmendoza.java8.lambda.aritmetica;

import java.util.function.BiFunction;

public class Calculadora {
    public double computar(double a, double b, Aritmetica lamda){
        return lamda.operacion(a, b);
    }

    public double computarConBiFuncion(double a, double b, BiFunction<Double, Double, Double> lamda){
        return lamda.apply(a, b);
    }
}
