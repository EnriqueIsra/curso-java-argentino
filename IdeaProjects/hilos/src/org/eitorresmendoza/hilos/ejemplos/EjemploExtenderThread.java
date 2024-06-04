package org.eitorresmendoza.hilos.ejemplos;

import org.eitorresmendoza.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Pantera Rosa");
        hilo.start();
        //Thread.sleep(20);

        Thread hilo2 = new NombreThread("Bob Esponja");
        hilo2.start();

        Thread hilo3 = new NombreThread("Patricio Estrella");
        hilo3.start();

        System.out.println("Estado hilo Pantera Rosa: " + hilo.getState());
        System.out.println("Estado hilo Bob Esponja: " + hilo2.getState());
        System.out.println("Estado hilo Patricio Estrella: " + hilo3.getState());


    }
}
