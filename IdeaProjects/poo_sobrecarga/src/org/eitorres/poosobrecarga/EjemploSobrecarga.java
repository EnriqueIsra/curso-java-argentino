package org.eitorres.poosobrecarga;
import static org.eitorres.poosobrecarga.Calculadora.*;
public class EjemploSobrecarga {
    public static void main(String[] args) {
        System.out.println("sumar int: " + sumar(10, 5));
        System.out.println("sumar float: " + sumar(10.0f, 5f));
        System.out.println("sumar float-int: " + sumar(10f, 5));
        System.out.println("sumar int-float: " + sumar(10, 5f));
        System.out.println("sumar double: " + sumar(10d, 5d));
        System.out.println("sumar string: " + sumar("10", "5"));
        System.out.println("sumar 3 int: " + sumar(10, 5, 3));
        System.out.println("sumar 4 int: " + sumar(10, 5, 3, 4));
        System.out.println("sumar 6 int: " + sumar(10, 5, 3, 6, 7));
        System.out.println("sumar float + n int: " + sumar(10.5f, 5, 9, 15));
        System.out.println("sumar 4 double: " + sumar(10d, 5d, 3d, 4.5, 10.55, 152.3257));

        System.out.println("sumar long: " + sumar(10l, 5l));
        System.out.println("sumar int + @: " + sumar(10, '@'));
        System.out.println("sumar float + @: " + sumar(10f, '@'));
    }
}
