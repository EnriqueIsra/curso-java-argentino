import java.util.Scanner;

public class EjemploArreglosEliminarElemento {
    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
            System.out.println("Llenando arreglo... " + a[i]);
        }
        System.out.println();
        System.out.print("Ingresa una posición a eliminar (entre 0 y 9): ");
        int posicion = scanner.nextInt();
        if (posicion > 10){
            System.err.println("Error: El índice es inválido");
            System.exit(-1);
        }
        for (int i = posicion; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        int[] b = new int[a.length - 1];
        System.arraycopy(a, 0, b, 0, b.length);

        a = b;
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + ": " + a[i]);
        }
    }
}
