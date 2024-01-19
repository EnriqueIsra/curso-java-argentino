import java.util.Scanner;

public class SentenciaSwitchCaseNumeroDiasMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el mes entre 1 y 12");
        int mes = scanner.nextInt();
        System.out.println("Ingresa el año (YYYY)");
        int anio = scanner.nextInt();
        int numeroDias = 0;
        switch (mes){
            case 1, 3, 5, 7, 8, 10, 12:
                numeroDias = 31;
                break;
            case 4, 6, 9, 11:
                numeroDias = 30;
                break;
            case 2:
                if ( (anio % 400 == 0) || ( (anio % 4 == 0) && !(anio % 100 == 0) ) ){
                    numeroDias = 29;
                    System.out.println("29 días por año bisiesto");
                } else {
                    numeroDias = 28;
                }
            default:
                numeroDias = 0;
        }
        System.out.println("numero de dias del mes = " + numeroDias);

    }
}
