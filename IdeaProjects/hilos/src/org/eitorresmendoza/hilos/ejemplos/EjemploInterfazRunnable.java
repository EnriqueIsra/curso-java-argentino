package org.eitorresmendoza.hilos.ejemplos;

import org.eitorresmendoza.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfazRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("La Playa")).start();
        new Thread(new ViajeTarea("Los United States")).start();
        new Thread(new ViajeTarea("Brazil")).start();
        new Thread(new ViajeTarea("La Playa otra vez")).start();
    }
}
