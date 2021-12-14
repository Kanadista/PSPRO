public class Hilo implements Runnable {

    int numeroIncrementado;
    Contador cont;

    public Hilo(Contador cont){
        this.cont = cont;
    }

    @Override
        public void run() {
        while(cont.incrementar()){
            numeroIncrementado++;
        }
        System.out.println("He incrementado " + numeroIncrementado + " veces");
    }
}
