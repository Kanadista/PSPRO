import javax.crypto.*;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DecryptingManager {
    public void encryptFile(String algorithm, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {

        switch (algorithm){

            case "AES":

                Cipher cipher = Cipher.getInstance(algorithm);
                cipher.init(Cipher.DECRYPT_MODE, key);

                try (FileInputStream fis = new FileInputStream("juanjo_encriptado.txt");
                     FileOutputStream fos = new FileOutputStream("juanjo_encriptado" + ".desencript");
                     BufferedInputStream is = new BufferedInputStream(fis);
                     BufferedOutputStream os = new BufferedOutputStream(fos)) {
                    byte[] buff = new byte[cipher.getBlockSize()];
                    while(is.read(buff) != -1) {
                        os.write(cipher.update(buff));
                    }
                    os.write(cipher.doFinal());
                }
                /*
                inputStream.close();
                outputStream.close();
*/
                break;

            case "DESede":


                break;

            case "DES":

                break;
        }
    }
}
