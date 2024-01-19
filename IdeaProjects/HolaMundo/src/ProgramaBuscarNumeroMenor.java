import java.util.Scanner;

public class ProgramaBuscarNumeroMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa cúantos números vas a comparar");
        int cantidadNumeros =  scanner.nextInt();

        if (cantidadNumeros < 10){
            System.out.println("Error: se deben comparar mínimo 10 números en total");
        } else {
            int numeroMenor = Integer.MAX_VALUE;
            int numeroUser;
            for(int i = 0; i < cantidadNumeros; i ++) {
                System.out.println("Ingresa el número " + (i + 1) + ": ");
                numeroUser = scanner.nextInt();
                numeroMenor = (numeroUser < numeroMenor)? numeroUser : numeroMenor;
            }
            System.out.println("El número menor es: " + numeroMenor);
            if(numeroMenor < 10){
                System.out.println("el número: " + numeroMenor + " es menor que 10");
            } else {
                System.out.println("el número: " + numeroMenor + " es mayor que o igual a 10");
            }
        }
    }
}
