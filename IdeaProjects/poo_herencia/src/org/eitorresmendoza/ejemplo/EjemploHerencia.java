package org.eitorresmendoza.ejemplo;

import org.eitorresmendoza.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {

        System.out.println("-------- Creando instancia de la clase Alumno -------");
        Alumno alumno = new Alumno();
        alumno.setNombre("Enrique");
        alumno.setApellido("Torres");
        alumno.setInstitucion("Instituto Tecnológico de Aguascalientes");
        alumno.setCalificacionEspaniol(7.5);
        alumno.setCalificacionHistoria(7.6);
        alumno.setCalificacionMatematicas(8.9);

        System.out.println("-------- Creando instancia de la clase AlumnoInternacional -------");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional();
        alumnoInternacional.setNombre("Peter");
        alumnoInternacional.setApellido("Gonzalez");
        alumnoInternacional.setPais("Australia");
        alumnoInternacional.setEdad(25);
        alumnoInternacional.setInstitucion("Instituto Tecnológico de Australia");
        alumnoInternacional.setCalificacionEspaniol(7.5);
        alumnoInternacional.setCalificacionHistoria(7.6);
        alumnoInternacional.setCalificacionMatematicas(8.9);

        System.out.println("-------- Creando instancia de la clase Profesor -------");
        Profesor profesor = new Profesor();
        profesor.setNombre("Arturo");
        profesor.setApellido("Ponce");
        profesor.setMateria("Estructura y Organización de Datos");

        System.out.println("----------- - -----------");
        System.out.println("Alumno: " + alumno.getNombre() +
                " " + alumno.getApellido() + ", del " + alumno.getInstitucion());
        System.out.println("Alumno: " + alumnoInternacional.getNombre() +
                " " + alumnoInternacional.getApellido() + ", del " + alumnoInternacional.getInstitucion() +
                " " + " desde " + alumnoInternacional.getPais());


        System.out.println("Profesor: " + profesor.getNombre() + " "
                + profesor.getApellido() + ", maestro de: " + profesor.getMateria());

        Class clase = alumnoInternacional.getClass();
        while (clase.getSuperclass() != null){
            String claseHija = clase.getName();
            String clasePadre = clase.getSuperclass().getName();
            System.out.println(claseHija + ": es una clase hija de la clase: " + clasePadre);
            clase = clase.getSuperclass();
        }
    }
}
