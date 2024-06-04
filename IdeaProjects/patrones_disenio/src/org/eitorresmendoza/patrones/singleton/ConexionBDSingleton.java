package org.eitorresmendoza.patrones.singleton;

public class ConexionBDSingleton {
    private static ConexionBDSingleton instancia;
    private ConexionBDSingleton(){
        System.out.println("Conectándose al motor de la base de datos");

    }

    public static ConexionBDSingleton getInstancia(){
        if(instancia == null){
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }
}
