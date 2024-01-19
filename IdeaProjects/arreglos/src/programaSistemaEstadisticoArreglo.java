import java.util.Scanner;

public class programaSistemaEstadisticoArreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elArreglo = new int[7];
        int sumaPositiv = 0, sumaNegativ = 0, contadorPositiv = 0, contadorNegativ = 0, contadorZero = 0;
        for (int i = 0; i < elArreglo.length; i++) {
            System.out.print("Ingrese el valor " + i + ": ");
            elArreglo[i] = scanner.nextInt();
        }

        for (int i = 0; i < elArreglo.length; i++) {
            if (elArreglo[i] == 0) {
                contadorZero++;
            } else {
                if (elArreglo[i] > 0) {
                    sumaPositiv = sumaPositiv + elArreglo[i];
                    contadorPositiv++;
                } else {
                    sumaNegativ = sumaNegativ + elArreglo[i];
                    contadorNegativ++;
                }
            }
        }
        if (contadorZero == 0) {
            System.out.println("No se pudo calcular el promedio de números positivos");
        } else {
            System.out.println("El promedio de los positivos es: " + (float) sumaPositiv / contadorPositiv);
        }

        if (contadorNegativ == 0) {
            System.out.println("No se pudo calcular el promedio de números negativos");
        } else {
            System.out.println("El promedio de los negativos es: " + (float) sumaNegativ / contadorNegativ);
        }
        System.out.println("La cantidad de ceros es: " + contadorZero);

    }
}
