import java.util.Scanner;

public class Programa13OrdenarArregloUltimoPrimeroEtc {
    public static void main(String[] args) {
        int[] arreglo = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese un número: ");
            arreglo[i] = scanner.nextInt();
        }
        System.out.println("El resultado es el siguiente: ");
        for (int i = 0; i < (arreglo.length) / 2; i++) {
            System.out.println(arreglo[9 - i]);
            System.out.println(arreglo[i]);
        }
    }
}
