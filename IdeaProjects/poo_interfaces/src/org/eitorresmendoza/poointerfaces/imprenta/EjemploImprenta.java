package org.eitorresmendoza.poointerfaces.imprenta;

import org.eitorresmendoza.poointerfaces.imprenta.modelo.*;
import static org.eitorresmendoza.poointerfaces.imprenta.modelo.Genero.*;
import static org.eitorresmendoza.poointerfaces.imprenta.modelo.Imprimible.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo("Resumen laboral...",
                new Persona("Enrique", "Torres"), "Ingeniería Tics");
        cv.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador fullstack")
                .addExperiencia("Angular");

        Libro libro = new Libro(new Persona("Erich", "Gamma"),
                "Patrones de diseños: Elementos Reusables POO", PROGRAMACION);
        libro.addPagina(new Pagina("Patrón Singleton"))
                .addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Factory"))
                .addPagina(new Pagina("Patrón Composite"))
                .addPagina(new Pagina("Patron Facade"));

        Informe informe = new Informe("Curso avanzado Java",new Persona("Andrés", "Guzmán"),
                new Persona("Quien", "Sabe"));
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "Hola que tal imprimiendo un objeto genérico de una clase anónima";
            }
        });
        System.out.println(TEXTO_DEFECTO);
    }

}
