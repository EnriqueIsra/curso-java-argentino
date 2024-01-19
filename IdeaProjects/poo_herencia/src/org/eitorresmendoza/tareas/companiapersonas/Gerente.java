package org.eitorresmendoza.tareas.companiapersonas;

public class Gerente extends Empleado{
    private double presupuesto;

    public Gerente(String nombre, String apellido, String nuemroFiscal,
                   String direccion, double remuneracion, int empleadoId, double presupuesto) {
        super(nombre, apellido, nuemroFiscal, direccion, remuneracion, empleadoId);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Gerente{" + "\n" +
                super.toString() +
                "presupuesto=" + presupuesto +
                '}';
    }
}
