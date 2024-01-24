package org.eitorresmendoza.ejemplos.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, String> persona = new HashMap<>();
        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellido", "Lopez");
        persona.put("apellido Paterno", "Doe");
        persona.put("email", "john.doe@correo.com");
        persona.put("edad", "30");

        System.out.println("persona = " + persona);

        String nombre = persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = persona.get("apellido");
        System.out.println("apellido = " + apellido);

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
        Collection<String> valores = persona.values();
        for (String v: valores){
            System.out.println("v = " + v);
        }
        System.out.println("*********************** KeySet");
        Set<String> keys = persona.keySet();
        for (String key: keys){
            System.out.println("key = " + key);
        }
        System.out.println("*********************** entrySet");
        for (Map.Entry<String, String> valorPar: persona.entrySet()){
            System.out.println(valorPar.getKey() + " => " + valorPar.getValue());
        }
        System.out.println("*********************** KeySet");
        for (String key: persona.keySet()){
            String valor = persona.get(key);
            System.out.println(key + " => " + valor);
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
