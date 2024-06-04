package org.eitorresmendoza.hilos.ejemplos;

import org.eitorresmendoza.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfazRunnableJava8 {
    public static void main(String[] args) throws InterruptedException{

        Thread main = Thread.currentThread();

        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++){
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep( (long) Math.random() * 1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread v1 = new Thread(viaje, "La Playa");
        Thread v2 = new Thread(viaje, "Los United States");
        Thread v3 = new Thread(viaje, "Brazil");
        Thread v4 = new Thread(viaje, "La Playa otra vez");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        System.out.println("Continuando con la ejecución del método main: " + main.getName());
    }
}
