package razdwatrzy.zzpj.crypto;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Byte48Cipher implements ICipher {
    static int cipherLength = 32;   //32+16 bytes after aes

    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ?/.,";
    byte[] key = "1234567812345678".getBytes();


    @Override
    public byte[] encode(long i) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        String s = Long.toString(i);

        Random random = new Random();
        for (int j = s.length(); j < cipherLength; j++) {
            int position = random.nextInt(s.length() + 1);
            char c = alphabet.charAt(random.nextInt(alphabet.length()));

            s = s.substring(0, position) + c + s.substring(position);
        }
        byte[] encrypted = cipher.doFinal(s.getBytes());
        return encrypted;
    }

    @Override
    public long decode(byte[] s) throws Exception {

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decoded = cipher.doFinal(s);



        String s1 = new String(decoded).replaceAll("[^0-9]", "");
        return Integer.parseInt(s1);
    }
}
