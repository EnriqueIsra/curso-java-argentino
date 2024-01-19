package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

public class Lobo extends Canino {

    private int numCamada;
    private String especieLobo;

    public Lobo(String habitat, float altura, float largo, float peso, String color,
                float tamanioColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, color, tamanioColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    public int getNumCamada() {
        return numCamada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    @Override
    public String toString() {
        return "Lobo{" +
                "numCamada=" + numCamada +
                ", especieLobo='" + especieLobo + '\'' +
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
        return "Dieta: El lobo " + especieLobo + " caza junto a su grupo de " + numCamada + " individuos en los bosques de " + habitat;
    }

    @Override
    public String dormir() {
        return "Descanso: El lobo duerme entre 4 a 10 horas por noche, con un promedio de 7 a 8 horas";
    }

    @Override
    public String correr() {
        return "Velocidad: El lobo puede correr a una velocidad de hasta 60 kilómetros por hora.";
    }

    @Override
    public String comunicarse() {
        return """
                Comunicación: Los lobos pueden aullar para localizar a otros lobos,\s
                anunciar el tamaño de su manada, advertir a otros miembros de la familia\s
                del peligro usando un aullido de ladrido y más.\n""";
    }
}
