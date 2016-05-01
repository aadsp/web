
package org.aadsp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;


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
    
    public static String codificarParaBase64(String texto)
    {
        return new Base64().encodeToString(texto.getBytes());
    }
    
    public static String decodificarBase64(String texto)
    {
        return new String(new Base64().decode(texto));
    }
}
