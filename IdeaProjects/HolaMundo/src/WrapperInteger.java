public class WrapperInteger {
    public static void main(String[] args) {
        int primitivoInt = 32768;
        Integer objetoInt = Integer.valueOf(primitivoInt);
        Integer objetoInt2 = primitivoInt;
        System.out.println("objetoInt = " + objetoInt);

        int num = objetoInt;
        System.out.println("num = " + num);
        int num2 = objetoInt.intValue();
        System.out.println("num2 = " + num2);

        String valorLSD = "100";
        Integer valorLsd = Integer.valueOf(valorLSD);
        System.out.println("valorLsd = " + valorLsd);

        Short objetoShort = objetoInt.shortValue();
        System.out.println("objetoShort = " + objetoShort);

        Byte objetoByte = objetoInt.byteValue();
        System.out.println("objetoByte = " + objetoByte);

        Long objetoLong = objetoInt.longValue();
        System.out.println("objetoLong = " + objetoLong);
    }
}
