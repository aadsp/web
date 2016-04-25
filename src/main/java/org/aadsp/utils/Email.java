
package org.aadsp.utils;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**Classe para envio de email
 *
 * @author Felipe
 * @version 24/04/2016
 */
public class Email
{
    public static void enviarEmailErro(String mensagem)
    {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.port", "465"); 
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.socketFactory.port", "465"); 
        props.put("mail.smtp.socketFactory.fallback", "false"); 
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
             protected PasswordAuthentication getPasswordAuthentication() 
             {
                   return new PasswordAuthentication("aadsp.labrasoft@gmail.com", "7895312945");
             }
        }); 
        
        /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("aadsp.labrasoft@gmail.com")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse("aadsp.labrasoft@gmail.com");  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("ERRO AADSP");//Assunto
                  message.setText(mensagem);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }
    
}
