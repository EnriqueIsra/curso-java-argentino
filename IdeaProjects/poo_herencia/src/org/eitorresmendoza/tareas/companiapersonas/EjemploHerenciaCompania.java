package org.eitorresmendoza.tareas.companiapersonas;

public class EjemploHerenciaCompania {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Enrique", "Torres", "TOME990104",
                "La luz #boulas", 15000.00, 50579475, 5000);
        gerente.aumentarRemuneracion(15);
        gerente.setPresupuesto(21000);
        System.out.println(gerente);
    }
}
