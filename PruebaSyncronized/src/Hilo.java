public class Hilo implements Runnable {

    private Calculo calculo;


    public Hilo(Calculo c){

        this.calculo = c;

    }

    @Override
    public void run() {

        calculo.calcular1();
        calculo.calcular2();
        calculo.calcular3();
        calculo.calcular4();

    }
}
