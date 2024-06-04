package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("santiago", "hernandez"));
        lista.add(new Usuario("sebastian", "torres"));
        lista.add(new Usuario("oscar", "sanchez"));
        lista.add(new Usuario("edgar", "torres"));
        lista.add(new Usuario("alberto", "torres"));
        lista.add(new Usuario("paulina", "mendoza"));
        lista.add(new Usuario("maria", "sanchez"));
        lista.add(new Usuario("alejandra", "hernandez"));

        long t1 = System.currentTimeMillis();

        String resultado = lista.stream()
                .parallel()
                .map(u -> u.toString().toUpperCase())
                .peek(nombreUsuario -> {
                    System.out.println("Nombre del Thread (Hilo): " + Thread.currentThread().getName() +
                            " - " + nombreUsuario);
                })
                .flatMap(apellido -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (apellido.contains("torres".toUpperCase())){
                        return Stream.of(apellido);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 - t1));
        System.out.println(resultado);
    }
}
