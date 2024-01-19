package org.eitorresmendoza.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Imprimible{

    private Persona persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculo(String contenido, Persona persona, String carrera) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencia(String experiencia){
        experiencias.add(experiencia);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder stringBuilder = new StringBuilder("Nombre: ");
        stringBuilder.append(persona)
                .append("\n")
                .append("Resumen: ").append(this.contenido)
                .append("\n")
                .append("Persona: ").append(this.carrera)
                .append("\n")
                .append("Experiencias: \n");
        for (String experiencia: this.experiencias){
            stringBuilder.append("- ").append(experiencia).append("\n");
        }
        return stringBuilder.toString();
    }
}
