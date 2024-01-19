import javax.swing.*;

public class ProgramaGasolina {
    public static void main(String[] args) {
        Double nivelMaximo = 70.0;
        Double nivelGas = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el nivel actual de gasolina en litros"));
        if(nivelGas > 70){
            JOptionPane.showMessageDialog(null,"El tanque no puede tener más de " + nivelMaximo + " litros, tiene: " + nivelGas + " litros");
        } else if(nivelGas == 70){
            JOptionPane.showMessageDialog(null,"El tanque esta lleno, tiene: " + nivelGas + " litros");
        } else if( (nivelGas <= 69.99) && (nivelGas >=60) ) {
            JOptionPane.showMessageDialog(null, "El tanque casi esta lleno, tiene: " + nivelGas + " litros");
        } else if( (nivelGas <= 59.99) && (nivelGas >=40) ) {
            JOptionPane.showMessageDialog(null, "El tanque esta a 3 cuartos, tiene: " + nivelGas + " litros");
        } else if( (nivelGas <= 39.99) && (nivelGas >=35) ) {
            JOptionPane.showMessageDialog(null, "El tanque esta a nivel medio, tiene: " + nivelGas + " litros");
        } else if( (nivelGas <= 34.99) && (nivelGas >=20) ) {
            JOptionPane.showMessageDialog(null, "El tanque tiene un nivel suficiente, tiene: " + nivelGas + " litros");
        }else if( (nivelGas <= 19.99) && (nivelGas >=1) ) {
            JOptionPane.showMessageDialog(null, "El tanque tiene un nivel insuficiente, tiene: " + nivelGas + " litros");
        }
    }
}
