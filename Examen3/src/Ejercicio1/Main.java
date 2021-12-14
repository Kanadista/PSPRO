package Ejercicio1;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    private static final int NUMERO_HILOS = 10;
    private static ArrayList<Thread> listaHilos = new ArrayList<>();

    public static void main (String [] args){
        listaHilos = crearHilos();
        boolean terminado = false;
        for (Thread hilo: listaHilos) {
            hilo.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Thread hilo: listaHilos){
            if(hilo.isAlive()){
                terminado = true;
            }
        }

        if(terminado){
            System.out.println("Hilos demasiado lentos");
        }else{
            System.out.println("Hilos finalizados");
        }





    }

    public static ArrayList<Thread> crearHilos(){
        ArrayList<Thread> listaHilos = new ArrayList<>();
        for(int i = 0; i < NUMERO_HILOS; i++){
            listaHilos.add(new Thread(new Hilo()));
        }
        return listaHilos;
    }
}
