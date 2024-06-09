package SaveSystem;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileSaveSystem {
    private final static String PATH = "data.enc";
    private final static String key = "secretKey1234567";
    private static Cipher cipher;
    private static SecretKey secretKey;

    static {
        try {
            secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchPaddingException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void saveData(String data) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            try (FileOutputStream fileOut = new FileOutputStream(PATH);
                 CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher)) {
                cipherOut.write(data.getBytes());
            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String loadData() {
        StringBuilder result = new StringBuilder();
        try (FileInputStream fileIn = new FileInputStream(PATH)) {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            try (
                    CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
                    InputStreamReader inputReader = new InputStreamReader(cipherIn);
                    BufferedReader reader = new BufferedReader(inputReader)
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (InvalidKeyException e) {
            System.out.println(e.getMessage());
        }
        return result.toString();
    }
}
