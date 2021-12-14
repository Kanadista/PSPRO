package Ejercicio1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final int NUMERO_HILOS = 10;
    private static final int LONGITUD_VECTOR = 10000;
    private static ArrayList<Thread> listaHilos = new ArrayList<Thread>();

    public static void main(String[] args) {
        listaHilos = crearHilos();

        for (Thread hilo: listaHilos) {
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hilos finalizados");
    }

    public static ArrayList<Thread> crearHilos(){
        for(int i = 0; i < NUMERO_HILOS; i++){
            listaHilos.add(new Thread(new Hilo(crearVectorAleatorio())));
        }
        return listaHilos;
    }

    public static int[] crearVectorAleatorio(){
        Random rng = new Random();
        int[] vectorAleatorio = new int[LONGITUD_VECTOR];
        for(int i = 0; i < LONGITUD_VECTOR; i++){
            vectorAleatorio[i] = rng.nextInt(2);
        }
        return vectorAleatorio;
    }
}
