public class ArgumentosLineaComando {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Debe ingresar argumentos o parámetros");
            System.exit(-1);
        }
        for (int i = 0; i < args.length; i ++){
            System.out.println("Argumentos n° " + i + ": " + args[i]);
        }
        /*
        compilar aplicación mediante el terminal de comandos con: javac ArgumentosLineaComando.java
        ejecutar programa mediante terminal de comandos con: java ArgumentosLineaComando
        javac ArgumentosLineaComando.java -encoding utf8
         */
    }
}
