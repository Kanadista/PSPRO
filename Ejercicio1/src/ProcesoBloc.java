import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ProcesoBloc {


public static void main(String [] args) {
	
	File archivo = new File("C://Users/sforte/Documents/hola.txt");
	
	abrirBlocNotas();
	
	
}
	
public static void abrirBlocNotas() {
		
		ProcessBuilder pb = new ProcessBuilder("notepad");
		pb.inheritIO();
		Process proceso;
		int contador = 0;
		try {
			
			proceso = pb.start();
			
			
			do {
				
				System.out.println("El bloc de notas est� en ejecuci�n.");
				contador++;
				Thread.sleep(5000);
				
			}while(proceso.isAlive());
			
			
			System.out.println("El bloc de notas ha estado abierto " + contador * 5 + " segundos.");

		} catch (IOException | InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
}
