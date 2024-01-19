package org.eitorres.poosobrecarga;

public class Calculadora {
    public static int sumar(int a, int b){
        return a + b;
    }
    public static int sumar(int... argumentos){
        int total = 0;
        for (int i: argumentos){
            total += i;
        }
        return total;
    }
    public static float sumar(float a, int... argumentos){
        float total = a;
        for (int i: argumentos){
            total += i;
        }
        return total;
    }
    public static double sumar(double... varargs){
        double total = 0.0;
        for (double d: varargs){
            total += d;
        }
        return total;
    }
    public static float sumar(float x, float y){
        return x + y;
    }
    public static float sumar(int i, float j){
        return i + j;
    }
    public static float sumar(float a, int b){
        return a + b;
    }
    public static double sumar(double a, double b){
        return a + b;
    }
    public static double sumar(String a, String b){
        double suma;
        try {
            suma = Double.parseDouble(a) + Double.parseDouble(b);
        } catch (NumberFormatException e){
            suma = 0;
        }
        return suma;
    }
    public int sumar(int a, int b, int c){
        return a + b + c;
    }
}
