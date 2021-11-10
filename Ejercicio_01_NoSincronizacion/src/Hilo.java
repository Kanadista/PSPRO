import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hilo implements Runnable {

    private ArrayList<Integer> array;

    public Hilo(ArrayList<Integer> array){

        this.array = array;

    }

    public float calcularMedia(ArrayList<Integer> array){

        float resultado;
        int suma = 0;

        for(int i = 0; i < array.size(); i++){

            suma += array.get(i);

        }

        resultado = suma / array.size();

        return resultado;
    }

    public int calcularMaximo(ArrayList<Integer> array){

        int maximo = 0;
        int foo;

        for(int i = 0; i < array.size(); i++){

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

        for(int i = 0; i < array.size(); i++){

            foo = array.get(i);

            if(foo < minimo){

                minimo = foo;

            }

        }

        return minimo;
    }


    @Override
    public void run() {

        System.out.println("Media: " + calcularMedia(array) + "Numero máximo: " + calcularMaximo(array) + "Numero mínimo: " + calcularMinimo(array));

    }
}
