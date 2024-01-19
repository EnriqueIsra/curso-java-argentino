public class EjemploMatricesTamanioVariable {
    public static void main(String[] args) {
        int[][] laMatriz = new int[3][];
        laMatriz[0] = new int[2];
        laMatriz[1] = new int[3];
        laMatriz[2] = new int[4];

        for (int i = 0; i < laMatriz.length; i++) {
            for (int j = 0; j < laMatriz[i].length; j++) {
                laMatriz[i][j] = i * j;
            }
        }
        for (int i = 0; i < laMatriz.length; i++) {
            for (int j = 0; j < laMatriz[i].length; j++) {
                System.out.print(laMatriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
