package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {
        boolean existe = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(user -> user.getId().equals(1));
        System.out.println(existe);

        List<Usuario> lista = Arrays.asList(new Usuario("enrique", "torres"),
                new Usuario("ale", "sanchez"),
                new Usuario("santi", "torres"),
                new Usuario("sebas", "torres"));

        boolean resultado = false;
        for (Usuario u: lista) {
            if(u.getId().equals(3)){
                resultado = true;
                break;
            }
        }
        System.out.println(resultado);
    }
}
