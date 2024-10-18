package Utils;


import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.MessageDigest;

public class Encrypt {


    public static String decryptText(String encryptedText, String masterKey) throws NoSuchAlgorithmException {
        return new String(xor(Base64.getDecoder().decode(encryptedText), sha1(masterKey)));
    }
    public static String encryptText(String text, String masterKey) throws NoSuchAlgorithmException {
        return Base64.getEncoder().encodeToString(xor(text.getBytes(), sha1(masterKey)));
    }

    private static byte[] xor(byte[] data, byte[] key) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ key[i % key.length]);
        }
        return result;
    }

    private static byte[] sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return md.digest(input.getBytes());
    }   

}
