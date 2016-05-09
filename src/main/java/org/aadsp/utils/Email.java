
package org.aadsp.utils;

import javax.mail.MessagingException;
import org.aadsp.annotations.Usuario;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**Classe para envio de email
 *
 * @author Felipe
 * @version 24/04/2016
 */
public class Email
{
    public static void enviarEmail(String mensagem)
    {
        
    }
    
    public static void enviarEmailErro(String mensagem) throws MessagingException, EmailException
    {
        SimpleEmail email = new SimpleEmail();
        email.setDebug(true);
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(DadosEmail.email, DadosEmail.senha));
        email.setTLS(true);
        email.addTo("aadsp.labrasoft@gmail.com", "AADSP"); //destinatário
        email.setFrom("aadsp.labrasoft@gmail.com", "AADSP - ERRO"); // remetente
        email.setSubject("AADSP - ERRO"); // assunto do e-mail
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
        email.send(); //envia o e-mail
    }
    
    public static void enviarEmailAcessoIndevido(String pagina,String nomeUsuario, String loginUsuario, String emailUsuario)
    {
        try{
        HtmlEmail email = new HtmlEmail();
        email.setDebug(true);
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(DadosEmail.email, DadosEmail.senha));
        email.setTLS(true);
        email.addTo("aadsp.labrasoft@gmail.com", "AADSP"); //destinatário
        email.setFrom("aadsp.labrasoft@gmail.com", "AADSP - ACESSO"); // remetente
        email.setSubject("AADSP - ACESSO INDEVIDO"); // assunto do e-mail
        email.setHtmlMsg("<html> "
                + "<table>"
                + "<tr><td><strong>Usuário:</strong></td><td>"+nomeUsuario+"</td></tr>"
                + "<tr><td><strong>Login:</strong></td><td>"+loginUsuario+"</td></tr>"
                + "<tr><td><strong>E-mail:</strong></td><td>"+emailUsuario+"</td></tr>"
                + "<tr><td><strong>Página:</strong></td><td>"+pagina+"</td></tr>"
                + "</table> "
                + "</html>");
        email.send(); //envia o e-mail
        }
        catch(EmailException e)
        {
            Mensageiro.mensagemError("Erro ao executar operação de envio de email:" +e.getMessage());
        }
    }
}
