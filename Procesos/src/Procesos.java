import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Procesos {

	public static void main (String [] args) {
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("Numero de procesadores: " + runtime.availableProcessors());		
	
		System.out.println("Memoria disponible: " + runtime.freeMemory());
		
		System.out.println("Memoria máxima: " + runtime.maxMemory());
		
		System.out.println("Memoria total: " + runtime.totalMemory());
		
		try {
			
		Process ejecucionComando = runtime.exec("cmd /c dir");
		ejecucionComando.waitFor();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(ejecucionComando.getInputStream()));
		
		String linea = " ";
		
		while((linea = br.readLine()) != null) {
			
			System.out.println(linea);
		}
		
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	
}
