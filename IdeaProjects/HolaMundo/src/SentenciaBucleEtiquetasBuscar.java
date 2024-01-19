public class SentenciaBucleEtiquetasBuscar {
    public static void main(String[] args) {
        String frase = "trigo trigo tres tristes trigo tigres trigo tragaban trigo en trigo un trigo trigal trigo";
        String palabra = "trigo";
        int maxPalabra = palabra.length();
        int maxFrase = frase.length() - maxPalabra;
        int cantidad = 0;
        char letra = 'g';
        buscar:
        for(int i = 0; i <= maxFrase;){
            int k = i;
            for(int j = 0; j < maxPalabra; j++){
                if (frase.charAt(k++) != palabra.charAt(j)){
                    i++;
                    continue buscar;
                }
            }
            cantidad ++;
            i = i + maxPalabra;
        }
        System.out.println("Palabra: " + palabra + ", encontrada " + cantidad + " veces en la frase");
    }
}
