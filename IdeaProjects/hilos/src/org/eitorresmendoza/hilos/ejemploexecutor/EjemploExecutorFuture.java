package org.eitorresmendoza.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService ejecutor = Executors.newSingleThreadExecutor();
        Callable<String> tarea = () -> {
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
        Future<String> resultado = ejecutor.submit(tarea);
        ejecutor.shutdown();
        System.out.println("Continuando con la ejecucion del método main");

        // System.out.println(resultado.isDone());
        // System.out.println(resultado.get(2, TimeUnit.SECONDS));
        while (!resultado.isDone()){
            System.out.println("ejecuntando tarea...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos el resultado de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());
    }
}
