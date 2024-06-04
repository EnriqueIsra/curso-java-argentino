package org.eitorresmendoza.archivos.ejemplos;

import org.eitorresmendoza.archivos.ejemplos.service.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Cursos\\Java\\archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo2(nombreArchivo);
    }
}
