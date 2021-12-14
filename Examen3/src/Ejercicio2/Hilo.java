package Ejercicio2;

import java.util.Random;

public class Hilo implements Runnable {

     private final Secreto secreto;
     private Random rng = new Random();

    public Hilo (Secreto secreto){
        this.secreto = secreto;
    }

    @Override
    public void run() {
        int resultado = 0;
            while(!secreto.getAcertado()) {
               resultado = secreto.adivinar(rng.nextInt(1000) + 1);
            }
            if(resultado == 1){
                System.out.println("He acertado " + Thread.currentThread().getName());
            }else{
                System.out.println("Ha acertado otro hilo");
            }
    }
}
