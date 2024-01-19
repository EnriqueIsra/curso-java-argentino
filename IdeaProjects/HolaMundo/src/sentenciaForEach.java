public class sentenciaForEach {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 9, 11, 13, 15};
        for (int num: numeros){
            System.out.println("num = " + num);
        }
        String[] nombres = {"alejandra", "santiago", "enrique"};
        for (String nombre: nombres){
            System.out.println("nombre = " + nombre);
        }
    }
}
