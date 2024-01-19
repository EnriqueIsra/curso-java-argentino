public class SentenciaFor {
    public static void main(String[] args) {
        for (int i = 0 /*Inicialización de la variable de control, el for realiza el primer paso una sola vez*/;
        i <= 10 /* Se evalúa una expresión*/;
        i++/*Se incrementa o decrementa la variable de control*/){
            System.out.println("i = " + i);
        }
        for(int i = 10; i >= 0; i--){
            System.out.println("i = " + i);
        }
        for (int i = 1, j = 10; i < j ; i++, j--){
            System.out.println(i + " - " + j);
        }
        for (int i = 0; i <= 10; i++){
            if (i % 2 == 0){
                continue;
            }
            System.out.println("i = " + i);
        }
    }
}
