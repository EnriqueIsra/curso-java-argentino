package org.eitorresmendoza.pooherencia;

public class Alumno extends Persona{
    private String institucion;
    private double calificacionMatematicas;
    private double calificacionHistoria;
    private double calificacionEspaniol;

    public Alumno(){
        System.out.println("Alumno: inicializando constructor...");
    }
    public Alumno(String nombre, String apellido){
        super(nombre, apellido);
    }
    public Alumno(String nombre, String apellido, int edad){
        super(nombre, apellido, edad);
    }
    public Alumno(String nombre, String apellido, int edad, String institucion){
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion,
                  double calificacionEspaniol, double calificacionHistoria, double calificacionMatematicas){
        this(nombre, apellido, edad, institucion);
        this.calificacionEspaniol = calificacionEspaniol;
        this.calificacionHistoria = calificacionHistoria;
        this.calificacionMatematicas = calificacionMatematicas;
    }
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getCalificacionMatematicas() {
        return calificacionMatematicas;
    }

    public void setCalificacionMatematicas(double calificacionMatematicas) {
        this.calificacionMatematicas = calificacionMatematicas;
    }

    public double getCalificacionHistoria() {
        return calificacionHistoria;
    }

    public void setCalificacionHistoria(double calificacionHistoria) {
        this.calificacionHistoria = calificacionHistoria;
    }

    public double getCalificacionEspaniol() {
        return calificacionEspaniol;
    }

    public void setCalificacionEspaniol(double calificacionEspaniol) {
        this.calificacionEspaniol = calificacionEspaniol;
    }

    @Override
    public String saludar(){
        return super.saludar() + ", soy un alumno y mi nombre es: " + getNombre();
    }

    public double calcularPromedio(){
        //System.out.println("calculando promedio en la clase: " + Alumno.class.getCanonicalName());
        return (calificacionMatematicas + calificacionHistoria + calificacionEspaniol) / 3;
    }

    @Override
    public String toString() {
        return "Extrayendo datos desde la clase: " + Alumno.class.getCanonicalName() + "\n" +
                super.toString() + "\nAlumno{" +
                "institucion='" + institucion + '\'' +
                ", calificacionMatematicas=" + calificacionMatematicas +
                ", calificacionHistoria=" + calificacionHistoria +
                ", calificacionEspaniol=" + calificacionEspaniol +
                ", promedio = " + this.calcularPromedio() +
                '}';
    }
}
