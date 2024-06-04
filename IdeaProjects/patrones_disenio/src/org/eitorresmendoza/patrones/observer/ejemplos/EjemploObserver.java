package org.eitorresmendoza.patrones.observer.ejemplos;

import org.eitorresmendoza.patrones.observer.Corporation;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporation google = new Corporation("Google", 1000);
        google.addObserver( (observable, object) -> {
            System.out.println("Jon: " + observable);
        });
        google.addObserver( (observable, object) -> {
            System.out.println("Maria: " + observable);
        });
        google.addObserver( (observable, object) -> {
            System.out.println("Andrés: " + observable);
        });
        google.modificaPrecio(2000);

    }
}
