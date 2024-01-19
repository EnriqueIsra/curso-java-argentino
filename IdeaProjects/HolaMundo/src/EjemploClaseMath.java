public class EjemploClaseMath {
    public static void main(String[] args) {
        int absoluto = Math.abs(-3);
        System.out.println("absoluto = " + absoluto);
        absoluto = Math.abs(3);
        System.out.println("absoluto = " + absoluto);

        double max = Math.max(3.5, 1.2);
        System.out.println("max = " + max);
        double min = Math.min(3.5, 1.2);
        System.out.println("min = " + min);
        double techo = Math.ceil(3.5); //para redondear hacia arriba7
        System.out.println("techo = " + techo);
        double piso = Math.floor(3.5); // para redondear hacia abajo
        System.out.println("piso = " + piso);
        long entero = Math.round(3.5); // para redondear hacia abajo o hacia arriba
        System.out.println("entero = " + entero);
        entero = Math.round(3.4);
        System.out.println("entero = " + entero);
        entero = Math.round(Math.PI);
        System.out.println("entero = " + entero);
        // más métodos de Math
        /*
        función exponencial
         */
        double exponencial = Math.exp(1);
        System.out.println("exponencial = " + exponencial);
        double exponencial2 = Math.exp(2);
        System.out.println("exponencial2 = " + exponencial2);
        /*
        función logarítmica
         */
        double log = Math.log(10);
        System.out.println("log = " + log);
        /*
        elevar a una potencia
         */
        double potencia = Math.pow(10, 3);
        System.out.println("potencia = " + potencia);
        /*
        Obtener raíz cuadrada de un número
         */
        double raiz = Math.sqrt(5);
        System.out.println("raiz = " + raiz);
        /*
        métodos de trigonometría
         */
        double grados = Math.toDegrees(1.57/*aquí se le pasan los radianes*/);
        grados = Math.round(grados);
        System.out.println("convertir de radianes a grados = " + grados);

        double radianes = Math.toRadians(90.00/*aquí se le pasan los grados*/);
        System.out.println("convertir de grados a radianes = " + radianes);

        System.out.println("sin(90): " + Math.sin(radianes)); /*a los senos y los cosenos se les pasa el valor en radianes*/
        System.out.println("cos(90): " + Math.cos(radianes));

        radianes = Math.toRadians(180.00);
        System.out.println("cos(180): " + Math.cos(radianes));

        radianes = Math.toRadians(0.00);
        System.out.println("cos(0): " + Math.cos(radianes));
    }
}
