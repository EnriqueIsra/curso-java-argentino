import java.util.Random;

 public class ProgramaMatricesImprimirSillaHache {
    public static void main(String[] args) {
        Random nRandom = new Random();
        int dimensionMatriz = nRandom.nextInt(21);
        System.out.println("Dimensión Random de la matriz: " + dimensionMatriz);
        int[][] matriz = new int[dimensionMatriz][dimensionMatriz];
        if (dimensionMatriz == 0){
            System.err.println("Error: la dimensión de una matriz no puede ser cero (0). Intentalo de nuevo wey");
            main(args);
        }
        for (int i = 0; i < dimensionMatriz; i++) {
            for (int j = 0; j < dimensionMatriz; j++) {
                if ((j == 0) || (i == dimensionMatriz / 2 && j != dimensionMatriz - 1) || (j == dimensionMatriz - 1 && i >= dimensionMatriz / 2)){
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
