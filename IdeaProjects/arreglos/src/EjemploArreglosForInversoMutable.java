import java.util.Arrays;
import java.util.Collections;

public class EjemploArreglosForInversoMutable {
    public static void arregloInverso(String[] arregloProductos){
        int lengProductos = arregloProductos.length;
        int lengProductos2 = arregloProductos.length;
        for (int i = 0; i < lengProductos; i++){
            String actual = arregloProductos[i];
            String invevrso = arregloProductos[lengProductos2 - 1 - i];
            arregloProductos[i] = invevrso;
            arregloProductos[lengProductos2 - 1 - i] =  actual;
            lengProductos--;
        }
    }
    public static void main(String[] args) {
        String[] productos = {"asus compu","acer compu",
                "wax", "royale", "mango kush",
                "victoria cheve", "bocina amethys"};
        int lengProductos = productos.length;
        Arrays.sort(productos);
        arregloInverso(productos);
        // Collections.reverse(Arrays.asList(productos));
        System.out.println("--------Usando for--------");
        for(int i = 0; i < lengProductos; i ++) {
            System.out.println("para indice: " + i + " : " + productos[i]);
        }
    }
}
