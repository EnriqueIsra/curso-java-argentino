package org.eitorresmendoza.ejemplo;

import org.eitorresmendoza.pooherencia.Alumno;
import org.eitorresmendoza.pooherencia.AlumnoInternacional;
import org.eitorresmendoza.pooherencia.Persona;
import org.eitorresmendoza.pooherencia.Profesor;

public class EjemploHerenciaConstructores {
    public static void main(String[] args) {

        System.out.println("-------- Creando instancia de la clase Alumno -------");
        Alumno alumno = new Alumno("Enrique", "Torres", 23, "Instituto Tecnológico de Aguascalientes");
        alumno.setCalificacionEspaniol(7.5);
        alumno.setCalificacionHistoria(7.6);
        alumno.setCalificacionMatematicas(8.9);
        alumno.setEmail("enrique@correo.com");

        System.out.println("-------- Creando instancia de la clase AlumnoInternacional -------");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional("Peter", "Gonzalez", "Australia");
        alumnoInternacional.setEdad(25);
        alumnoInternacional.setInstitucion("Instituto Tecnológico de Australia");
        alumnoInternacional.setCalificacionIdiomas(9.1);
        alumnoInternacional.setCalificacionEspaniol(7.5);
        alumnoInternacional.setCalificacionHistoria(7.6);
        alumnoInternacional.setCalificacionMatematicas(8.9);
        alumnoInternacional.setEmail("peter@correo.com");

        System.out.println("-------- Creando instancia de la clase Profesor -------");
        Profesor profesor = new Profesor("Arturo", "Ponce", "Estructura y Organización de Datos");
        profesor.setEdad(37);
        profesor.setEmail("Ponce@aguascalientes.tecnm.mx");

        System.out.println("----------- - -----------");

        imprimir(alumno);
        imprimir(alumnoInternacional);
        imprimir(profesor);
    }
    public static void imprimir(Persona persona){
        System.out.println("Imprimiendo datos en común del tipo persona...");
        System.out.println("nombre: " + persona.getNombre() +
                ", apellido: " + persona.getApellido() +
                ", edad: " + persona.getEdad() +
                ", email: " + persona.getEmail());

        if (persona instanceof Alumno){
            System.out.println("Imprimiendo los datos del tipo alumno...");
            System.out.println("Institución: " + ((Alumno) persona).getInstitucion());
            System.out.println("Calificación Español: " + ((Alumno) persona).getCalificacionEspaniol());
            System.out.println("Calificación Historia: " + ((Alumno) persona).getCalificacionHistoria());
            System.out.println("Calificación Matemáticas: " + ((Alumno) persona).getCalificacionMatematicas());

            if (persona instanceof AlumnoInternacional){
                System.out.println("Imprimiendo los datos del tipo AlumnoInternacional...");
                System.out.println("Calificación Idiomas: " + ((AlumnoInternacional) persona).getCalificacionIdiomas());
                System.out.println("Pais:" + ((AlumnoInternacional) persona).getPais());
            }
            System.out.println("-------------------  Sobre escritura promedio  ----------------------");
            System.out.println("promedio: " + ((Alumno) persona).calcularPromedio());
            System.out.println("---------------------   -   -------------------");
        }


        if(persona instanceof Profesor){
            System.out.println("Imprimiendo los datos del tipo profesor...");
            System.out.println("Materia: " + ((Profesor) persona).getMateria());
        }
        System.out.println("--------------------   Sobre escritura de métodos   ----------------------");
        System.out.println(persona.saludar());
        System.out.println("---------------------   -   -------------------");
    }
}
