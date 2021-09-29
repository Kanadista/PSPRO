import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ProcesoBloc {


public static void main(String [] args) {
	
	File archivo = new File("C://Users/sforte/Documents/hola.txt");
	
	abrirBlocNotas();
	
	if(archivo.isFile()){
        System.out.println("El archivo hola.txt existe.");
    }else{
         System.out.println("El archivo hola.txt no existe.");
    }
}
	
public static void abrirBlocNotas() {
		
		ProcessBuilder pb = new ProcessBuilder("notepad");
		
		 Map<String, String> env = pb.environment();
		
		for (Map.Entry<String,String> entry : env.entrySet())
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());;
	    
		pb.inheritIO();
		Process proceso;
		try {
			
			proceso = pb.start();
			proceso.waitFor(7, TimeUnit.SECONDS);
			proceso.destroy();
		} catch (IOException | InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
}
