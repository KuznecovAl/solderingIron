package internet_shop.auth;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {

    public static String encode(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(pwd.getBytes());

            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
