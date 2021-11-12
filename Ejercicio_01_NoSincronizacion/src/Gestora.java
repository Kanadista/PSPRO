import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Gestora {



    public static ArrayList<Integer> generarDatos(ArrayList<Integer> vector){

        Random random = new Random();

        for(int i = 0; i < 1000000; i++){

            vector.add(random.nextInt(10000) + 1);

        }

        return vector;
    }

}
