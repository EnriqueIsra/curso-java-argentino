import java.util.Scanner;

public class SentenciaIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el promedio");
        float promedio = scanner.nextFloat();

        if ( promedio > 100){
            System.out.println("Error: el promedio no puede ser mayor a 100, intentalo de nuevo.");

        } else if (promedio == 100){
            System.out.println(promedio + " es el promedio máximo\nFelicidades");
        } else if ( promedio >= 90) {
            System.out.println(promedio + " es un excelente promedio");
        } else if (promedio >= 80){
            System.out.println(promedio + " es un promedio muy bueno");
        } else if (promedio >= 70.1) {
            System.out.println(promedio + " es un buen promedio");
        } else if (promedio == 70) {
            System.out.println(promedio + " es el promedio mínimo para acreditar");
        } else {
            System.out.println(promedio + " es un promedio insuficiente, reprobatorio\nDeberás obtener un mínimo de 70 puntos para acreditar");
        }
        main(args);
    }
}
