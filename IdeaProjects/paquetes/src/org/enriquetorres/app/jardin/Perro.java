package org.enriquetorres.app.jardin;

import org.enriquetorres.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar(Persona persona){
        return persona.lanzarPelota();
    }
}
