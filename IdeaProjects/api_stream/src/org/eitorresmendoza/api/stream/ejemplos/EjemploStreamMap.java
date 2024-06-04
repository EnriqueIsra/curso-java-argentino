package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });

        List<Usuario> listNombres = nombres.collect(Collectors.toList());
        listNombres.forEach(System.out::println);
        //nombres.forEach(System.out::println);
    }
}
