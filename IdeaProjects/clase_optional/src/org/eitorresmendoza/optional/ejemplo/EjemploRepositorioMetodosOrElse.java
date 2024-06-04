package org.eitorresmendoza.optional.ejemplo;

import org.eitorresmendoza.optional.ejemplo.models.Computador;
import org.eitorresmendoza.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.eitorresmendoza.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        //Computador defecto = new Computador("Compu acer", "roja");
        Computador pc = repositorio.filtrar("PLATA")
                .orElse(valorDefecto());
        System.out.println("pc = " + pc);

        pc = repositorio.filtrar("lenovo")
                .orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println("pc = " + pc);
    }
    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto");
        return new Computador("Compu acer", "roja");
    }
}
