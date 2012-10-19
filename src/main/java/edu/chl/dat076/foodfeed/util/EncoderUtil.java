/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 *
 * @author max
 */
public class EncoderUtil {
    
    private static StandardPasswordEncoder encoder = new StandardPasswordEncoder();
    
    public static String encode(String input){
        return encoder.encode(input);
    }
}
