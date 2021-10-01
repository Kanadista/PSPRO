import java.io.File;
import java.io.IOException;

public class ProcesoBloc {

    public static void main(String [] args) {

        redirigirComando();


    }

    public static void redirigirComando() {

        ProcessBuilder pb = new ProcessBuilder("cmd");
        pb.inheritIO();
        pb.redirectInput(new File("comandos.txt"));
        pb.redirectOutput(new File("resultado.txt"));
        Process proceso;
        int contador = 0;
        try {

            proceso = pb.start();


        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}

