package org.aadsp.controller.named;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.mail.MessagingException;
import org.aadsp.annotations.Usuario;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.utils.Email;
import org.aadsp.utils.GeradorDeSenha;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;
import org.aadsp.utils.Session;
import org.apache.commons.mail.EmailException;

/**
 * Classe principal do projeto, etapa de identificação do usuário por login e
 * senha
 *
 * @author Felipe Coelho
 * @version 24/04/2016
 */
@SessionScoped
@Named
public class Index extends ABaseNamed
{

    /**
     * Construtor base da classe com instancia de um usuário
     */
    public Index()
    {
        usuario = new Usuario();
        usuario.setLogin("");
        usuario.setSenha("");
    }

    /**
     * Metódo de busca de um usuário para a pagina xhtml
     *
     * @return retorna um usuário em branco, caso não encontrado
     */
    public Usuario getUsuario()
    {
        if (usuario == null)
        {
            usuario = new Usuario();
            usuario.setLogin("");
            usuario.setSenha("");
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    /**
     * Metódo principal de autenticação do projeto, valida os dados de login e
     * senha informados e encaminha o usuário autenticado para a página
     * principal de menu do projeto
     */
    public void autenticar() throws MessagingException, EmailException
    {
        try
        {

            Usuario copia;
            copia = usuario;
            usuario = usuario.autenticar();

            if (usuario != null && usuario.getLogin() != null && usuario.getSenha() != null)
            {
                List<String> paginasPermitidas = usuario.paginasAcesso();

                Session.setAttribute("usuario", usuario);
                Session.setAttribute("paginasAcesso", paginasPermitidas);

                Response.redirect("/web/faces/views/menu/Index.xhtml");
            } else
            {
                copia = copia.validarLogin();
                if (copia.getLogin() != null || copia.getLogin().equals(""))
                {
                    Mensageiro.mensagemInfo("Senha incorreta!!");

                } else
                {
                    Mensageiro.mensagemInfo("Não foi possível autenticar o usuário com os dados informados!");
                }
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível realizar a autenticação do usuário!");
        } catch (ExceptionInInitializerError e)
        {
            Mensageiro.mensagemFatal("Não foi possível realizar a comunicação com o banco de dados!");
        }
    }

    public void solicitarNovaSenha()
    {
        try
        {
            Usuario usuario = new Usuario();
            usuario.setEmail(emailNovaSenha);
            usuario = usuario.consultarPorEmail();
            if (usuario.getNome() != null)
            {
                String novaSenha = GeradorDeSenha.gerarCombinacaoNumerica();
                Email.enviarEmailAlteracaoSenha(usuario.getNome(), usuario.getLogin(), novaSenha, usuario.getEmail());
                usuario.setSenha(novaSenha);
                usuario.editar();
                Mensageiro.mensagemInfo("Nova senha enviada para o e-mail do usuário!!");
            } else
            {
                Mensageiro.mensagemInfo("Não foi possível localizar o usuário!!");
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível realizar o envio de uma nova senha para este e-mail, porfavor tente novamente mais tarde!!");
        }

    }

    public String getEmailNovaSenha()
    {
        return emailNovaSenha;
    }

    public void setEmailNovaSenha(String emailNovaSenha)
    {
        this.emailNovaSenha = emailNovaSenha;
    }

    private static final long serialVersionUID = 5585493974059809141L;
    private Usuario usuario;
    private String emailNovaSenha;
}
