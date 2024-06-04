package org.eitorresmendoza.patrones.composite.ejemplo;

import org.eitorresmendoza.patrones.composite.Archivo;
import org.eitorresmendoza.patrones.composite.Directorio;

public class EjemploComposite {
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

        System.out.println(documents.mostrar(0));
        System.out.println(images.mostrar(0));

    }
}
