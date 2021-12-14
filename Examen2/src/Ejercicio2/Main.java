package Ejercicio2;

import Ejercicio2.Hilo;

import java.util.ArrayList;

public class Main {
    private static final int NUMERO_HILOS = 10;
    private static ArrayList<Thread> listaHilos = new ArrayList<Thread>();

    public static void main(String[] args) {
        listaHilos = crearHilos();
        for (Thread hilo: listaHilos) {
            hilo.start();
        }
    }

    public static ArrayList<Thread> crearHilos(){
        Comunicacion comunicacion = new Comunicacion();
        for(int i = 0; i < NUMERO_HILOS; i++){
            listaHilos.add(new Thread(new Hilo(i, comunicacion)));
        }
        return listaHilos;
    }
}
