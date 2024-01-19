import java.util.Map;

public class EjemploVariablesDeEntorno {
    public static void main(String[] args) {
        Map< String, String > variableEntorno = System.getenv();
        System.out.println("Variables de amibiente del sistema: " + variableEntorno);

        System.out.println("-------------- Listando variables de entorno del sistema ----------------");
        for(String key: variableEntorno.keySet()){
            System.out.println(key + " " +": " + variableEntorno.get(key));
        }

        String username = System.getenv("USERNAME");
        System.out.println("username = " + username);

        String javahome = System.getenv("JAVA_HOME");
        System.out.println("javahome = " + javahome);

        String temDir = System.getenv("TEMP");
        System.out.println("temDir = " + temDir);

        String path = System.getenv("Path");
        System.out.println("path = " + path);

        String path2 = System.getenv("Path");
        System.out.println("path2 = " + path2);

        String appEnv = System.getenv("APPLICATION_ENV");
        System.out.println("appEnv = " + appEnv);

        String hola = System.getenv("SALUDAR_HOLA");
        System.out.println("hola = " + hola);
        /*Crear nueva variable de entorno del sistema utilizando la terminal de comandos
        * setx NOMBRE_DE_LA_VARIABLE "Valor de la variable del sistema, el kike le mide varios cm"*/
    }
}
