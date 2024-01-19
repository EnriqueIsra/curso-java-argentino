public class PasarPorReferencia {
    public static void main(String[] args) {
        int[] edad = {10, 11, 12};

        System.out.println("Iniciado el método main");
        for(int i = 0; i < edad.length; i++){
            System.out.println("edad[i] = " + edad[i]);
        }
        System.out.println("Antes de llamar al método test");
        test(edad);
        System.out.println("Después de llamar al método test");
        for(int i = 0; i < edad.length; i++){
            System.out.println("edad[i] = " + edad[i]);
        }

        System.out.println("Finaliza el método main con las modificaciones del arreglo");

    }
    public static void test(int[] edadArr){
        System.out.println("Iniciado el método test");
        for(int i = 0; i < edadArr[i]; i++){
            edadArr[i] = edadArr[i] + 20;
        }
        System.out.println("Finaliza el método test");
    }
}
