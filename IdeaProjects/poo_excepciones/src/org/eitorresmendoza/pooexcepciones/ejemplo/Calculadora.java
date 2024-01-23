package org.eitorresmendoza.pooexcepciones.ejemplo;

public class Calculadora {
    public double dividir (int numerador, int divisor) throws DivisionEntreCeroException {
        if (divisor == 0) {
            throw new DivisionEntreCeroException("No es posible dividir entre cero.");
        }
        return numerador / (double)divisor;
    }

    public double dividir(String numerador, String divisor)
            throws DivisionEntreCeroException, FormatoDeNumeroException {
        try {
            int numeradorInt = Integer.parseInt(numerador);
            int divisorInt = Integer.parseInt(divisor);
            return this.dividir(numeradorInt, divisorInt);
        } catch (NumberFormatException e){
            throw new FormatoDeNumeroException("Se debe ingresar un número en el numerador y el divisor también.");
        }
    }
}
