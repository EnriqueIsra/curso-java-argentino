import java.util.Scanner;

public class ProgramaNotasAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double contadorCalifsMayor70 = 0;
        double contadorCalifsMenor70 = 0;
        double sumaCalifsMayor70 = 0;
        double sumaCalifsMenor70 = 0;
        double sumaTodasCalifs = 0;
        double calif ;
        double promedioCalifsMayor70, promedioCalifsMenor70;
        boolean error = false;

        for(int i = 0; i < 20; i++ ){
            System.out.println("Ingresar nota: " + (i + 1));
            calif = scanner.nextDouble();
            if(calif < 0 || calif > 100){
                error = true;
                break;
            }
            if (calif < 70){
                contadorCalifsMenor70++;
                sumaCalifsMenor70 += calif;
            } else if (calif >= 70) {
                contadorCalifsMayor70++;
                sumaCalifsMayor70 += calif;
            }
            sumaTodasCalifs += calif;
        }
        if (error){
            System.out.println("Error: la calificación no puede ser menor que 0 ni mayor que 100 puntos");
            System.exit(1);
        }
        if (contadorCalifsMayor70 == 0){
            System.out.println("No hay calificaciones aprobatorias");
        } else {
            promedioCalifsMayor70 = sumaCalifsMayor70 / contadorCalifsMayor70;
            System.out.println("Promedio de calificaciones mayores e iguales a 70: " + promedioCalifsMayor70);
            System.out.println("Numero de calificaciones mayores e iguales que 70: " + contadorCalifsMayor70);
        }
        if (contadorCalifsMenor70 == 0){
            System.out.println("No hay calificaciones reprobatorias");
        } else {
            promedioCalifsMenor70 = sumaCalifsMenor70 / contadorCalifsMenor70;
            System.out.println("Promedio de calificaciones menores que 70: " + promedioCalifsMenor70);
            System.out.println("Numero de calificaciones menores que 70: " + contadorCalifsMenor70);
        }
        double promedioTodasCalif = sumaTodasCalifs / 20;
        System.out.println("El promedio general es de: " + promedioTodasCalif);

    }

}
