import java.util.Random;

public class EjemploMatrizRandomBuscar {
    public static void main(String[] args) {
        Random numeroRandom = new Random();

        int[][] matrizEnteros = {
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
                {numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20), numeroRandom.nextInt(20)},
        };
        System.out.println("La matriz Random es la siguiente: ");
        for (int i = 0; i < matrizEnteros.length; i++) {
            for (int j = 0; j < matrizEnteros[i].length; j++) {
                System.out.print(matrizEnteros[i][j] + "\t");
            }
            System.out.println();
        }
        int elementoBuscado = numeroRandom.nextInt(20);
        System.out.println("Buscando el siguiente elemento en la matriz: " + elementoBuscado);
        boolean encontrado = false;
        int i;
        int j = 0;
        for (i = 0; i < matrizEnteros.length; i++) {
            for (j = 0; j < matrizEnteros[i].length; j++) {
                if (matrizEnteros[i][j] == elementoBuscado){
                    encontrado = true;
                    if (encontrado) {
                        System.out.println("Elemento: " + elementoBuscado + ". Encontrado en las coordenadas " + i + ", " + j);
                    }
                }
            }
        }
        if (encontrado == false){
            System.out.println("Elemento: " + elementoBuscado + ". No se encontró en la matriz");
        }
    }
}
