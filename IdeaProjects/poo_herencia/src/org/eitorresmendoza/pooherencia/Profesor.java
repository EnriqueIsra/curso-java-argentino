package org.eitorresmendoza.pooherencia;

public class Profesor extends Persona{
    private String materia;

    public Profesor(){
        System.out.println("Profesor: inicializando constructor...");
    }

    public Profesor(String nombre, String apellido){
        super(nombre, apellido);
    }

    public Profesor(String nombre, String apellido, String materia){
        super(nombre, apellido);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String saludar() {
        return super.saludar() + ", buenos días soy el profesor " + getApellido() +
                ", imparto la materia de " + getMateria();
    }

    @Override
    public String toString() {
        return "Extrayendo datos desde la clase: " + Profesor.class.getCanonicalName() + "\n" +
                super.toString() + "\nProfesor{" +
                "materia='" + materia + '\'' +
                '}';
    }
}
