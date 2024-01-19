public class OperadoresLogicos {
    public static void main(String[] args) {
        int i = 3;
        byte j = 3;
        float k = 127e-7f;
        double l = 2.1413e3;
        boolean m = false;

        boolean b1 = i == j && k < l && m == false;  // == primer operador de relacion, compara literales con primitivos o viceversa o de los dos
        System.out.println("b1 = " + b1);

        boolean b2 = i == j || k < l;
        System.out.println("b2 = " + b2);

        boolean b3 = i == j && (k < l || m == true);
        System.out.println("b3 = " + b3);

        boolean b4 = (i == j || k < l) && m == true;
        System.out.println("b4 = " + b4);

        boolean b5 = (true || true) && false;
        System.out.println("b5 = " + b5);

        boolean b6 = true || false && false || false; // true
        System.out.println("b6 = " + b6);

        boolean b7 = ((true || false) && false) || false; // false
        System.out.println("b7 = " + b7); // en los operadores logicos el and expresado como && tiene la prioridad ante el or expresado con ||
        // Usar paréntesis es recomendado para trabajar con expresiones de este tipo

    }
}
