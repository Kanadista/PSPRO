public class Calculo {


    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();
    private final Object lock4 = new Object();

    public Calculo(){

    }
    public void calcular1(){

        synchronized (lock1) {
            System.out.println("Iniciando calculo 1" + " Hilo " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finalizando calculo 1" + " Hilo " + Thread.currentThread().getId());

        }
    }

     public void calcular2(){

        synchronized (lock2) {
            System.out.println("Iniciando calculo 2" + " Hilo " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finalizando calculo 2" + " Hilo " + Thread.currentThread().getId());

        }
    }

    public void calcular3(){
        synchronized (lock3) {
            System.out.println("Iniciando calculo 3" + " Hilo " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finalizando calculo 3" + " Hilo" + Thread.currentThread().getId());
        }
    }

    public void calcular4(){

        synchronized (lock4) {
            System.out.println("Iniciando calculo 4" + " Hilo " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finalizando calculo 4" + " Hilo " + Thread.currentThread().getId());
        }
    }
}
