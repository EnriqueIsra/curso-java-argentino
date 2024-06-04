package org.eitorresmendoza.archivos.ejemplos;

import org.eitorresmendoza.archivos.ejemplos.service.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Cursos\\Java\\archivo\\java.txt";

        ArchivoServicio servicio = new ArchivoServicio();
        System.out.println(servicio.leerArchivo2(nombreArchivo));
    }
}
