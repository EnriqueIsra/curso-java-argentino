public class EjemploMatricesStringFor2 {
    public static void main(String[] args) {
        String[][] nombres = {{"santi","enrique"},{"alejandra","alexander"},{"mimous", "bobias"}};

        for (String[] fila: nombres){
            for (String nombre: fila){
                System.out.print(nombre + "\t\t");
            }
            System.out.println();
        }

    }
}
