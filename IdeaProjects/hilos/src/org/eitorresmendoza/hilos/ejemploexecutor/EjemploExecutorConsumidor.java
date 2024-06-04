package org.eitorresmendoza.hilos.ejemploexecutor;

import org.eitorresmendoza.hilos.ejemplosync.Panaderia;
import org.eitorresmendoza.hilos.ejemplosync.runnable.Consumidor;
import org.eitorresmendoza.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + ejecutor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = ejecutor.submit(productor);
        Future<?> futuro2 = ejecutor.submit(consumidor);

        System.out.println("Tamaño del pool: " + ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + ejecutor.getQueue().size());
        ejecutor.shutdown();
        System.out.println("Continuando con la ejecución del método main");

    }
}
