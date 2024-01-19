import javax.swing.*;

public class ProgramaMultiplicarDosNumerosSinSimboloMultiplicacion {
    public static void main(String[] args) {

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número positivo o negativo"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un segundo número positivo o negativo"));
        int resultado = 0;
        boolean positivoNum1 = num1 > -1;
        boolean positivoNum2 = num2 > -1;
        int absolutoNum1 = positivoNum1 ? num1: -num1;
        for (int i = 0; i < absolutoNum1; i++){
            resultado = resultado + num2;
        }
        if ( (!positivoNum1 && !positivoNum2) || !positivoNum1){
            resultado = -resultado;
        }
        JOptionPane.showMessageDialog(null, "el resultado es: " + resultado);
    }
}
