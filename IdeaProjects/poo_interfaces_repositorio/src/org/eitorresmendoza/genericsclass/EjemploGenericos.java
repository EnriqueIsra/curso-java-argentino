package org.eitorresmendoza.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T> camion){
        int contadorAnimales = 1;
        int contadorMaquinas = 1;
        int contadorCarros = 1;
        for (T camionDe: camion){
            if (camionDe instanceof Animal){
                System.out.println("Nombre del animal " + contadorAnimales + ": " + ((Animal) camionDe).getNombre() + " - Tipo: " + ((Animal)camionDe).getTipo());
                contadorAnimales++;
            } else if (camionDe instanceof Maquinaria) {
                System.out.println("Nombre de la máquina " + contadorMaquinas + ": " + ((Maquinaria) camionDe).getTipo());
                contadorMaquinas++;
            } else if (camionDe instanceof Automovil) {
                System.out.println("Marca del carro " + contadorCarros + ": " + ((Automovil) camionDe).getMarca());
                contadorCarros++;
            }
        }
    }
    public static void main(String[] args) {


        System.out.println("********************* Cargando Camión de Animales *********************");
        Camion<Animal> camionAnimales = new Camion<>(5);
        camionAnimales.add(new Animal("Mimous", "Gato"));
        camionAnimales.add(new Animal("Mima", "Gato"));
        camionAnimales.add(new Animal("Bobby", "Perro"));
        camionAnimales.add(new Animal("Huesitos", "Gato"));
        camionAnimales.add(new Animal("Güero", "Gato"));

        imprimirCamion(camionAnimales);

        System.out.println("********************* Cargando Camión de Máquinas *********************");
        Camion<Maquinaria> camionMaquinas = new Camion<>(3);
        camionMaquinas.add(new Maquinaria("Bulldozer"));
        camionMaquinas.add(new Maquinaria("Excavadora"));
        camionMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(camionMaquinas);

        System.out.println("********************* Cargando Camión de Carros *********************");
        Camion<Automovil> camionCarros = new Camion<>(3);
        camionCarros.add(new Automovil("Mitsubishi"));
        camionCarros.add(new Automovil("Nissan"));
        camionCarros.add(new Automovil("Honda"));

        imprimirCamion(camionCarros);
    }
}
