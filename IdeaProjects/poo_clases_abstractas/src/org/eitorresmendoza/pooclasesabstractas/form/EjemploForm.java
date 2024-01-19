package org.eitorresmendoza.pooclasesabstractas.form;

import org.eitorresmendoza.pooclasesabstractas.form.elementos.*;
import org.eitorresmendoza.pooclasesabstractas.form.elementos.select.Opcion;
import org.eitorresmendoza.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        username.addValidador(new ValidarRequerido());

        InputForm password = new InputForm("password", "password");
        password.addValidador(new ValidarRequerido())
                .addValidador(new ValidarLargo(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new ValidarRequerido())
                .addValidador(new ValidarEmail());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new ValidarNumero());

        TextareaForm textoLargo = new TextareaForm("textoLargo", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new ValidarNoNulo());

        lenguaje.addOpcion(new Opcion("1", "Java").setSelected())
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name =  '" +
                        this.nombre +
                        "' value = \"" +
                        this.valor +
                        "\">";
            }
        };

        saludar.setValor("Hola, campo deshabilitado...");
        username.setValor("EnriqueIsrael");
        password.setValor("misbouas");
        email.setValor("bouas@bouas.bouas");
        edad.setValor("1000");
        textoLargo.setValor("... más de 10 años de experiencia... mucho texto...");

        List<ElementoForm> elementosForm = Arrays.asList(username,
                password,
                email,
                edad,
                textoLargo,
                lenguaje,
                saludar);

        elementosForm.forEach(elementoForm -> {
            System.out.println(elementoForm.dibujarHtml());
            System.out.println("<br>");
        });

        elementosForm.forEach(elementoForm -> {
            if (!elementoForm.esValido()){
                elementoForm.getErrores().forEach(System.out::println);
            }
        });
    }
}
