package Ejercicio2;

import java.util.Random;

public class Secreto {

    private int numeroAleatorio;
    private boolean acertado = false;
    private Random rng = new Random();

    public Secreto(){
        this.numeroAleatorio = rng.nextInt(1000)+1;
    }

    public boolean getAcertado(){
        return acertado;
    }
    public synchronized int adivinar(int numero){
        int resultadoAcierto = 0;
        if(!acertado) {
            if (numero == numeroAleatorio) {
                resultadoAcierto = 1;
                acertado = true;
            } else {
                resultadoAcierto = 0;
            }
        }else{
            resultadoAcierto = -1;
        }
        return resultadoAcierto;
    }

}
