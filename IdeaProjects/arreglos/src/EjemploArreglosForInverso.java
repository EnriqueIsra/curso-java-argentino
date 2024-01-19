import java.util.Arrays;

public class EjemploArreglosForInverso {
    public static void main(String[] args) {

        // String[] productos = new String[7];
        String[] productos = {"asus compu","acer compu",
                "wax", "royale", "mango kush",
                "victoria cheve", "bocina amethys"};
        int lengProductos = productos.length;

        /*productos[0] =  "asus compu";
        productos[1] =  "acer compu";
        productos[2] =  "wax";
        productos[3] =  "royale";
        productos[4] =  "mango kush";
        productos[5] =  "victoria cheve";
        productos[6] =  "bocina amethyst";*/

        Arrays.sort(productos);
        System.out.println("--------Usando for--------");
        for(int i = 0; i < lengProductos; i ++){
            System.out.println("para indice: " + i + " : " +productos[i]);
        }
        System.out.println("--------Usando for inverso--------");
        for(int i = 0; i < lengProductos; i++){
            System.out.println("para indice: " + (lengProductos - 1 - i) + " : " +
                    productos[lengProductos - 1 - i]);
        }
        System.out.println("--------Usando for inverso2--------");
        for(int i = lengProductos - 1; i >= 0; i--){
            System.out.println("para indice: " + i + " : " +productos[i]);
        }
    }
}
