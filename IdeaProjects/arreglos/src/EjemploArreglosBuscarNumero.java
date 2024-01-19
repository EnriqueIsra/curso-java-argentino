import java.util.Scanner;

public class EjemploArreglosBuscarNumero {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingresa un número: ");
            a[i] = scanner.nextInt();
        }
        System.out.println("\r\nIngresa un número a buscar: ");
        int num = scanner.nextInt();
        int i = 0;
        for (; i < a.length && a[i] != num; i++) {
        }
        if (i == a.length) {
            System.out.println("El número " + num + " no fue encontrado en el arreglo");
        } else if (a[i] == num) {
            System.out.println("Número " + num + " fue encontrado en la posición " + i);
        }
    }
}
