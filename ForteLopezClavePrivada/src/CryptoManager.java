import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class CryptoManager {


    public static void showMenu() throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeyException {
      /* CustomKeyGenerator keyGenerator = new CustomKeyGenerator();
        keyGenerator.generateKey();

        File inputFile = new File("juanjo.txt");
        File outputFile = new File("juanjo_encriptado.txt");

        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivspec = new IvParameterSpec(iv);


        byte[] valorClave;

        try (FileInputStream fisClave = new FileInputStream("prueba.raw")) {
            valorClave = fisClave.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: no existe fichero de clave %s\n.", "NOM_FICH_CLAVE");
            return;
        } catch (IOException e) {
            System.out.printf("ERROR: de E/S leyendo clave de fichero %s\n.", "NOM_FICH_CLAVE");
            return;
        }

        SecretKeySpec keySpec = new SecretKeySpec(valorClave, "AES");
        SecretKey clave = new SecretKeySpec(keySpec.getEncoded(), "AES");

        EncryptingManager encryptingManager = new EncryptingManager();
        try {
            encryptingManager.encryptFile("AES", clave, inputFile, outputFile );
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        */

        byte valorClave[];

        try (FileInputStream fisClave = new FileInputStream("prueba.raw")) {
            valorClave = fisClave.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: no existe fichero de clave %s\n.", "NOM_FICH_CLAVE");
            return;
        } catch (IOException e) {
            System.out.printf("ERROR: de E/S leyendo clave de fichero %s\n.", "NOM_FICH_CLAVE");
            return;
        }


        SecretKeySpec keySpec = new SecretKeySpec(valorClave, "AES");
        // SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("AES");
        SecretKey clave = new SecretKeySpec(keySpec.getEncoded(), "AES");

        DecryptingManager decryptingManager = new DecryptingManager();
        decryptingManager.encryptFile("AES", clave);

    }

}
