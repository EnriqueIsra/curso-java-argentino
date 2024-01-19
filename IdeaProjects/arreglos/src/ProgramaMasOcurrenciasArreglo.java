import java.util.Random;
import java.util.Scanner;

public class ProgramaMasOcurrenciasArreglo {
    public static void main(String[] args) {
        Random elRandom = new Random();
        int[] elArreglo = new int[10];
        for (int i = 0; i < elArreglo.length; i++) {
            elArreglo[i] = elRandom.nextInt(11);
            System.out.println(elArreglo[i]);
        }
        int[] arregloCantidadValores = new int[10];
        for (int i = 0; i < elArreglo.length; i++) {
            int cantidad = 0;
            for (int j = 0; j < elArreglo.length; j++) {
                if (elArreglo[i] == elArreglo[j]){
                    cantidad++;
                }
            }
            arregloCantidadValores[i] = cantidad;
        }
        int indice = 0;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (max < arregloCantidadValores[i]){
                max = arregloCantidadValores[i];
                indice = i;
            }
        }
        System.out.println("La mayor ocurrencia es: " + max);
        System.out.println("El elemento con mayor repeticiones es: " + elArreglo[indice]);
        System.out.println("El elemento " + elArreglo[indice] + " se repite " + max + " veces en el arreglo random :)");
    }
}
