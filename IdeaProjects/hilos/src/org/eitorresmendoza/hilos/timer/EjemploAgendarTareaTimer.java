package org.eitorresmendoza.hilos.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en " + new Date() + "\nNombre del Thread (hilo): " +
                        Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }
        }, 5000);
        System.out.println("Iniciamos una tarea en 5 segundos");
    }
}
