package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

public class Perro extends Canino{
    private int fuerzaMordida;

    public Perro(String habitat, float altura, float largo, float peso, String color,
                 float tamanioColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, color, tamanioColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "fuerzaMordida=" + fuerzaMordida +
                ", color='" + color + '\'' +
                ", tamanioColmillos=" + tamanioColmillos +
                ", habitat='" + habitat + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}' + "\n";
    }

    @Override
    public String comer() {
        return """
                Dieta: Los mejores alimentos para perros son el arroz, las carnes y los pescados y de frutas el plátano,\s
                el melón, la pera y la manzana. En cuanto a las verduras las opciones preferentes son las espinacas,\s
                la zanahoria y la lechuga.""";
    }

    @Override
    public String dormir() {
        return "Descanso: Un perro puede dormir cada día un mínimo de 12-13 horas y un máximo de 20 horas.";
    }

    @Override
    public String correr() {
        return "Velocidad: Hay razas de perros que pueden llegar a correr a una velocidad de hasta 60 kilómetros por hora";
    }

    @Override
    public String comunicarse() {
        return """
                Comunicación: Los perros se comunican con señales visuales como la postura del cuerpo,\s
                la posición de la cabeza, la posición de las orejas, la cola e incluso de su pelaje.\s
                También utilizan la vocalización, como ladrar o gruñir.""";
    }
}
