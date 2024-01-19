import java.util.Arrays;

public class EjemploArreglosForOrdenamientoBurbuja {
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
    public static void sortBurbuja(Object[] arreglo){
        int lengProductos = arreglo.length;
        int contador = 0;
        for (int i = 0; i < lengProductos - 1; i++){
            for (int j = 0; j < lengProductos - 1 - i; j++){
                if (((Comparable)arreglo[j + 1]).compareTo(arreglo[j]) > 0){
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }
                contador ++;
            }
        }
        System.out.println("contador = " + contador);
    }

    public static void main(String[] args) {
        String[] productos = {"asus compu","acer compu",
                "wax", "royale", "mango kush",
                "victoria cheve", "bocina amethys"};

        int lengProductos = productos.length;

        sortBurbuja(productos);
        System.out.println("--------Usando for--------");
        for(int i = 0; i < lengProductos; i ++) {
            System.out.println("para indice: " + i + " : " + productos[i]);
        }
        Integer[] numeros = new Integer[4];
        numeros[0] = 6;
        numeros[1] = 84;
        numeros[2] = 875;
        numeros[3] = 43;

        sortBurbuja(numeros);
        for (int i = 0; i < numeros.length; i++){
            System.out.println("i = " + i + " : " + numeros[i]);
        }
    }
}
