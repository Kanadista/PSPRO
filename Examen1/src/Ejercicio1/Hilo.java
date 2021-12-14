public class Hilo implements Runnable{

   private int numeroAleatorio;

    public Hilo(int numeroAleatorio){

        this.numeroAleatorio = numeroAleatorio;
    }


    @Override
    public void run() {
        long resultado = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = numeroAleatorio; i > 1; i--){
            resultado = resultado * i;
        }

        System.out.println("Resultado del factorial: " + resultado);
    }
}
