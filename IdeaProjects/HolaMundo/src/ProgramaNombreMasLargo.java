import javax.swing.*;

public class ProgramaNombreMasLargo {
    public static void main(String[] args) {
        String nombre1 = JOptionPane.showInputDialog("Ingresa el primer nombre");
        String nombre2 = JOptionPane.showInputDialog("Ingresa el segundo nombre");
        String nombre3 = JOptionPane.showInputDialog("Ingresa el tercer nombre");

        String nombreMasLargo = (nombre1.length() > nombre2.length()) ? nombre1: nombre2;
        nombreMasLargo = (nombre3.length() > nombreMasLargo.length()) ? nombre3: nombreMasLargo;

        JOptionPane.showMessageDialog(null, "El nombre mas largo es: " + nombreMasLargo);
        JOptionPane.showMessageDialog(null,
                nombre1 + " tiene " + nombre1.length() + " caracteres\n" +
                        nombre2 + " tiene " + nombre2.length() + " caracteres\n" +
                        nombre3 + " tiene " + nombre3.length() + " caracteres\n" );

    }
}
