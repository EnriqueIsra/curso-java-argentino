import java.util.Scanner;

public class DetalleDeFactura {
    public static void main(String[] args) {
        String nombreFactura = "";
        Scanner scanner = new Scanner(System.in);
        String mensaje = "";
        double producto1 = 0;
        double producto2 = 0;
        double totalBruto = 0;
        double valorImpuesto = 0;
        double totalNeto = 0;

        System.out.println("Ingresa el nombre de la factura: ");
        nombreFactura = scanner.nextLine();

        System.out.println("Ingrese el precio del primer producto: ");
        try {
            producto1 = scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Error: El valor es invalido, intenta de nuevo");
            main(args);
            System.exit(0);
        }
        System.out.println("Ingrese el precio del segundo producto: ");
        try {
            producto2 = scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Error: El valor es invalido, intenta de nuevo");
            main(args);
            System.exit(0);
        }
        char comilla = '"';
        totalBruto = producto1 + producto2;
        valorImpuesto = totalBruto * .19;
        totalNeto = totalBruto + valorImpuesto;
        mensaje = "Factura: " + comilla + nombreFactura + comilla + "\n" +
                "Subtotal = " + totalBruto + "\n" +
                "Impuesto agregado = " + valorImpuesto + "\n" +
                "Total = " + totalNeto;
        System.out.println(mensaje);
    }
}
