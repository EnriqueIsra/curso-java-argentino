package org.eitorresmendoza.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {
        ConexionBDSingleton conexion = null;
        for (int i = 0; i < 10; i++) {
            conexion = ConexionBDSingleton.getInstancia();
            System.out.println("conexion = " + conexion);
        }
        ConexionBDSingleton conexion2 = ConexionBDSingleton.getInstancia();
        ConexionBDSingleton conexion3 = ConexionBDSingleton.getInstancia();
        boolean laMisma = ((conexion == conexion2) && (conexion2 == conexion3) && (conexion == conexion3));
        System.out.println("laMisma = " + laMisma); 
    }
}
