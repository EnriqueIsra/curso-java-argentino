package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {
        Usuario usuario = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(user -> user.getId().equals(1))
                .findFirst().orElseGet(() -> new Usuario("No existe", "el usuario"));
        System.out.println(usuario);
        //nombres.forEach(System.out::println);
    }
}
