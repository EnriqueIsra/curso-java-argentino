package org.eitorresmendoza.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese un entero numerador");
        String divisor = JOptionPane.showInputDialog("Ingrese un entero divisor");

        try {
            double division = calculadora.dividir(numerador, divisor);
            System.out.println("division = " + division);
        } catch (FormatoDeNumeroException formatoDeNumeroException){
            System.out.println("Excepción detectada: Ingresar un valor numérico. " + formatoDeNumeroException.getMessage());
            main(args);
        } catch (DivisionEntreCeroException divisionEntreCeroException) {
            System.out.println("Excepción detectada: No es posible realizar la división. " + divisionEntreCeroException.getMessage());
            main(args);
        } finally {
            System.out.println("Finally es opcional, se ejecuta siempre con o sin excepción.");
        }
        System.out.println("Continuando el flujo...");
    }
}
