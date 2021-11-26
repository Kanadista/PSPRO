import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String [] args){

        Scanner teclado  = new Scanner(System.in);
        ArrayList<Integer> prioridades = new ArrayList<Integer>();
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


        for(int i = 0; i < 6; i++){

            prioridades.add(i);
        }




        for(int i = 0; i < 20; i++){

            if(i < 10) {
                Thread hilo = new Thread(new Hilo(vector1));
                hilo.setPriority(Thread.MAX_PRIORITY);
                arrayHilos.add(hilo);
            }

            Thread hilo = new Thread(new Hilo(vector1));
            arrayHilos.add(hilo);
        }

        System.out.println("Cuantos milisegundos deseas dar como margen a los calculos?: ");
        milisegundos = teclado.nextInt();


        try {

            for (Thread hilo: arrayHilos) {

                hilo.start();

            }

            Thread.sleep(milisegundos);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Thread hilo: arrayHilos) {

            if(hilo.isAlive()) {

                System.out.println("Tiempo máximo excedido. Se han cancelado los calculos.");
                hilo.interrupt();

            }

        }

    }
}
