package Day05;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Jeremy on 12/8/2016.
 */

public class Day05 {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = "reyedfim";


        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(input.getBytes(), 0, input.length());
        System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));

    }

}
