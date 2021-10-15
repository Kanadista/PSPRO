public class Calculo {



    public Calculo(){

    }


    synchronized public void calcular1(){

        System.out.println("Iniciando calculo 1" + " Hilo " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finalizando calculo 1" + " Hilo " + Thread.currentThread().getId());

    }

    synchronized public void calcular2(){

        System.out.println("Iniciando calculo 2" + " Hilo " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finalizando calculo 2" + " Hilo " + Thread.currentThread().getId());

    }

    synchronized public void calcular3(){

        System.out.println("Iniciando calculo 3" + " Hilo " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finalizando calculo 3" + " Hilo" + Thread.currentThread().getId());

    }

    synchronized public void calcular4(){

        System.out.println("Iniciando calculo 4" + " Hilo " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finalizando calculo 4" + " Hilo " + Thread.currentThread().getId());
    }

}
