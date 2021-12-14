import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    private static final int NUMERO_HILOS = 10;


    public static void main (String [] args){

         ArrayList<Thread> listaHilos = crearHilos();

        for (Thread hilo: listaHilos) {
            hilo.start();
        }
    }

    private static ArrayList<Thread> crearHilos(){
        ArrayList<Thread> listaHilos = new ArrayList<Thread>();
        Contador cont = new Contador();
        for(int i = 0; i < NUMERO_HILOS; i++){
            listaHilos.add(new Thread(new Hilo(cont)));
        }
        return listaHilos;
    }
}
