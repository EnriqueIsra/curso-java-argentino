package org.eitorresmendoza.anotaciones.ejemplo.procesador;

import org.eitorresmendoza.anotaciones.ejemplo.Init;
import org.eitorresmendoza.anotaciones.ejemplo.JsonAtributo;
import org.eitorresmendoza.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarObjeto(Object object){
        if(Objects.isNull(object)){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }
        Method[] metodos = object.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(method -> method.isAnnotationPresent(Init.class))
                .forEach(method -> {
                    method.setAccessible(true);
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se puede inicial el objeto"
                        + e.getMessage());
                    }
                });
    }
    public static String convertirJson(Object object){

        if(Objects.isNull(object)){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }
        inicializarObjeto(object);
        Field[] atributos = object.getClass().getDeclaredFields();

        return Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))
                .map(field -> {
                    field.setAccessible(true);
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? field.getName()
                            : field.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = field.get(object);
                        if (field.getAnnotation(JsonAtributo.class).capitalizar() &&
                        valor instanceof String){
                            String nuevoValor = (String) valor;
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0, 1).toUpperCase() +
                                            palabra.substring(1).toLowerCase())
                                            .collect(Collectors.joining(" "));
                           /*nuevoValor = String.valueOf(nuevoValor.charAt(0)).toUpperCase() +
                                    nuevoValor.substring(1).toLowerCase();*/
                            /*nuevoValor = nuevoValor.substring(0, 1).toUpperCase() +
                                    nuevoValor.substring(1).toLowerCase();*/
                            field.set(object, nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + field.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar el json: " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)){
                        return a + b;
                    }
                    return a + "," + b;
                }).concat("}");
    }
}
