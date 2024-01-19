package org.eitorresmendoza.tareas.companiapersonas;


public class Empleado extends Persona {
    private double remuneracion;
    private int empleadoId;

    public Empleado(String nombre, String apellido, String nuemroFiscal, String direccion, double remuneracion, int empleadoId) {
        super(nombre, apellido, nuemroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje){
        this.remuneracion = remuneracion * porcentaje / 100;
    }

    @Override
    public String toString() {
        return "Empleado{" + "\n" +
                super.toString() +
                "remuneracion=" + remuneracion +
                ", empleadoId=" + empleadoId +
                '}';
    }
}
