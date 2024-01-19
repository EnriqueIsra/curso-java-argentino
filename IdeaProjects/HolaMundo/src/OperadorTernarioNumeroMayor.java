import java.util.Scanner;

public class OperadorTernarioNumeroMayor {
    public static void main(String[] args) {
        int max = 0;
        int min = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número");
        int numero1 = scanner.nextInt();
        System.out.println("Ingresa un segundo número");
        int numero2 = scanner.nextInt();
        System.out.println("Ingresa un tercer número");
        int numero3 = scanner.nextInt();
        System.out.println("Ingresa un cuarto número");
        int numero4 = scanner.nextInt();

        max = (numero1 > numero2) ? numero1 : numero2;
        max = (max > numero3) ? max : numero3;
        max = (max > numero4) ? max : numero4;

        min = (numero1 < numero2) ? numero1 : numero2;
        min = (min < numero3) ? min : numero3;
        min = (min < numero4) ? min : numero4;

        System.out.println("numero1 = " + numero1);
        System.out.println("numero2 = " + numero2);
        System.out.println("numero3 = " + numero3);
        System.out.println("numero4 = " + numero4);
        System.out.println("el número mayor es: " + max + "\ny el menor es: " + min);
    }
}
