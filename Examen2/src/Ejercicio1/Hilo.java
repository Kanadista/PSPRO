package Ejercicio1;

public class Hilo implements Runnable{

    int[] listaNumeros;

    public Hilo(int[] listaNumeros){
        this.listaNumeros = listaNumeros;
    }
    @Override
    public void run() {
        double resultado = 0;
        for(int i = 0; i < listaNumeros.length; i++){
            resultado += listaNumeros[i];
        }
        System.out.println(resultado/listaNumeros.length);
    }
}
