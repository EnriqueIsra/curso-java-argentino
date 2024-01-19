import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2b {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[a.length + 1];
        int elemento, posicion, ultimo;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = scanner.nextInt();
        }
        System.out.println();
        System.out.println("Nuevo elemento: ");
        elemento = scanner.nextInt();
        System.out.println("Posición del nuevo elemento (de 0 a 9): ");
        posicion = scanner.nextInt();
        if (posicion > 10){
            System.err.println("Error: El índice es inválido");
            System.exit(-1);
        }
        ultimo = a[a.length - 1];
        for (int i = a.length - 2; i >= posicion; i--) {
            a[i + 1] = a[i];
        }

        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
        a[posicion] = elemento;
        a[a.length - 1] = ultimo;
        System.out.println("El Arreglo");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
