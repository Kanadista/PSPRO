import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMERO_HILOS = 10;
    private static final int MAXIMO_ALEATORIO = 20;

    public static void main (String [] args){

        ArrayList<Thread> listadoHilos = new ArrayList<Thread>();

        listadoHilos = crearHilos();

        for (Thread hilo:listadoHilos){
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Hilos finalizados.");
    }

    private static ArrayList<Thread> crearHilos(){
        Random random = new Random();
        ArrayList<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo(random.nextInt(MAXIMO_ALEATORIO) + 1)));
        }
        return hilos;
    }
}
