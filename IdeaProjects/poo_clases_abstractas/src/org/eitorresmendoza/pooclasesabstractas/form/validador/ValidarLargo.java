package org.eitorresmendoza.pooclasesabstractas.form.validador;

import org.eitorresmendoza.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

public class ValidarLargo extends Validador implements MensajeFormateable {
    protected String mensaje = "el campo %s debe tener mínimo %d caracteres y máximo %d caracteres";
    private int minimo;
    private int maximo = Integer.MAX_VALUE;

    public ValidarLargo() {
    }

    public ValidarLargo(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    @Override
    public boolean esValido(String valor) {
        // this.mensaje = String.format(this.mensaje, this.minimo, this.maximo);
        if (valor == null){
            return true;
        }
        int largo = valor.length();
        return (largo >= minimo && largo <= maximo);
    }
    public String getMensajeFormateado(String campo){
        return String.format(this.mensaje, campo, this.minimo, this.maximo);
    }
}
