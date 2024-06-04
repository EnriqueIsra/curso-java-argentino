package org.eitorresmendoza.hilos.hiloalfanumerico;

import java.util.concurrent.TimeUnit;

public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        // según el tipo, hace una u otra cosa
        try {
            switch (tipo){
                case NUMERO -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.print(i + "  ");
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
                case LETRA -> {
                    for (char c = 'A'; c <= 'Z'; c++){
                        System.out.print(c + "  ");
                        TimeUnit.MILLISECONDS.sleep(350);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
