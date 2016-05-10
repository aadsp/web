
package org.aadsp.utils;

import org.aadsp.utils.settings.DadosEmail;
import javax.mail.MessagingException;
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
    
    public static void enviarEmailSimples(String mensagem) throws MessagingException, EmailException
    {
        SimpleEmail email = new SimpleEmail();
        email.setDebug(true);
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(DadosEmail.email, DadosEmail.senha));
        email.setTLS(true);
        email.addTo("aadsp.labrasoft@gmail.com", "AADSP"); //destinatário
        email.setFrom("aadsp.labrasoft@gmail.com", "AADSP - Simples"); // remetente
        email.setSubject("AADSP - Simples"); // assunto do e-mail
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
        email.send(); //envia o e-mail
    }
    
    /**
     * Metódo para envio de email de erro no sistema, deverá somente ser utilizado na mensagem de erro
     * @param nomeUsuario nome usuário que estava realizando o acesso indevido, usuário em sessão
     * @param loginUsuario login usuário que estava realizando o acesso indevido, usuário em sessão
     * @param emailUsuario email usuário que estava realizando o acesso indevido, usuário em sessão
     * @param mensagem mensagem de email proveniente do erro
     * @param pilha pilha do erro gerado
     */
    public static void enviarEmailErro(String nomeUsuario, 
                                       String loginUsuario, String emailUsuario,
                                       String mensagem, String pilha) throws MessagingException, EmailException
    {
        try
        {
            HtmlEmail email = new HtmlEmail();
            //email.setDebug(true);
            email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(DadosEmail.email, DadosEmail.senha));
            email.setTLS(true);
            email.addTo("aadsp.labrasoft@gmail.com", "AADSP"); //destinatário
            email.setFrom("aadsp.labrasoft@gmail.com", "AADSP - ERRO"); // remetente
            email.setSubject("AADSP - ERRO "); // assunto do e-mail
            email.setHtmlMsg(TemplateEmail.erro(nomeUsuario, loginUsuario, emailUsuario, mensagem, pilha));
            email.send(); //envia o e-mail
        }
        catch(EmailException e)
        {
            Mensageiro.mensagemError("Erro ao executar operação de envio de email:" +e.getMessage());
        }
    }
    
    /**
     * Metódo para envio de email de acesso indevido ao sistema
     * @param pagina página que foi acessada indevidamente
     * @param nomeUsuario nome usuário que estava realizando o acesso indevido, usuário em sessão
     * @param loginUsuario login usuário que estava realizando o acesso indevido, usuário em sessão
     * @param emailUsuario email usuário que estava realizando o acesso indevido, usuário em sessão
     */
    public static void enviarEmailAcessoIndevido(String pagina,String nomeUsuario, String loginUsuario, String emailUsuario)
    {
        try
        {
            HtmlEmail email = new HtmlEmail();
            //email.setDebug(true);
            email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(DadosEmail.email, DadosEmail.senha));
            email.setTLS(true);
            email.addTo("aadsp.labrasoft@gmail.com", "AADSP"); //destinatário
            email.setFrom("aadsp.labrasoft@gmail.com", "AADSP - ACESSO"); // remetente
            email.setSubject("AADSP - ACESSO INDEVIDO"); // assunto do e-mail
            email.setHtmlMsg(TemplateEmail.acessoIndevido(nomeUsuario, loginUsuario, emailUsuario, pagina));
            email.send(); //envia o e-mail
        }
        catch(EmailException e)
        {
            Mensageiro.mensagemError("Erro ao executar operação de envio de email:" +e.getMessage());
        }
    }
}
