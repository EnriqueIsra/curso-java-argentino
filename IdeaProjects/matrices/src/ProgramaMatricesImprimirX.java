import java.util.Random;

public class ProgramaMatricesImprimirX {
    public static void main(String[] args) {
        Random nRandom = new Random();
        int dimensionMatriz = nRandom.nextInt(21);
        System.out.println("Dimensión Random de la matriz: " + dimensionMatriz);
        if (dimensionMatriz == 0){
            System.err.println("Error: la dimensión de una matriz no puede ser cero (0). Intentalo de nuevo wey");
            main(args);
        }
        for (int i = 0; i < dimensionMatriz; i++) {
            for (int j = 0; j < dimensionMatriz; j++) {
                if (i == j || j == dimensionMatriz - i - 1){
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
