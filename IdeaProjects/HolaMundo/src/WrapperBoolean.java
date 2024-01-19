public class WrapperBoolean {
    public static void main(String[] args) {
        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        boolean primBoolean = num1 > num2;
        Boolean objBoolean = Boolean.valueOf(primBoolean);
        Boolean objBoolean2 = Boolean.valueOf("false");
        Boolean objBoolean3 = true;

        System.out.println("primBolean = " + primBoolean);
        System.out.println("objBoolean = " + objBoolean);
        System.out.println("objBoolean2 = " + objBoolean2);

        System.out.println("Comparando objetos booleanos: " + (primBoolean == objBoolean));
        System.out.println("Comparando objetos booleanos: " + (objBoolean.equals(objBoolean2)));
        System.out.println("Comparando objetos booleanos: " + (objBoolean2 == objBoolean3));
        System.out.println("Comparando objetos booleanos: " + (objBoolean == objBoolean3));

        boolean primBoolean2 = objBoolean2.booleanValue();
        System.out.println("primBoolean2 = " + primBoolean2);
    }
}
