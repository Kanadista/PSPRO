package Ejercicio2;

public class Hilo implements Runnable {
    private int numeroHilo;
    final Comunicacion comunicacion;

    public Hilo(int numeroHilo, Comunicacion comunicacion){
        this.numeroHilo = numeroHilo;
        this.comunicacion = comunicacion;
    }

    @Override
    public void run() {
        synchronized (comunicacion) { //COÑO
            for (int i = 0; i < 3; i++) {
                comunicacion.enviar("Datos numero " + i + " del hilo " + numeroHilo);
            }
        }
    }
}
