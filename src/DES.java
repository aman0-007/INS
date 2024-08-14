import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DES {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator mygenerator = KeyGenerator.getInstance("DES");
        SecretKey myDesKey = mygenerator.generateKey();

        Cipher desCipher = Cipher.getInstance("DES");

        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

        byte[] myBytes = "My name is Aman".getBytes();

        byte[] myEncryptedBytes = desCipher.doFinal(myBytes);

        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] myDecryptedBytes = desCipher.doFinal(myEncryptedBytes);

        System.out.println("Encrypted Text : "+ myEncryptedBytes);
        System.out.println("Decrypted Text : "+ myDecryptedBytes);
    }
}
