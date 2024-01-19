import java.util.Random;

public class EjemploMatrizTranspuesta {
    public static void main(String[] args) {
        Random numeroRandom = new Random();

        int[][] laMatriz = {
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
        };
        System.out.println("La matriz original de números Random es la siguiente: ");
        for (int i = 0; i < laMatriz.length; i++) {
            for (int j = 0; j < laMatriz[i].length; j++) {
                System.out.print(laMatriz[i][j] + "\t");
            }
            System.out.println();
        }
        int aux;
        for (int i = 1; i < laMatriz.length; i++) {
            for (int j = 0; j < i; j++) {
                aux = laMatriz[i][j];
                laMatriz[i][j] = laMatriz[j][i];
                laMatriz[j][i] = aux;
            }
        }
        System.out.println("Matriz transpuesta de la matriz Random: ");
        for (int i = 0; i < laMatriz.length; i++) {
            for (int j = 0; j < laMatriz[i].length; j++) {
                System.out.print(laMatriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
