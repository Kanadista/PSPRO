public class HiloInverso implements Runnable {

    private Calculo calculo;


    public HiloInverso(Calculo c){

        this.calculo = c;

    }

    @Override
    public void run() {

        calculo.calcular4();
        calculo.calcular3();
        calculo.calcular2();
        calculo.calcular1();

    }
}
