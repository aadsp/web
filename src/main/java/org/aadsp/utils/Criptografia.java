
package org.aadsp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Felipe
 */
public class Criptografia 
{
    public static String codificarParaSSH(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256"); 
        byte messageDigest[] = algorithm.digest(texto.getBytes("UTF-8"));
        
        StringBuilder hexString = new StringBuilder();
        
        for (byte b : messageDigest)
        {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        
        return hexString.toString();
    }
}
