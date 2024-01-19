package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

public class ProgramaMamiferos {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[5];

        Mamifero leon = new Leon("Bosques secos", 1.2f, 2.1f, 190f, 175f,
                74, 30, 110);
        Mamifero tigre = new Tigre("Selvas tropicales", 110f, 3.1f, 310f, 7.5f,
                65, "Tigre de bengala");
        Mamifero gatopardo = new Gatopardo("Sabanas", 70f, 160f, 90f, 7.5f,
                110);
        Mamifero lobo = new Lobo("Bosques de las montañas", 70f, 120f, 50f, "negro",
                2.5f, 20, "Canis Rufus");
        Mamifero perro = new Perro("Casas y hogares, sobreviven a lugares cálidos y fríos", 60f, 1.70f, 40, "Blanco con gris",
                1.5f, 300);

        mamiferos[0] = leon;
        mamiferos[1] = tigre;
        mamiferos[2] = gatopardo;
        mamiferos[3] = lobo;
        mamiferos[4] = perro;

        for (Mamifero mamifero: mamiferos){
            System.out.println("******************** " + mamifero.getClass().getSimpleName() + " ********************");
            System.out.println(mamifero);
            System.out.println(mamifero.comer());
            System.out.println(mamifero.dormir());
            System.out.println(mamifero.correr());
            System.out.println(mamifero.comunicarse());
        }
    }
}
