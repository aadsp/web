
package org.aadsp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;


/**
 * Classe para criptografia de dados
 * @author Felipe
 */
public class Criptografia 
{
    /**
     * Metódo de criptografia de dados em SHA-256, UTF 8, este tipo de senha não poderá ser revertida, utilizada em senha de usuário
     * @param texto deverá ser informado o texto a ser criptografado
     * @return é retornao uma string do texto enviado em criptografia SHA-256
     */
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
    
    /**
     * Metódo para criptografia de dados em base 64, utilizada para envio de paramentros via URL no sistema
     * @param texto é informado um texto não criptografado
     * @return  é retornado o texto informado em criptografia de base 64
     */
    public static String codificarParaBase64(String texto)
    {
        return new Base64().encodeToString(texto.getBytes());
    }
    
    /**
     * Metódo para descriptografar dados em base 64, utilizada para recebimento de paramentros via URL no sistema
     * @param texto é informado um texto criptografado em base 64
     * @return  é retornado o texto informado descriptografado 
     */
    public static String decodificarBase64(String texto)
    {
        return new String(new Base64().decode(texto));
    }
}
