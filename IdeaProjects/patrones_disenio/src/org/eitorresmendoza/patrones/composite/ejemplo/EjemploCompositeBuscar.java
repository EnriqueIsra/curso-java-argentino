package org.eitorresmendoza.patrones.composite.ejemplo;

import org.eitorresmendoza.patrones.composite.Archivo;
import org.eitorresmendoza.patrones.composite.Directorio;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {
        Directorio documents = new Directorio("Documents");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx"));

        java.addComponente(stream);

        documents.addComponente(java);
        documents.addComponente(new Archivo("cv.docx"));
        documents.addComponente(new Archivo("logo.jpeg"));

        Directorio images = new Directorio("Images");

        /*System.out.println(documents.mostrar(0));
        System.out.println(images.mostrar(0));*/

        boolean encontrado = documents.buscar("patron-composite.docx");
        System.out.println("Encontrado \"patron-composite.docx\": " + encontrado);

        encontrado = documents.buscar("Api Stream");
        System.out.println("Encontrado \"Api Stream\": " + encontrado);

        encontrado = documents.buscar("Bouas");
        System.out.println("Encontrado \"Bouas\": " + encontrado);

        encontrado = documents.buscar("lgo.jpeg");
        System.out.println("Encontrado \"lgo.jpeg\": " + encontrado);

    }
}
