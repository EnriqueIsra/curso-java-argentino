package org.eitorresmendoza.patrones.decorator;

import org.eitorresmendoza.patrones.decorator.decorators.MayusculaDecorador;
import org.eitorresmendoza.patrones.decorator.decorators.RemplazarEspaciosDecorador;
import org.eitorresmendoza.patrones.decorator.decorators.ReversaDecorador;
import org.eitorresmendoza.patrones.decorator.decorators.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola, yo soy Enrique Torres.");

        MayusculaDecorador mayusculaDecorador = new MayusculaDecorador(texto);
        RemplazarEspaciosDecorador remplazarEspaciosDecorador = new RemplazarEspaciosDecorador(mayusculaDecorador);
        ReversaDecorador reversaDecorador = new ReversaDecorador(remplazarEspaciosDecorador);
        SubrayadoDecorador subrayadoDecorador = new SubrayadoDecorador(reversaDecorador);

        System.out.println(subrayadoDecorador.darFormato());
    }
}
