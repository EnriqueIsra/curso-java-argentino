import java.util.Scanner;

public class ProgramaOrdenaDosNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el primer numero");
        double num1 = scanner.nextDouble();
        System.out.println("Ingresa el primer numero");
        double num2 = scanner.nextDouble();
        String resultado = (num1 > num1) ? ("Número mayor: " + num1) + ("\nNúmero menor: " + num2):
                ("Número mayor: " + num2) + ("\nNúmero menor: " + num1);
        System.out.println(resultado);
    }
}
