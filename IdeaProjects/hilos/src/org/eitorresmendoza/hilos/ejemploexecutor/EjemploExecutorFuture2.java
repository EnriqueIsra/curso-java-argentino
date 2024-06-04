package org.eitorresmendoza.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + ejecutor.getQueue().size());
        Callable<String> tareaString = () -> {
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del Thread (Hilo): " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Algún resultado importante de la tarea";
        };

        Callable<Integer> tareaInteger = () -> {
            System.out.println("Iniciando tarea 3");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };
        Future<String> resultado = ejecutor.submit(tareaString);
        Future<String> resultado2 = ejecutor.submit(tareaString);
        Future<Integer> resultado3 = ejecutor.submit(tareaInteger);
        System.out.println("Tamaño del pool: " + ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + ejecutor.getQueue().size());
        ejecutor.shutdown();
        System.out.println("Continuando con la ejecución del método main");

        // System.out.println(resultado.isDone());
        // System.out.println(resultado.get(2, TimeUnit.SECONDS));
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("resultado 1: %s - resultado 2: %s - resultado 3: %s",
                    resultado.isDone()? "Finalizó tarea 1: ": "Tarea 1 en proceso...",
                    resultado2.isDone()? "Finalizó tarea 2: ": "Tarea 2 en proceso...",
                    resultado3.isDone()? "Finalizó tarea 3: ": "Tarea 3 en proceso..."));

            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Obtenemos el resultado de la tarea 1: " + resultado.get());
        System.out.println("Finaliza la tarea 1: " + resultado.isDone());
        System.out.println("Obtenemos el resultado de la tarea 2: " + resultado2.get());
        System.out.println("Finaliza la tarea 2: " + resultado2.isDone());
        System.out.println("Obtenemos el resultado de la tarea 3: " + resultado3.get());
        System.out.println("Finaliza la tarea 3: " + resultado3.isDone());
    }
}
