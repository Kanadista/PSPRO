import java.security.SecureRandom;
import java.util.ArrayList;

public class Gestora {



    public static ArrayList<Integer> generarDatos(ArrayList<Integer> vector){

        SecureRandom random = new SecureRandom();

        for(int i = 0; i < 1000000; i++){

            vector.add(random.nextInt(10000));

        }

        return vector;
    }

}
