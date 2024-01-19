import java.util.Scanner;

public class ProgramaCalcularAreaCirculo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el radio del circulo");
        double radio = scanner.nextDouble();
        System.out.println("radio = " + radio);
        radio = Math.pow(radio, 2 );
        System.out.println("radio al cuadrado = " + radio);
        double pi = Math.PI;
        System.out.println("pi = " + pi);
        double areaCirculo = (pi * radio);
        System.out.println("areaCirculo = " + areaCirculo);

    }
}
