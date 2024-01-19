package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

public class Gatopardo extends Felino{

    public Gatopardo(String habitat, float altura, float largo, float peso, float tamanioGarras, int velocidad) {
        super(habitat, altura, largo, peso, tamanioGarras, velocidad);
    }

    @Override
    public String toString() {
        return "Gatopardo{" +
                "tamanioGarras=" + tamanioGarras +
                ", velocidad=" + velocidad +
                ", habitat='" + habitat + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}' + "\n";
    }

    @Override
    public String comer() {
        return "Dieta: El leopardo adulto suele cazar cada dos o tres días y requiere de al menos unos 3-4 kilos de carne diarios para mantenerse bien alimentado";
    }

    @Override
    public String dormir() {
        return """
                Descanso: A estos felinos les suele gustar pasar el día durmiendo y la noche cazando,\s
                por lo que llegan a dormir entre 15 y 16 horas diarias,\s
                especialmente a las horas centrales del día.""";
    }

    @Override
    public String correr() {
        return "Velocidad: El guepardo suele moverse a una velocidad de 45 kilómetros por hora \n" +
                "y durante la persecución a su presa puede alcanzar los " + velocidad + " kilómetros por hora.";
    }

    @Override
    public String comunicarse() {
        return "Comunicación: Los guepardos se comunican a través del olor, el sonido y la postura del cuerpo. ";
    }
}
