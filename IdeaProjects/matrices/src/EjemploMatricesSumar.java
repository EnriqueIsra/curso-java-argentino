import java.util.Random;

public class EjemploMatricesSumar {
    public static void main(String[] args) {
        int[][] a, b, c;
        a = new int[3][3];
        b = new int[3][3];
        c = new int[3][3];
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
        System.out.println("Matriz b con números Random: ");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = randomNumber.nextInt(7);
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Sumando matriz a y b en la matriz c: ");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
