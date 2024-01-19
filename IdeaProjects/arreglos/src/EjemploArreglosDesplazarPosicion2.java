import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2 {
    public static void main(String[] args) {
        int[] a = new int[11];
        int elemento, posicion;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("Nuevo elemento: ");
        elemento = scanner.nextInt();
        System.out.println("Posición del nuevo elemento (de 0 a 10): ");
        posicion = scanner.nextInt();
        if (posicion > 10){
            System.err.println("Error: El índice es inválido");
            System.exit(-1);
        }
        for (int i = a.length - 2; i >= posicion; i--) {
            a[i + 1] = a[i];
        }
        a[posicion] = elemento;
        System.out.println("El Arreglo");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
