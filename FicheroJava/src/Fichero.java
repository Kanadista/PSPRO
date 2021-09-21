import java.io.*;
import java.util.Scanner;
	
public class Fichero {
	    public static void main(String[] args)
	    {
	        FileWriter fichero = null;
	        PrintWriter pw = null;
	        String titulo = " ";
	        String texto = " ";
	        Scanner teclado = new Scanner(System.in);
	        Scanner teclado1 = new Scanner(System.in);
	        
	        
	        System.out.println("Como desea que se llame el archivo?: ");
	        titulo = teclado.nextLine();
	        
	        System.out.println("Que texto deseas que contenga?: ");
	        texto = teclado1.nextLine();
	        
	        try
	        {
	            fichero = new FileWriter("D:/Programacion-GitHub/" + titulo + ".txt");
	            pw = new PrintWriter(fichero);
	            pw.println(texto);
	                
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	    }
}

