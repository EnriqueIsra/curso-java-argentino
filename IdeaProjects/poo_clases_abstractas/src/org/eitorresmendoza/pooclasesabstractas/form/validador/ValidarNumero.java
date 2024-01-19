package org.eitorresmendoza.pooclasesabstractas.form.validador;

public class ValidarNumero extends Validador{

    protected String mensaje = "El campo %s debe ser numérico";
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
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException numberFormatException){
            return false;
        }
    }
}
