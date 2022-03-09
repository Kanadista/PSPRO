import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final String PEDIR_CADENA = "Escriba la cadena a representar como hash";
    public static final String PEDIR_RUTA = "Escriba la ruta de el fichero a representar como hash";
    public static final String RUTA_ARCHIVO_HASH = "hash.txt";
    public static final String CLAVE = "clave.raw";
    public static final String ALGORITMO = "DESede";
    public static final String RUTA_ARCHIVO_ENCRIPTADO = "mensaje.txt.encript";
    public static final String RUTA_ARCHIVO_DESENCRIPTADO = "mensaje_claro";


    public static void main (String [] args){


            Scanner sc = new Scanner(System.in);
            String fileHashCalculado;
            String  fileHash;
            fileHash = leerHashFichero(RUTA_ARCHIVO_HASH);
            fileHashCalculado = Hash.obtenerStringHash(Hash.obtenerHash(Hash.leerFichero(pedir(sc, PEDIR_RUTA))));

            if(comprobarHash(fileHash, fileHashCalculado)){
                String ficheroClave, algoritmo;
                ficheroClave = (CLAVE);
                algoritmo = (ALGORITMO);
                descifrar(ficheroClave, algoritmo);
            }else{
                System.out.println("Los ficheros no coinciden");
        }
    }

    private static String pedir(Scanner sc,String file){
        System.out.println(file);
        return sc.nextLine();
    }

    private static boolean comprobarHash(String hash1, String hash2){
        boolean resultado = false;
        if(Objects.equals(hash1, hash2)){
            resultado  = true;
        }
       return resultado;
    }

    public static void descifrar(String ficheroClave, String algoritmo){
        byte valorClave[] = Clave.inicializarValorClave(ficheroClave);
        Cipher cifrado = Clave.crearDescifrado(algoritmo, valorClave);
        Clave.hacerFicheroDescifrado(RUTA_ARCHIVO_ENCRIPTADO, RUTA_ARCHIVO_DESENCRIPTADO, cifrado);
    }
    private static String leerHashFichero(String nombreFichero) {
        String data = "";
        try {
            File myObj = new File(nombreFichero);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
