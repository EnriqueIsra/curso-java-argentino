public class EjemploStringMetodosArreglo {
    public static void main(String[] args) {
        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas.length() = " + trabalenguas.length());
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());
        char[] arreglo = trabalenguas.toCharArray();
        int largo = arreglo.length;
        System.out.println("largo = " + largo);
        for (int i = 0; i < largo; i++) {
            System.out.print(arreglo[i]);
        }
        System.out.println();
        System.out.println("trabalenguas.split(\"a\") = " + trabalenguas.split("a"));
        String[] arreglo2 = trabalenguas.split("a");
        int l = arreglo2.length;
        for (int j = 0; j < l; j++){
            System.out.println("arreglo2[j] = " + arreglo2[j]);
        }
        String archivo = "alguna.imagen.json";
        String[] arrchivoArr = archivo.split("\\.");
        l = arrchivoArr.length;
        System.out.println("l = " + l);
        for (int j = 0; j < l; j++){
            System.out.println("arrchivoArr[j] = " + arrchivoArr[j]);
        }
        System.out.println("extension = arrchivoArr[l - 1] = " + arrchivoArr[l - 1]);
    }
}
