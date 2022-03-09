
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.*;


public class CustomKeyGenerator {
    public void generateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Scanner answer = new Scanner(System.in);
        final String RAND_NUM_GENERATOR_ALGORITHM = "SHA1PRNG";
        SecureRandom srand = SecureRandom.getInstance(RAND_NUM_GENERATOR_ALGORITHM);
        SecretKey key;
        SecretKeyFactory keySpecFactory;
        byte[] keyBytes;
        KeyGenerator keyGen;
        String file_name = "";
        int chosen_algorithm;
        String algorithm = "";

        //TODO optimize switch method and modularize key generating method for future uses

        System.out.println("Elige el nombre que tendrá el fichero que contendrá la clave:  (Sin extensión)");
        file_name = answer.next();
        file_name = new StringBuilder().append(file_name).append(".raw").toString();

        System.out.println("Elige el algoritmo a usar: || 1. AES  || 2. DES || 3. DESede ");
        chosen_algorithm = answer.nextInt();

        switch (chosen_algorithm){
            case 1: algorithm = "AES";
            break;
            case 2: algorithm = "DES";
            break;
            case 3: algorithm = "DESede";
            break;
        }

        writeKey(algorithm, file_name);
    }

    private void writeKey(String algorithm, String file_name) throws NoSuchAlgorithmException, InvalidKeySpecException {
        final String RAND_NUM_GENERATOR_ALGORITHM = "SHA1PRNG";
        SecureRandom srand = SecureRandom.getInstance(RAND_NUM_GENERATOR_ALGORITHM);
        SecretKey key;
        SecretKeyFactory keySpecFactory;
        KeyGenerator keyGen;
        byte[] keyBytes;

        switch(algorithm){
            case "AES":
                keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(srand);
                key = keyGen.generateKey();
                byte[] raw = key.getEncoded();

                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

                try(FileOutputStream fos = new FileOutputStream(file_name)) {
                    fos.write(skeySpec.getEncoded());
                } catch (IOException e) {
                    System.out.println("Error de E/S escribiendo clave en fichero");
                    e.printStackTrace();
                }
                break;

            case "DESede":
                keyGen = KeyGenerator.getInstance("DESede");
                keyGen.init(srand);
                key = keyGen.generateKey();

                keySpecFactory = SecretKeyFactory.getInstance("DESede");
                DESedeKeySpec DESedkeySpec = (DESedeKeySpec) keySpecFactory.getKeySpec(key, DESedeKeySpec.class);
                keyBytes =  DESedkeySpec.getKey();

                try(FileOutputStream fos = new FileOutputStream(file_name)) {
                    fos.write(keyBytes);
                } catch (IOException e) {
                    System.out.println("Error de E/S escribiendo clave en fichero");
                    e.printStackTrace();
                }
                break;

            case "DES":
                keyGen = KeyGenerator.getInstance("DES");
                keyGen.init(srand);
                key = keyGen.generateKey();

                keySpecFactory = SecretKeyFactory.getInstance("DES");
                DESKeySpec DESKeySpec = (DESKeySpec) keySpecFactory.getKeySpec(key, DESKeySpec.class);
                keyBytes =  DESKeySpec.getKey();

                try(FileOutputStream fos = new FileOutputStream(file_name)) {
                    fos.write(keyBytes);
                } catch (IOException e) {
                    System.out.println("Error de E/S escribiendo clave en fichero");
                    e.printStackTrace();
                }
                break;
        }
    }

    private IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
