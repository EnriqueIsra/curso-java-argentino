package org.eitorresmendoza.api.stream.ejemplos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerate {
    public static void main(String[] args) {
        AtomicInteger contador = new AtomicInteger(0);

        Stream.generate(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return contador.incrementAndGet() + " perros locos";
                })
                .limit(5)
                .forEach(System.out::println);
    }
}
