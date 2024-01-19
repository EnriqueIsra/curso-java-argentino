import java.util.Scanner;

public class SentenciaSwitchCase {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el numero del mes");
        int mes = scanner.nextInt();
        String nombreMes = null;
        switch (mes){
            case 1:
                nombreMes = "Enero";
                break;
            case 2:
                nombreMes = "Febrero";
                break;
            case 3:
                nombreMes = "Marzo";
                break;
            case 4:
                nombreMes = "Abril";
                break;
            case 5:
                nombreMes = "Mayo";
                break;
            case 6:
                nombreMes = "Junio";
                break;
            case 7:
                nombreMes = "Julio";
                break;
            case 8:
                nombreMes = "Agosto";
                break;
            case 9:
                nombreMes = "Septiembre";
                break;
            case 10:
                nombreMes = "Octubre";
                break;
            case 11:
                nombreMes = "Noviembre";
                break;
            case 12:
                nombreMes = "Diciembre";
                break;
            default:
                nombreMes = "Indefinido";

        }
        System.out.println("nombreMes = " + nombreMes);

        System.out.println("Ingresa un número");
        String numero = scanner.nextLine();
        // El switch puede evaluar variables de tipo int, String, char, Byte y Short
        switch (numero){
            case "0":
                System.out.println("numero = " + numero);
                break;
            case "1":
                System.out.println("numero = " + numero);
                break;
            case "2":
                System.out.println("numero = " + numero);
                break;
            case "3":
                System.out.println("numero = " + numero);
                break;
            default:
                System.out.println("Número desconocido");
        }
        System.out.println("Ingresa un nombre:");
        String nombre = scanner.nextLine();
        switch (nombre){
            case "enrique":
                System.out.println("Bienvenido " + nombre + ", estas registrado como el mas vergas");
                break;
            case "santi":
                System.out.println("Bienvenido " + nombre + ", eres un hijo muy hermoso y valiente");
                break;
            default:
                System.out.println("usuario desconocido");
        }
    }
}
