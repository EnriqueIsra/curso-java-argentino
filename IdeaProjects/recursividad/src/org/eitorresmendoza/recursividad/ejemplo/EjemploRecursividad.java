package org.eitorresmendoza.recursividad.ejemplo;

import org.eitorresmendoza.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete PC ATX");
        Componente fuentePoder = new Componente("Fuente de poder 700w");
        Componente placaMadre = new Componente("MainBoard Acer Intel");
        Componente cpu = new Componente("CPU AMD Ryzen 5 2800");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador CPU");
        Componente tarjetaVideo= new Componente("Nvidia RTX 3080 8GB");
        Componente gpu = new Componente("Nvidia RTX GPU");
        Componente gpuRam = new Componente("4bg ram");
        Componente gpuRam2 = new Componente("5gb ram");
        Componente gpuVentiladores= new Componente("Ventilaodres");
        Componente memoriaRam = new Componente("Memoria Ram 32GB");
        Componente ssd = new Componente("Disco SSD 2T");

        cpu.addComponente(ventilador)
                .addComponente(disipador);
        tarjetaVideo.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaMadre.addComponente(cpu)
                .addComponente(tarjetaVideo)
                .addComponente(memoriaRam)
                .addComponente(ssd);
        pc.addComponente(fuentePoder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado Vorago"))
                .addComponente(new Componente("Mouse Logitech"))
                .addComponente(new Componente("Televisor Speler"));

        metodoRecursivoJava8(pc, 0).forEach(componente -> System.out.println("\t-".repeat(componente.getNivel()) +
                componente.getNombre()));

    }
    public static Stream<Componente> metodoRecursivoJava8(Componente componente, int nivel){
        componente.setNivel(nivel);
        return Stream.concat(Stream.of(componente),
                componente.getHijos().stream().flatMap(hijo -> metodoRecursivoJava8(hijo, nivel + 1)));
    }
    public static void metodoRecursivo(Componente componente, int nivel){
        System.out.println("\t-".repeat(nivel) + componente.getNombre());
        if (componente.tieneHijos()){
            for (Componente hijo: componente.getHijos()){
                metodoRecursivo(hijo, nivel + 1);
            }
        }
    }
}
