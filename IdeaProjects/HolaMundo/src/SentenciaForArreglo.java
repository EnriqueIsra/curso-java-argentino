import javax.swing.*;

public class SentenciaForArreglo {
    public static void main(String[] args) {
        String[] nombres = {"enrique", "santiago", "alejandra"};
        int count = nombres.length;
        for (int i = 0; i < count; i++){
            if(nombres[i].toLowerCase().contains("ENRIque".toLowerCase()) ||
                    nombres[i].toLowerCase().contains("SANTIAGO".toLowerCase())){
                continue;
            }
            System.out.println(i +".- " + nombres[i]);
        }

        String buscar = JOptionPane.showInputDialog("Ingrese un nombre, ejemplo \"santiago\" o \"Alejandra\"");
        System.out.println("buscar = " + buscar);

        boolean encontrado = false;
        for (int i = 0; i < count; i++){
            if(nombres[i].equalsIgnoreCase(buscar)){
                encontrado = true;
                break;
            }
            System.out.println(i +".- " + nombres[i]);
        }
        if (encontrado){
            JOptionPane.showMessageDialog(null, buscar + " fue encontrado");
        } else {
            JOptionPane.showMessageDialog(null, buscar + " no fue encontrado");
        }
    }
}
