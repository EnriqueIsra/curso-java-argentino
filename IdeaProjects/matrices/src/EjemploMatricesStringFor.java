public class EjemploMatricesStringFor {
    public static void main(String[] args) {
        String[][] nombres = new String[3][2];
        nombres[0][0] = "santi";
        nombres[0][1] = "enrique";
        nombres[1][0] = "alexander";
        nombres[1][1] = "alejandra";
        nombres[2][0] = "bobias";
        nombres[2][1] = "mimous";

        System.out.println("Iterando con un for: ");
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.print(nombres[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("Iterando con un foreach: ");
        for (String[] fila: nombres){
            for (String nombre: fila){
                System.out.print(nombre + "\t\t");
            }
            System.out.println();
        }

    }
}
