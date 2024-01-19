import java.util.Random;

public class ProgramaHistogramaArreglo {
    public static void main(String[] args) {
        Random elRandom = new Random();
        int[] elArreglo = new int[12];
        for (int i = 0; i < elArreglo.length; i++) {
            elArreglo[i] = elRandom.nextInt(7);
            System.out.println(elArreglo[i]);
        }
        String[] arrehloHistograma = new String[6];
        for (int i = 0; i < arrehloHistograma.length; i++) {
            int aux = i + 1;
            String histograma = aux + ": ";
            for (int j = 0; j < elArreglo.length; j++) {
                if (aux == elArreglo[j]){
                    histograma += "*";
                }
            }
            arrehloHistograma[i] = histograma;
        }
        for (int i = 0; i < arrehloHistograma.length; i++) {
            System.out.println(arrehloHistograma[i]);
        }
    }
}
