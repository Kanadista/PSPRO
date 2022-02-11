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
import java.util.Scanner;

public class CryptoManager {


    public static void showMenu() throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeyException {
        Scanner answer = new Scanner(System.in);
        byte[] valorClave;
        int operationAnswer;
        String inputFileName = "";
        String outputFileName = "";
        String keyFileName = "";
        int chosen_algorithm;
        String algorithm = "";
        SecretKeySpec keySpec;
        File inputFile;
        File outputFile;
        SecretKey clave;
        System.out.println("Elige la operación que deseas realizar: 1.- Generar clave || 2.- Encriptar archivo || 3.- Desencriptar archivo ");
        operationAnswer = answer.nextInt();

        switch (operationAnswer){
            case 1:

                CustomKeyGenerator keyGenerator = new CustomKeyGenerator();
                keyGenerator.generateKey();
                break;

            case 2:
                answer.nextLine();

                System.out.println("Introduce el nombre del archivo a encriptar (con extensión): ");
                inputFileName = answer.nextLine();
                System.out.println("Introduce el nombre del archivo resultante de la encriptación (sin extensión): ");
                outputFileName = answer.nextLine();
                outputFileName = new StringBuilder().append(outputFileName).append(".txt").toString();
                System.out.println("Introduce el nombre de la clave a usar para encriptar (sin extensión): ");
                keyFileName = answer.nextLine();
                keyFileName = new StringBuilder().append(keyFileName).append(".raw").toString();


                System.out.println("Elige el algoritmo usado en la generacion de la clave: || 1. AES  || 2. DES || 3. DESede ");
                chosen_algorithm = answer.nextInt();

                switch (chosen_algorithm){
                    case 1: algorithm = "AES";
                        break;
                    case 2: algorithm = "DES";
                        break;
                    case 3: algorithm = "DESede";
                        break;
                }

                inputFile = new File(inputFileName);

                outputFile = new File(outputFileName);

                byte[] iv = new byte[16];
                new SecureRandom().nextBytes(iv);
                IvParameterSpec ivspec = new IvParameterSpec(iv);


                try (FileInputStream fisClave = new FileInputStream(keyFileName)) {
                    valorClave = fisClave.readAllBytes();
                } catch (FileNotFoundException e) {
                    System.out.printf("ERROR: no existe fichero de clave %s\n.", "NOM_FICH_CLAVE");
                    return;
                } catch (IOException e) {
                    System.out.printf("ERROR: de E/S leyendo clave de fichero %s\n.", "NOM_FICH_CLAVE");
                    return;
                }

                keySpec = new SecretKeySpec(valorClave, algorithm);
                clave = new SecretKeySpec(keySpec.getEncoded(), algorithm);

                EncryptingManager encryptingManager = new EncryptingManager();
                try {
                    encryptingManager.encryptFile(algorithm, clave, inputFile, outputFile );
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
                break;

            case 3:
                answer.nextLine();

                System.out.println("Introduce el nombre del archivo encriptado (con extensión): ");
                inputFileName = answer.nextLine();
                System.out.println("Introduce el nombre del archivo resultante de la desencriptación (sin extensión): ");
                outputFileName = answer.nextLine();
                outputFileName = new StringBuilder().append(outputFileName).append(".decript").toString();
                System.out.println("Introduce el nombre de la clave a usar para encriptar (sin extensión): ");
                keyFileName = answer.nextLine();
                keyFileName = new StringBuilder().append(keyFileName).append(".raw").toString();


                System.out.println("Elige el algoritmo usado en la generacion de la clave: || 1. AES  || 2. DES || 3. DESede ");
                chosen_algorithm = answer.nextInt();

                switch (chosen_algorithm){
                    case 1: algorithm = "AES";
                        break;
                    case 2: algorithm = "DES";
                        break;
                    case 3: algorithm = "DESede";
                        break;
                }

                inputFile = new File(inputFileName);

                outputFile = new File(outputFileName);

                try (FileInputStream fisClave = new FileInputStream(keyFileName)) {
                    valorClave = fisClave.readAllBytes();
                } catch (FileNotFoundException e) {
                    System.out.printf("ERROR: no existe fichero de clave %s\n.", "NOM_FICH_CLAVE");
                    return;
                } catch (IOException e) {
                    System.out.printf("ERROR: de E/S leyendo clave de fichero %s\n.", "NOM_FICH_CLAVE");
                    return;
                }


                 keySpec = new SecretKeySpec(valorClave, algorithm);
                 clave = new SecretKeySpec(keySpec.getEncoded(), algorithm);

                DecryptingManager decryptingManager = new DecryptingManager();
                decryptingManager.encryptFile(algorithm, clave, inputFile, outputFile);

                break;
        }
    }
}
