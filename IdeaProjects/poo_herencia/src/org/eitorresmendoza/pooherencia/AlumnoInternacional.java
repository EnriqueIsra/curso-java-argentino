package org.eitorresmendoza.pooherencia;

public final class AlumnoInternacional extends Alumno{
    private String pais;
    private double calificacionIdiomas;

    public AlumnoInternacional(){
        System.out.println("AlumnoInternacional: inicializando constructor...");
    }

    public AlumnoInternacional(String nombre, String apellido){
        super(nombre, apellido);
    }
    public AlumnoInternacional(String nombre, String apellido, String pais){
        super(nombre, apellido);
        this.pais = pais;
    }
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getCalificacionIdiomas() {
        return calificacionIdiomas;
    }

    public void setCalificacionIdiomas(double calificacionIdiomas) {
        this.calificacionIdiomas = calificacionIdiomas;
    }

    @Override
    public String saludar(){
        return super.saludar() + ", soy el alumno extranjero, vengo de " + getPais();
    }

    @Override
    public double calcularPromedio() {
        //System.out.println("Calculando promedio desde: " + AlumnoInternacional.class.getCanonicalName());
        return ((super.calcularPromedio() * 3) + calificacionIdiomas) / 4;
    }

    @Override
    public String toString() {
        return "Extrayendo datos desde la clase: " + AlumnoInternacional.class.getCanonicalName() + "\n" +
                super.toString() + "\nAlumnoInternacional{" +
                "pais='" + pais + '\'' +
                ", calificacionIdiomas=" + calificacionIdiomas +
                '}';
    }
}
