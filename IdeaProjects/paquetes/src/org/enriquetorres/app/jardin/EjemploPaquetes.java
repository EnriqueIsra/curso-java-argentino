package org.enriquetorres.app.jardin;

import org.enriquetorres.app.hogar.*;
import static org.enriquetorres.app.hogar.Persona.*;
import static org.enriquetorres.app.hogar.ColorCabello.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Enrique");
        System.out.println(p.getNombre());
        p.setApellido("Torres");
        System.out.println(p.getApellido());
        p.setColorCabello(NEGRO);
        
        Perro perro = new Perro();
        perro.nombre = "Bobby";
        perro.raza = "Pastor Inglés";
        System.out.println("perro.nombre = " + perro.nombre);
        System.out.println("perro.raza = " + perro.raza);

        String jugando = perro.jugar(p);
        System.out.println("jugando = " + jugando);
        String saludo = saludar();
        String generoMasculino = GENERO_MASCULINO;
        String generoFemenino = GENERO_FEMENINO;
    }
}
