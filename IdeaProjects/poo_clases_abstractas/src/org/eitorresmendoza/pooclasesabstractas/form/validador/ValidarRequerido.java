package org.eitorresmendoza.pooclasesabstractas.form.validador;

public class ValidarRequerido extends Validador{


    protected String mensaje = "El campo %s es requerido";
    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor != null && valor.length() > 0);
    }
}
