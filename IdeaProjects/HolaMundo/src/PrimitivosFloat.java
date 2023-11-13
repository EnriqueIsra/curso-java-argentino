public class PrimitivosFloat {
    public static void main(String[] args) {
        float realFloat = 0.00000000015f; //1.5e-10f;
        System.out.println("realFloat = " + realFloat);
        System.out.println("Float corresponde en Bytes a: " + Float.BYTES);
        System.out.println("Float corresponde en Bytes a: " + Float.SIZE);
        System.out.println("Máximo valor para Float: " + Float.MAX_VALUE);
        System.out.println("Mínimo valor para Float: " + Float.MIN_VALUE);

        double realDouble = 3.4028235E39;
        System.out.println("realDouble = " + realDouble);
        System.out.println("Double corresponde en Bytes a: " + Double.BYTES);
        System.out.println("Double corresponde en Bytes a: " + Double.SIZE);
        System.out.println("Máximo valor para Double: " + Double.MAX_VALUE);
        System.out.println("Mínimo valor para Double: " + Double.MIN_VALUE);

        var varFlotante = 3.1436f;
        System.out.println("varFlotante = " + varFlotante);

    }
}
