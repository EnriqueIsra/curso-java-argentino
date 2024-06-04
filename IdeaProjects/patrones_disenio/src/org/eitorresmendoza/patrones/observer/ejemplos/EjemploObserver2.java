package org.eitorresmendoza.patrones.observer.ejemplos;

import org.eitorresmendoza.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        repositorio.addObserver( (observable, usuario) -> System.out.println("Enviando email al usuario " + usuario));
        repositorio.addObserver( (observable, usuario) -> System.out.println("Enviando email al administrador"));
        repositorio.addObserver( (observable, usuario) -> System.out.println("Guardando datos del usuario " + usuario + " en el logs " ));
        repositorio.crearUsuario("Enrique");
    }
}
