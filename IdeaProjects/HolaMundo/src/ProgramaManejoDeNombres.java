import java.util.Scanner;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar el nombre del primer familiar");
        String nombreIntegrante1 = scanner.nextLine();
        System.out.println("Ingresar el nombre del segundo familiar");
        String nombreIntegrante2 = scanner.nextLine();
        System.out.println("Ingresar el nombre del tercer familiar");
        String nombreIntegrante3 = scanner.nextLine();
        
        String nombre1Procesado = nombreIntegrante1
                .toUpperCase()
                .charAt(1) +
                "." +
                nombreIntegrante1.substring(nombreIntegrante1.length() - 2);
        String nombre2Procesado = nombreIntegrante2
                .toUpperCase()
                .charAt(1) +
                "." +
                nombreIntegrante2.substring(nombreIntegrante2.length() - 2);
        String nombre3Procesado = nombreIntegrante3
                .toUpperCase()
                .charAt(1) +
                "." +
                nombreIntegrante3.substring(nombreIntegrante3.length() - 2);

        String resultado = nombre1Procesado.concat("_") + nombre2Procesado.concat("_" + nombre3Procesado);
        System.out.println("resultado = " + resultado);

    }
}
