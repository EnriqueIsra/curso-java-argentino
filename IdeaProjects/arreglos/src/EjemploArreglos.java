import java.util.Arrays;

public class EjemploArreglos {
    public static void main(String[] args) {

        String[] productos = new String[7];
        productos[0] =  "asus compu";
        productos[1] =  "acer compu";
        productos[2] =  "wax";
        productos[3] =  "royale";
        productos[4] =  "mango kush";
        productos[5] =  "victoria cheve";
        productos[6] =  "bocina amethyst";

        Arrays.sort(productos);

        String produc1 = productos[0];
        String produc2 = productos[1];
        String produc3 = productos[2];
        String produc4 = productos[3];
        String produc5 = productos[4];
        String produc6 = productos[5];
        String produc7 = productos[6];

        System.out.println("produc1 = " + produc1);
        System.out.println("produc2 = " + produc2);
        System.out.println("produc3 = " + produc3);
        System.out.println("produc4 = " + produc4);
        System.out.println("produc5 = " + produc5);
        System.out.println("produc6 = " + produc6);
        System.out.println("produc7 = " + produc7);



        int[] numeros = new int[4];
        numeros[0] = 6;
        numeros[1] = 84;
        numeros[2] = 875;
        numeros[3] = 43;
        // numeros[4] = 5;

        Arrays.sort(numeros);

        int i = numeros[0];
        int j = numeros[1];
        int k = numeros[2];
        int l = numeros[3];
        // int m = numeros[4];

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("l = " + l);
    }
}
