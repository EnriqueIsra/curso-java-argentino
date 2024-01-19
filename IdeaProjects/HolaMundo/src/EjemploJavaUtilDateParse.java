import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EjemploJavaUtilDateParse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Ingresa una fecha con formato 'yyyy-MM-dd'");
        try {
            Date fechaUsuario = format.parse(scanner.next());
            System.out.println("fecha = " + fechaUsuario);
            System.out.println("format.format(fecha) = " + format.format(fechaUsuario));

            Date fechaActual = new Date();
            System.out.println("fechaActual = " + fechaActual);
            if (fechaUsuario.after(fechaActual)){
                System.out.println("La fecha del usuario es mayor que la fecha actual");
            } else if (fechaUsuario.before(fechaActual)) {
                System.out.println("La fecha del usuario es menor que la fecha actual");
            } else if (fechaUsuario.equals(fechaActual)) {
                System.out.println("La fecha del usuario es igual que la fecha actual");
            }
            if(fechaUsuario.compareTo(fechaActual) > 0){
                System.out.println("La fecha del usuario es mayor que la fecha actual");
            } else if (fechaUsuario.compareTo(fechaActual) < 0 ) {
                System.out.println("La fecha del usuario es menor que la fecha actual");
            } else if (fechaUsuario.compareTo(fechaActual) == 0){
                System.out.println("La fecha del usuario es igual que la fecha actual");
            }
        } catch (ParseException e) {
            //e.printStackTrace();
            System.err.println("La fecha tiene un formato incorrecto: " + e.getMessage());
            System.err.println("El formato debe ser 'dd/MM/yyyy'");
            //System.exit(1);
            main(args);
        }
    }
}
