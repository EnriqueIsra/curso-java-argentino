import java.util.Arrays;

public class EjemploArreglosFor {
    public static void main(String[] args) {

        String[] productos = new String[7];
        int lengProductos = productos.length;
        productos[0] =  "asus compu";
        productos[1] =  "acer compu";
        productos[2] =  "wax";
        productos[3] =  "royale";
        productos[4] =  "mango kush";
        productos[5] =  "victoria cheve";
        productos[6] =  "bocina amethyst";

        Arrays.sort(productos);
        System.out.println("--------Usando For--------");
        for(int i = 0; i < lengProductos; i ++){
            System.out.println("para indice: " + i + " : " +productos[i]);
        }
        System.out.println("--------Usando ForEach--------");
        for(String nombreProducto: productos){
            System.out.println("nombreProducto = " + nombreProducto);
        }
        System.out.println("--------Usando While--------");
        int i = 0;
        while (i < lengProductos){
            System.out.println("para indice: " + i + " : " +productos[i]);
            i++;
        }
        System.out.println("--------Usando Do While--------");
        int j = 0;
        do{
            System.out.println("para indice: " + j + " : " +productos[j]);
            j++;
        } while (j < lengProductos);

        int[] numeros = new int[10];
        int lengNumeros = numeros.length;
        for (int k = 0; k < lengNumeros; k++){
            numeros[k] = k * 3;
            System.out.println("numeros[k] = " + numeros[k]);
        }

    }
}
