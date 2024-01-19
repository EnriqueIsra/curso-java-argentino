import java.util.Random;

public class EjemploMatricesSumarFilasyColumnas {
    public static void main(String[] args) {
        int[][] a;
        a = new int[3][3];
        int sumaFila, sumaColumna;
        Random randomNumber = new Random();
        //for para llenar la matriz a
        System.out.println("Matriz a con números Random: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = randomNumber.nextInt(7);
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < a.length; i++) {
            sumaFila = 0;
            sumaColumna = 0;
            for (int j = 0; j < a[i].length; j++) {
                sumaFila += a[i][j];
                sumaColumna += a[j][i];
            }
            System.out.println("Total fila " + i + ": " + sumaFila);
            System.out.println("Total columna " + i + ": " + sumaColumna);
        }
    }
}
