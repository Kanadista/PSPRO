package Ejercicio2;

import java.util.ArrayList;

public class Main {
    private static final int NUMERO_HILOS = 10;
    private static ArrayList<Thread> listaHilos = new ArrayList<Thread>();

    public static void main (String [] args){
        listaHilos = crearHilo();

        for (Thread hilo: listaHilos) {
            hilo.start();
        }

    }

    public static ArrayList<Thread> crearHilo(){
        Secreto secreto = new Secreto();
        ArrayList<Thread> listaHilos = new ArrayList<Thread>();
        for(int i = 0; i < NUMERO_HILOS; i++){
            listaHilos.add(new Thread(new Hilo(secreto)));
        }
        return listaHilos;
    }
}
