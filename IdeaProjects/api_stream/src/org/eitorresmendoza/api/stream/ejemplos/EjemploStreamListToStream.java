package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
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

        Stream<String> nombres = lista.stream()
                .map(u -> u.getNombre().toUpperCase()
                .concat(" ")
                .concat(u.getApellido().toUpperCase()))
                .flatMap(apellido -> {
                    if (apellido.contains("hernandez".toUpperCase())){
                        return Stream.of(apellido);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);

        System.out.println(nombres.count());
    }
}
