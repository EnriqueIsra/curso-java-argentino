import java.util.Random;

public class EjemploMatriz {
    public static void main(String[] args) {
        int[][] numeros = new int[2][4];
        Random numeroRandom = new Random();
        numeros[0][0] = numeroRandom.nextInt(100);
        numeros[0][1] = numeroRandom.nextInt(100);
        numeros[0][2] = numeroRandom.nextInt(100);
        numeros[0][3] = numeroRandom.nextInt(100);
        numeros[1][0] = numeroRandom.nextInt(100);
        numeros[1][1] = numeroRandom.nextInt(100);
        numeros[1][2] = numeroRandom.nextInt(100);
        numeros[1][3] = numeroRandom.nextInt(100);

        System.out.println("Número de filas: " + numeros.length);
        System.out.println("Número de columnas: " + numeros[0].length);

        System.out.println("Primer elemento de la matriz en Random: " + numeros[0][0]);
        System.out.println("último elemento de la matriz en Random: " + numeros[numeros.length - 1][numeros[1].length - 1]);

        System.out.println("número 1: " + numeros[0][0]);
        System.out.println("número 2: " + numeros[0][1]);
        System.out.println("número 3: " + numeros[0][2]);
        System.out.println("número 4: " + numeros[0][3]);
        System.out.println("número 5: " + numeros[1][0]);
        System.out.println("número 6: " + numeros[1][1]);
        System.out.println("número 7: " + numeros[1][2]);
        System.out.println("número 8: " + numeros[1][3]);

    }
}
