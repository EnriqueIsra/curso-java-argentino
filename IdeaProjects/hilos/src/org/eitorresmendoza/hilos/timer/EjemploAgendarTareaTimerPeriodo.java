package org.eitorresmendoza.hilos.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if (i > 0) {
                    toolkit.beep();
                    System.out.println("Tarea " + i + " periodica realizada en " +
                            new Date() + "\nNombre del Thread (hilo): " +
                            Thread.currentThread().getName());
                } else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 0, 10000);
        System.out.println("Iniciamos una tarea sin delay, que se repite cada 10 segundos 3 veces");
    }
}
