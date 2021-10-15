public class PruebaSyncronized {

    public static void main (String [] args){

        Calculo c = new Calculo();
        Calculo c2 = new Calculo();


        Thread h1 = new Thread(new Hilo(c));
        Thread h2 = new Thread(new Hilo(c));
        Thread h3 = new Thread(new Hilo(c));
        Thread h4 = new Thread(new Hilo(c));
        Thread h5 = new Thread(new Hilo(c));
        Thread h11 = new Thread(new HiloInverso(c2));
        Thread h12 = new Thread(new HiloInverso(c2));
        Thread h13 = new Thread(new HiloInverso(c2));
        Thread h14 = new Thread(new HiloInverso(c2));
        Thread h15 = new Thread(new HiloInverso(c2));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h11.start();
        h12.start();
        h13.start();
        h14.start();
        h15.start();

    }
    }
