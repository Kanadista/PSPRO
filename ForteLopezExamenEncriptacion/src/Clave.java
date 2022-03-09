import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Clave {

    public static byte[] inicializarValorClave(String nombreFichero) {
        byte[] valorClave = null;

        try (FileInputStream fisClave = new FileInputStream(nombreFichero)) {
            try {
                valorClave = fisClave.readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valorClave;
    }

    public static Cipher crearDescifrado(String algoritmo, byte[] valorClave) {
        SecretKeySpec keySpec = new SecretKeySpec(valorClave, algoritmo);
        SecretKey clave;
        Cipher cifrado = null;

        try {
            clave = new SecretKeySpec(keySpec.getEncoded(), algoritmo);
            cifrado = Cipher.getInstance(algoritmo);
            cifrado.init(Cipher.DECRYPT_MODE, clave);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return cifrado;
    }

    public static void hacerFicheroDescifrado(String inputFichero, String outputFichero, Cipher cifrado){
        File fi = new File(inputFichero), fo = new File(outputFichero + ".txt");

        try (FileInputStream fis = new FileInputStream(fi);
             FileOutputStream fos = new FileOutputStream(fo);
             BufferedInputStream is = new BufferedInputStream(fis);
             BufferedOutputStream os = new BufferedOutputStream(fos)) {
            byte[] buff = new byte[cifrado.getBlockSize()];
            while(is.read(buff) != -1) {
                os.write(cifrado.update(buff));
            }
            os.write(cifrado.doFinal());
        } catch (IOException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }

}
