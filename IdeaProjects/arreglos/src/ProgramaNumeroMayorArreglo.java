import java.util.Scanner;

public class ProgramaNumeroMayorArreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elArreglo = new int[7];
        for (int i = 0; i < elArreglo.length; i++) {
            System.out.print("Ingresa el valor " + i + ": ");
            elArreglo[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < elArreglo.length; i++) {
            max = (max > elArreglo[i]) ? max : elArreglo[i];
        }
        System.out.println("El valor más alto del arreglo es: " + max);
    }
}
