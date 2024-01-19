import java.text.SimpleDateFormat;
import java.util.Date;

public class EjemploJavaUtilDate {
    public static void main(String[] args) {
        Date fechaActual = new Date();

        System.out.println("fechaActual = " + fechaActual);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
        String fechaStr = formatoFecha.format(fechaActual);

        long j = 0;
        for (int i = 0; i < 100000000; i++){
            j += i;
        }
        System.out.println("j = " + j);
        Date fecha2 = new Date();
        long tiempoFinal = fecha2.getTime() - fechaActual.getTime();
        System.out.println("tiempo transcurrido en el for = " + tiempoFinal);
        System.out.println("fechaStr = " + fechaStr);
    }
}
