package org.eitorresmendoza.java8.lambda.tareas;

import java.util.Collections;

public class LambdaTarea2ContarPalabrasDeFrase {
    public static void main(String[] args) {
        LamdaTarea2ContarPalabrasRepetidas contadorPalabras = frase -> {
            // hay que limpiar la frase eliminando espacios, puntos, comas y dejar en minúsculas
            // luego usando split convertimos la frase en un arreglo para iterarlo
            String[] arregloFrase = frase.replace(".", "")
                    .replace(",", "")
                    .toLowerCase()
                    .split(" ");
            // con un for doble iteramos cada palabra y la comparamos con cada una del arreglo
            // asi podemos calcular el máximo que se repite una palabra
            // definimos una variable para guardar la palabra más repetida y otra para calcular el número de veces que se repite
            int maxima = 0;
            String palabra = null;
            for (int i = 0; i < arregloFrase.length; i++) {
                int cantidad = 0;
                for (int j = 0; j < arregloFrase.length; j++) {
                    if (arregloFrase[i].equalsIgnoreCase(arregloFrase[j])) {
                        cantidad++;
                    }
                }
                if (maxima < cantidad) {
                    maxima = cantidad;
                    palabra = arregloFrase[i];
                }
            }
            // Finalmente devolvemos la palabra mas repetida y el número de veces que se repite en un Map
            // donde la llave es la palabra y maxima la cantidad
            return Collections.singletonMap(palabra, maxima);


        };
        // Creamos la expresion lambda con una frase aleatoria
        // finalmente mostramos la palabra y el número de veces que se repite
        contadorPalabras.contarPalabras("Hola, estoy poniendo una frase a ver cual es la palabra que se repite mas, esta " +
                "palabra es aleatoria, limpamos comas, tambien puntos. espacios creo, cheves cheves cheves cheves cheves es lo que a mi me gusta aunque tambien " +
                "otras cosas pero ya saben como es esto")
                .forEach( (k, v) -> {
                    System.out.println("la palabra " + k + " se repite " + v +" veces.");
                } );
    }
}



