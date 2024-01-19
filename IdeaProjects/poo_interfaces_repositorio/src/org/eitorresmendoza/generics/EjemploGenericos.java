package org.eitorresmendoza.generics;

import org.eitorresmendoza.poointerfaces.modelo.Cliente;
import org.eitorresmendoza.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Santiago", "Hernández"));
        Random random = new Random();

        Cliente santiago = clientes.iterator().next();

        Cliente[] arregloClientes = {new Cliente("Alex", "Torres"), new Cliente("Alejandra", "Sánchez")};
        Integer[] arregloEnteros = {10, 20, 30};

        List<Cliente> listaClientes = deArregloToLista(arregloClientes);
        List<Integer> listaEnteros = deArregloToLista(arregloEnteros);
        listaClientes.forEach(System.out::println);
        listaEnteros.forEach(System.out::println);

        List<String> nombres = deArregloToLista(new String[]{"Santi", "Oscar," +
                "Luciana", "Alex", "Ale"}, arregloEnteros);
        nombres.forEach(System.out::println);

        List<ClientePremium> listaClientePremium = deArregloToLista(new ClientePremium[]{
                new ClientePremium("Paco", "Fernández")
        });

        imprimirClientes(clientes);
        imprimirClientes(listaClientes);
        imprimirClientes(listaClientePremium);
        int num1 = random.nextInt(11);
        int num2 = random.nextInt(11);
        int num3 = random.nextInt(11);
        double numD1 = random.nextDouble(11);
        double numD2 = random.nextDouble(11);
        double numD3 = random.nextDouble(11);

        System.out.println("Máximo de " + num1 + ", " + num2 + " y " +
                num3 + " es: " + maximo(num1, num2, num3));
        System.out.println("Máximo de " + numD1 + ", " + numD2 + " y " +
                numD3 + " es: " + maximo(numD1, numD2, numD3));
        System.out.println("Máximo de mimous, bobias y mima es: " + maximo("mimous", "bobias", "mima"));

    }
    public static <T> List<T> deArregloToLista(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Number> List<T> deArregloToLista(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Cliente> List<T> deArregloToLista(T[] c){
        return Arrays.asList(c);
    }

    public static <T, G> List<T> deArregloToLista(T[] c, G[] x){
        for (G elemento: x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }
    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
