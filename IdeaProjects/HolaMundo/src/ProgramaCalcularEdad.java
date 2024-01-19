import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramaCalcularEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ingresa tu fecha de nacimiento con el siguiente formato: 'dd/MM/yyyy/'");

        try {
            Date fechaNacimiento = formatFecha.parse(scanner.next());
            Date fechaActual = new Date();
            System.out.println("fechaNacimiento = " + fechaNacimiento);
            System.out.println("fechaActual = " + fechaActual);
            //creamos un patron de fecha numérico con el día, mes y año
            formatFecha = new SimpleDateFormat("ddMMyyyy");
            /*Luego convertimos ambas fechas en enteros que contienen el mes el día y el año*/
            int fechaNacimientoInt = Integer.parseInt(formatFecha.format(fechaNacimiento));
            int fechaActualInt = Integer.parseInt(formatFecha.format(fechaActual));
            /*Restamos ambas fechas y dividimos en */
            System.out.println("fechaNacimientoInt = " + fechaNacimientoInt);
            System.out.println("fechaActualInt = " + fechaActualInt);
            String fechaNaciString = String.valueOf(fechaNacimientoInt);
            String fechaActuString = String.valueOf(fechaActualInt);
            System.out.println("fechaNaciString = " + fechaNaciString);
            System.out.println("fechaActuString = " + fechaActuString);
            String anioNacimiento = fechaNaciString.substring(fechaNaciString.length()-4);
            String anioActual = fechaActuString.substring(fechaActuString.length()-4);
            System.out.println("anioNacimiento = " + anioNacimiento);
            System.out.println("anioActual = " + anioActual);
            int anioNacimientoInt = Integer.parseInt(anioNacimiento);
            int anioActualInt = Integer.parseInt(anioActual);
            int edad = (anioActualInt - anioNacimientoInt);
            System.out.println("Tu edad es de: " + edad + " años");

        } catch (ParseException PA){
            PA.printStackTrace();
        }
    }
}
