package org.eitorresmendoza.java8.lambda;

import org.eitorresmendoza.java8.lambda.aritmetica.Aritmetica;
import org.eitorresmendoza.java8.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {
        Aritmetica suma = Double::sum;
        Aritmetica resta = (a, b) -> a - b;

        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.computar(10, 5, suma));
        System.out.println(calculadora.computar(10, 5, resta));
        System.out.println(calculadora.computar(10, 5, (a, b) -> a * b));

        System.out.println(calculadora.computarConBiFuncion(10, 5, (aDouble, aDouble2) -> aDouble + aDouble2 ));
    }
}
