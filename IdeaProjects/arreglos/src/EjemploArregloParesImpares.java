import java.util.Scanner;

public class EjemploArregloParesImpares {
    public static void main(String[] args) {
        int[] a, pares, impares;
        int totalPares = 0, totalImpares = 0;
        a = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa 10 números: ");
        for (int i = 0; i < a.length; i ++){
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < a.length; i++){
            if (a[i] % 2 == 0){
                totalPares++;
            }
            if (a[i] % 2 == 1){
                totalImpares++;
            }
        }
        pares = new int[totalPares];
        impares = new int[totalImpares];
        int auxPar = 0, auxImpar = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] % 2 == 0){
                pares[auxPar++] = a[i];
            }
            if (a[i] % 2 == 1){
                impares[auxImpar++] = a[i];
            }
        }
        System.out.println("Pares");
        for (int i = 0; i < pares.length; i ++){
            System.out.print(pares[i] + " ");
        }
        System.out.println("\r\nImpares");
        for (int i = 0; i < impares.length; i ++){
            System.out.print(impares[i] + " ");
        }
    }
}
