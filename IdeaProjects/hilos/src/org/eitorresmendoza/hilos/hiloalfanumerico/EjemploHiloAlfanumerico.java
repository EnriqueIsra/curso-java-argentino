package org.eitorresmendoza.hilos.hiloalfanumerico;

import java.util.Scanner;

public class EjemploHiloAlfanumerico {
    public static void main(String[] args) {
        AlfanumericoTarea numero = new AlfanumericoTarea(Tipo.NUMERO);
        AlfanumericoTarea letra = new AlfanumericoTarea(Tipo.LETRA);

        Thread hiloNumero = new Thread(numero);
        Thread hiloLetra = new Thread(letra);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la opción deseada");
        System.out.println("Para imprimir NÚMEROS oprime el número 1");
        System.out.println("Para imprimir LETRAS oprime el número 2");
        int opcion = scanner.nextInt();

        if (opcion == 1){
            hiloNumero.start();
        } else if (opcion == 2) {
            hiloLetra.start();
        }
    }
}
