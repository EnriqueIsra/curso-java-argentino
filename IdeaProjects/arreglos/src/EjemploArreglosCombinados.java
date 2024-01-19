public class EjemploArreglosCombinados {
    public static void main(String[] args) {
        int[] a, b, c;
        a = new int[12];
        b = new int[12];
        c = new int[24];
        for (int i = 0; i < a.length; i++){
            a[i] = i + 1;
        }
        for (int i = 0; i < b.length; i++){
            b[i] = (i + 1) * 5;
        }
        int aux = 0;
        for (int i  = 0; i < 10; i += 3){
            for (int j = 0; j < 3 ; j++){
                c[aux++] = a[i + j];
            }
            for (int k = 0; k < 3; k++){
                c[aux++] = b[i + k];
            }
        }
        for (int i = 0; i < c.length; i++){
            System.out.println(i + ": " + c[i]);
        }
    }
}
