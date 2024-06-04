package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFlatMap {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap(usuario -> {
                    if (usuario.getApellido().equals("torres") || usuario.getNombre().equals("alef")){
                        return Stream.of(usuario);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

        //nombres.forEach(System.out::println);
        System.out.println(nombres.count());
    }
}
