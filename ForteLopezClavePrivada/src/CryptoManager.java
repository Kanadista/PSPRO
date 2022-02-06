import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class CryptoManager {


    public static void showMenu() throws InvalidKeySpecException, NoSuchAlgorithmException {
        CustomKeyGenerator keyGenerator = new CustomKeyGenerator();
        keyGenerator.generateKey();
    }
}
