import java.util.Random;

public class EjemploClaseMathRandom {
    public static void main(String[] args) {
        String[] colores = {"azul", "amarillo", "rojo", "verde", "blanco", "negro", "morado", "gris", "naranja", "plata"};
        double random = Math.random();
        System.out.println("random = " + random);
        random *= colores.length;
        System.out.println("random = " + random);

        random = Math.floor(random);
        System.out.println("random = " + random);
        System.out.println("colores = " + colores[(int)random]);

        Random random1 = new Random();
        int randomInt = 15 + random1.nextInt(25 - 15 + 1);
        System.out.println("randomInt = " + randomInt);

        randomInt =  random1.nextInt(colores.length);
        System.out.println("randomInt = " + randomInt);
        System.out.println("colores = " + colores[randomInt]);
    }
}
