package edu.chl.dat076.foodfeed.util;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/*
 * Help class for encoding password
 */
public class EncoderUtil {

    private static StandardPasswordEncoder encoder = new StandardPasswordEncoder();

    public static String encode(String input) {
        return encoder.encode(input);
    }

    public static boolean matches(String raw, String encoded) {
        return encoder.matches(raw, encoded);
    }
}
