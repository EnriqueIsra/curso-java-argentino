import java.util.Scanner;

public class EjemploArregloNotasAlumnos {
    public static void main(String[] args) {
        double[] claseMatematicas, calseHistoria, claseLenguaje;
        double sumNotasMate = 0, sumNotasHist = 0, sumNotasLengu = 0;

        claseMatematicas = new double[7];
        calseHistoria = new double[7];
        claseLenguaje = new double[7];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa las calificaciones de matemáticas de los 7 alumnos");
        for (int i = 0; i < claseMatematicas.length; i++) {
            claseMatematicas[i] = scanner.nextDouble();
        }
        System.out.println("Ingresa las calificaciones de historia de los 7 alumnos");
        for (int i = 0; i < calseHistoria.length; i++) {
            calseHistoria[i] = scanner.nextDouble();
        }
        System.out.println("Ingresa las calificaciones de lenguaje de los 7 alumnos");
        for (int i = 0; i < claseLenguaje.length; i++) {
            claseLenguaje[i] = scanner.nextDouble();
        }
        for (int i = 0; i < 7; i++) {
            sumNotasMate += claseMatematicas[i];
            sumNotasHist += calseHistoria[i];
            sumNotasLengu += claseLenguaje[i];
        }
        double promedioMatematicas = (sumNotasMate/claseMatematicas.length);
        double promedioHistoria = (sumNotasHist/calseHistoria.length);
        double promedioLenguaje = (sumNotasLengu/claseLenguaje.length);
        double promedioTotal = (promedioLenguaje + promedioHistoria + promedioMatematicas) / 3;
        System.out.println("Promedio total del curso: " + promedioTotal);
        System.out.println("Ingrese el identificador del alumno (de 0 - 6): ");
        int id = scanner.nextInt();
        double promedioAlumno = (claseMatematicas[id] + calseHistoria[id] + claseLenguaje[id]) / 3;
        System.out.println("promedio del alumno " + id + ": " + promedioAlumno);
    }
}