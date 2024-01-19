import java.util.Scanner;

public class OperadorTerniario {
    public static void main(String[] args) {
        // variable == condición ? si es verdadero: si es falso
        String variable = 7 == 5 ? "Si es verdadero": "si es falso";
        System.out.println("variable = " + variable);

        String estado = "";
        double promedio = 0;
        double matematicas = 0, ciencias = 0, historia = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar nota de matematicas");
        matematicas = scanner.nextDouble();
        System.out.println("Ingresar nota de ciencias");
        ciencias = scanner.nextDouble();
        System.out.println("Ingresar nota de historia");
        historia = scanner.nextDouble();
        promedio = ((matematicas + ciencias + historia) / 3);
        System.out.println("promedio = " + promedio);
        estado = promedio >= 6 ? "Aprobado": "No Aprobado";
        System.out.println("estado = " + estado);

        /*if (promedio >= 6){
            estado = "Aprobado";
        } else {
            estado = "No abrobado";
        }*/

    }
}
