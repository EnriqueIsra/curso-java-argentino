import java.util.Scanner;

public class EjemploArreglosBuscarString {
    public static void main(String[] args) {
        String [] a = new String[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingresa un nombre: ");
            a[i] = scanner.nextLine();
        }
        System.out.println("\r\nIngresa un nombre a buscar: ");
        String  nombre = scanner.nextLine();
        int i = 0;
        for (; i < a.length && !a[i].equalsIgnoreCase(nombre); i++) {
        }
        if (i == a.length) {
            System.out.println("El nombre " + nombre + " no fue encontrado en el arreglo");
        } else if (a[i].toLowerCase().compareTo(nombre.toLowerCase()) == 0) {
            System.out.println("El nombre " + nombre + " fue encontrado en la posición " + i);
        }
    }
}
