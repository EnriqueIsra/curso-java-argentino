package org.eitorresmendoza.tareas.companiapersonas;


public class Cliente extends Persona {
    private int clienteId;
    public Cliente(String nombre, String apellido, String nuemroFiscal, String direccion, int clienteId) {
        super(nombre, apellido, nuemroFiscal, direccion);
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return "Cliente{" + "\n" +
                super.toString() +
                "clienteId=" + clienteId +
                '}';
    }
}
