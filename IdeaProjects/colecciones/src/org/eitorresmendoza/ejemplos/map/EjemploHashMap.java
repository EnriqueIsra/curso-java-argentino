package org.eitorresmendoza.ejemplos.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new HashMap<>();
        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellido", "Lopez");
        persona.put("apellido Paterno", "Doe");
        persona.put("email", "john.doe@correo.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");
        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La Playa");
        System.out.println("El pais de " + nombre + " es: " + pais);
        System.out.println("La ciudad de " + nombre + " es: " + ciudad);
        System.out.println("El barrio de " + nombre + " es: " + barrio);

        // String apellidoPaterno = persona.remove("apellido Paterno");
        boolean borrado = persona.remove("apellido Paterno", "Doe");
        System.out.println("borrado = " + borrado);
        System.out.println("persona = " + persona);

        boolean contieneLlave = persona.containsKey("email");
        System.out.println("contieneLlave \"email\" = " + contieneLlave);
        contieneLlave = persona.containsKey("apellido Paterno");
        System.out.println("contieneLlave \"apellido Paterno\" = " + contieneLlave);

        // Iterando el Map
        System.out.println("*********************** utilizando values");
        Collection<Object> valores = persona.values();
        for (Object v: valores){
            System.out.println("v = " + v);
        }
        System.out.println("*********************** KeySet");
        Set<String> keys = persona.keySet();
        for (String key: keys){
            System.out.println("key = " + key);
        }
        System.out.println("*********************** entrySet");
        for (Map.Entry<String, Object> valorPar: persona.entrySet()){
            Object valor = valorPar.getValue();
            if (valor instanceof Map){
                String nombre1 = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for (Map.Entry<String, String> parDir: direccionMap.entrySet()){
                    System.out.println(parDir.getKey() + " => " + parDir.getValue());
                }
            }else {
                System.out.println(valorPar.getKey() + " => " + valor);
            }
        }
        System.out.println("*********************** KeySet");
        for (String key: persona.keySet()){
            Object valor = persona.get(key);
            if (valor instanceof Map){
                String nombre1 = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El país de " + nombre1 + " es: " + direccionMap.get("pais"));
                System.out.println("El estado de " + nombre1 + " es: " + direccionMap.get("estado"));
                System.out.println("La ciudad de " + nombre1 + " es: " + direccionMap.get("ciudad"));

            } else {
                System.out.println(key + " => " + valor);
            }
        }
        System.out.println("*********************** forEach");
        persona.forEach((key, valor) -> {
            System.out.println(key + " => " + valor);
        });
        System.out.println("*********************** más métodos importantes");
        System.out.println("total: " + persona.size());
        System.out.println("contiene elementos = " + !persona.isEmpty());
        boolean remplazado = persona.replace("nombre", "John", "El tranza");
        System.out.println("remplazado = " + remplazado);
        System.out.println("persona = " + persona);
    }
}
