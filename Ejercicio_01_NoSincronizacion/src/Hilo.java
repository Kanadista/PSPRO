import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hilo implements Runnable {

    private ArrayList<Integer> array;
    private float resultadoMedia;
    private int resultadoMaximo;
    private int resultadoMinimo;

    public Hilo(ArrayList<Integer> array){

        this.array = array;

    }

    public float calcularMedia(ArrayList<Integer> array){

        float resultado = 0;
        int suma = 0;

        for(int i = 0; i < array.size() && !Thread.currentThread().isInterrupted(); i++){

            suma += array.get(i);

        }

        if(!Thread.currentThread().isInterrupted()) {
            resultado = suma / array.size();

        }
        return resultado;
    }

    public int calcularMaximo(ArrayList<Integer> array){

        int maximo = 0;
        int foo;

        for(int i = 0; i < array.size() && !Thread.currentThread().isInterrupted(); i++){

            foo = array.get(i);

            if(foo > maximo){

                maximo = foo;

            }

        }

        return maximo;
    }

    public int calcularMinimo(ArrayList<Integer> array){

        int minimo = 0;
        int foo;

        for(int i = 0; i < array.size() && !Thread.currentThread().isInterrupted(); i++){

            foo = array.get(i);

            if(foo < minimo){

                minimo = foo;

            }

        }

        return minimo;
    }


    @Override
    public void run() {


        resultadoMedia = calcularMedia(array);
        resultadoMaximo = calcularMaximo(array);
        resultadoMinimo = calcularMinimo(array);


        if(!Thread.currentThread().isInterrupted()) {
            System.out.println("Media: " + resultadoMedia + " || Numero máximo: " + resultadoMaximo + "|| Numero mínimo: " + resultadoMinimo);
        }
    }
}
