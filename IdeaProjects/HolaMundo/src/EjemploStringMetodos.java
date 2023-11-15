public class EjemploStringMetodos {
    public static void main(String[] args) {
        String nombre = "Enrique";

        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Enrique\") = " + nombre.equals("Enrique"));
        System.out.println("nombre.equals(\"enrique\") = " + nombre.equals("enrique"));
        System.out.println("nombre.equalsIgnoreCase(\"enrique\") = " + nombre.equalsIgnoreCase("enrique"));
        System.out.println("nombre.compareTo(\"Enrique\") = " + nombre.compareTo("Enrique"));
        System.out.println("nombre.compareTo(\"Aaron\") = " + nombre.compareTo("Aaron"));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(1) = " + nombre.charAt(1));
        System.out.println("nombre.charAt(6) = " + nombre.charAt(6));
        System.out.println("nombre.charAt(nombre.length()-1) = " + nombre.charAt(nombre.length()-1));
        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(1, 4) = " + nombre.substring(1, 4));
        System.out.println("nombre.substring(4, 5) = " + nombre.substring(4, 5));
        System.out.println("nombre.substring(nombre.length()-1) = " + nombre.substring(nombre.length()-1));

        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas = " + trabalenguas.replace("a", "."));
        System.out.println("trabalenguas.indexOf('a') = " + trabalenguas.indexOf('a'));
        System.out.println("trabalenguas.lastIndexOf('a') = " + trabalenguas.lastIndexOf('a'));
        System.out.println("trabalenguas.indexOf('z') = " + trabalenguas.indexOf('z'));
        System.out.println("trabalenguas.indexOf('t') = " + trabalenguas.indexOf('t'));
        System.out.println("trabalenguas.contains(\"t\") = " + trabalenguas.contains("t"));
        System.out.println("trabalenguas.contains(\"z\") = " + trabalenguas.contains("z"));
        System.out.println("trabalenguas.contains(\"lenguas\") = " + trabalenguas.contains("lenguas"));
        System.out.println("trabalenguas.indexOf(\"lenguas\") = " + trabalenguas.indexOf("lenguas"));
        System.out.println("trabalenguas.startsWith(\"lenguas\") = " + trabalenguas.startsWith("lenguas"));
        System.out.println("trabalenguas.startsWith(\"traba\") = " + trabalenguas.startsWith("traba"));
        System.out.println("trabalenguas.endsWith(\"tr\") = " + trabalenguas.endsWith("tr"));
        System.out.println("trabalenguas.endsWith(\"guas\") = " + trabalenguas.endsWith("guas"));
        System.out.println("  trabalenguas     ");
        System.out.println("  trabalenguas     ".trim());
    }
}
