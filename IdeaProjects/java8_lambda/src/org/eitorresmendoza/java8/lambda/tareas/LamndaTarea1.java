package org.eitorresmendoza.java8.lambda.tareas;

public class LamndaTarea1 {
    public static void main(String[] args) {
        LamdaTarea1Formatear formatear = frase -> {
            return frase.replace(" ", "")
                    .replace(".", "")
                    .replace(",", "")
                    .toUpperCase();
        };
        String resultado = formatear.limpiarFormatear("hola, como andan. estoy aprendiendo a programar en java 8, unsando funciones de flecha o anonimas, quiero ser un gran programador");
        System.out.println(resultado);
    }
}
