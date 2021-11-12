import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String [] args){

        Scanner teclado  = new Scanner(System.in);
        ArrayList<Thread> arrayHilos = new ArrayList<>();
        int milisegundos;
        ArrayList<Integer> vector1 = new ArrayList<Integer>();
        ArrayList<Integer> vector2 = new ArrayList<Integer>();
        ArrayList<Integer> vector3 = new ArrayList<Integer>();
        ArrayList<Integer> vector4 = new ArrayList<Integer>();
        ArrayList<Integer> vector5 = new ArrayList<Integer>();
        ArrayList<Integer> vector6 = new ArrayList<Integer>();
        ArrayList<Integer> vector7 = new ArrayList<Integer>();
        ArrayList<Integer> vector8 = new ArrayList<Integer>();
        ArrayList<Integer> vector9 = new ArrayList<Integer>();
        ArrayList<Integer> vector10 = new ArrayList<Integer>();
        ArrayList<Integer> vector11 = new ArrayList<Integer>();
        ArrayList<Integer> vector12 = new ArrayList<Integer>();
        ArrayList<Integer> vector13 = new ArrayList<Integer>();
        ArrayList<Integer> vector14 = new ArrayList<Integer>();
        ArrayList<Integer> vector15 = new ArrayList<Integer>();
        ArrayList<Integer> vector16 = new ArrayList<Integer>();
        ArrayList<Integer> vector17 = new ArrayList<Integer>();
        ArrayList<Integer> vector18 = new ArrayList<Integer>();
        ArrayList<Integer> vector19 = new ArrayList<Integer>();
        ArrayList<Integer> vector20 = new ArrayList<Integer>();

        vector1 = Gestora.generarDatos(vector1);
        vector2 = Gestora.generarDatos(vector2);
        vector3 = Gestora.generarDatos(vector3);
        vector4 = Gestora.generarDatos(vector4);
        vector5 = Gestora.generarDatos(vector5);
        vector6 = Gestora.generarDatos(vector6);
        vector7 = Gestora.generarDatos(vector7);
        vector8 = Gestora.generarDatos(vector8);
        vector9 = Gestora.generarDatos(vector9);
        vector10 = Gestora.generarDatos(vector10);
        vector11 = Gestora.generarDatos(vector11);
        vector12 = Gestora.generarDatos(vector12);
        vector13 = Gestora.generarDatos(vector13);
        vector14 = Gestora.generarDatos(vector14);
        vector15 = Gestora.generarDatos(vector15);
        vector16 = Gestora.generarDatos(vector16);
        vector17 = Gestora.generarDatos(vector17);
        vector18 = Gestora.generarDatos(vector18);
        vector19 = Gestora.generarDatos(vector19);
        vector20 = Gestora.generarDatos(vector20);

        Thread hilo1 = new Thread ( new Hilo(vector1));
        Thread hilo2 = new Thread ( new Hilo(vector2));
        Thread hilo3 = new Thread ( new Hilo(vector3));
        Thread hilo4 = new Thread ( new Hilo(vector4));
        Thread hilo5 = new Thread ( new Hilo(vector5));
        Thread hilo6 = new Thread ( new Hilo(vector6));
        Thread hilo7 = new Thread ( new Hilo(vector7));
        Thread hilo8 = new Thread ( new Hilo(vector8));
        Thread hilo9 = new Thread ( new Hilo(vector9));
        Thread hilo10 = new Thread ( new Hilo(vector10));
        Thread hilo11 = new Thread ( new Hilo(vector11));
        Thread hilo12 = new Thread ( new Hilo(vector12));
        Thread hilo13 = new Thread ( new Hilo(vector13));
        Thread hilo14 = new Thread ( new Hilo(vector14));
        Thread hilo15 = new Thread ( new Hilo(vector15));
        Thread hilo16 = new Thread ( new Hilo(vector16));
        Thread hilo17 = new Thread ( new Hilo(vector17));
        Thread hilo18 = new Thread ( new Hilo(vector18));
        Thread hilo19 = new Thread ( new Hilo(vector19));
        Thread hilo20 = new Thread ( new Hilo(vector20));


        System.out.println("Cuantos milisegundos deseas dar como margen a los calculos?: ");
        milisegundos = teclado.nextInt();


        try {

            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
            hilo6.start();
            hilo7.start();
            hilo8.start();
            hilo9.start();
            hilo10.start();
            hilo11.start();
            hilo12.start();
            hilo13.start();
            hilo14.start();
            hilo15.start();
            hilo16.start();
            hilo17.start();
            hilo18.start();
            hilo19.start();
            hilo20.start();

            Thread.sleep(milisegundos);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(hilo1.isAlive() && hilo2.isAlive() && hilo3.isAlive() && hilo4.isAlive() && hilo4.isAlive() && hilo5.isAlive() && hilo6.isAlive() && hilo7.isAlive() && hilo8.isAlive() && hilo9.isAlive() && hilo10.isAlive() && hilo11.isAlive() && hilo12.isAlive() && hilo13.isAlive() && hilo14.isAlive() && hilo15.isAlive() && hilo16.isAlive() && hilo17.isAlive() && hilo18.isAlive() && hilo19.isAlive() && hilo20.isAlive()){

            System.out.println("Tiempo máximo excedido. Se han cancelado los calculos.");

            hilo1.interrupt();
            hilo2.interrupt();
            hilo3.interrupt();
            hilo4.interrupt();
            hilo5.interrupt();
            hilo6.interrupt();
            hilo7.interrupt();
            hilo8.interrupt();
            hilo9.interrupt();
            hilo10.interrupt();
            hilo11.interrupt();
            hilo12.interrupt();
            hilo13.interrupt();
            hilo14.interrupt();
            hilo15.interrupt();
            hilo16.interrupt();
            hilo17.interrupt();
            hilo18.interrupt();
            hilo19.interrupt();
            hilo20.interrupt();
        }

    }
}
