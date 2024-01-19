public class ArgumentosLineaComandoCalculadora {
    public static void main(String[] args) {
        if (args.length != 3){
            System.out.println("Ingresa una opción (sumar, restar, multiplicar o dividir), " +
                    "también ingresa dos números");
            System.exit(-1);
        }
        String operacion = args[0];
        double a = 0;
        double b = 0;
        double resultado = 0;
        try {
            a = Double.parseDouble(args[1]);
            b = Double.parseDouble(args[2]);
        } catch (NumberFormatException e){
            System.err.println("Cuidado, los parámetros a y b solo pueden ser numéricos, intentalo de nuevo");
            System.exit(-1);
        }


        String signo = "";
        switch (operacion){
            case "sumar":
                resultado = (a + b);
                signo = " + ";
                break;
            case "multiplicar":
                resultado = a * b;
                signo = " * ";
                break;
            case "dividir":
                if (b == 0){
                    System.err.println("No es posible dividir entre cero");
                    System.exit(-1);
                }
                resultado = a / b;
                signo = " / ";
                break;
            case "disminuir":
                resultado = (a - b);
                signo = " - ";
            default:
                break;
        }
        System.out.println("El resultado de " + operacion + " " + a + signo + b + " es = " + resultado);
    }
}
