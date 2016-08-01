package controller.index;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.mail.MessagingException;
import annotations.acesso.Usuario;
import interfaces.ABaseNamed;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import utils.Email;
import utils.GeradorDeSenha;
import utils.Mensageiro;
import utils.Response;
import utils.Session;
import org.apache.commons.mail.EmailException;
import utils.Criptografia;

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
        try
        {
            usuario = new Usuario();
            usuario.setLogin("");
            usuario.setSenha("");
            this.senha = new String();
            this.senha = "";
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Ocorreu um erro ao iniciar!!");
        }
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        try
        {
            this.senha = senha;
            this.usuario.setSenha(Criptografia.codificarParaSSH(senha));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            Mensageiro.mensagemInfo("Não foi possível aplicar codificação em senha!");
        }

    }

    /**
     * Metódo de busca de um usuário para a pagina xhtml
     *
     * @return retorna um usuário em branco, caso não encontrado
     */
    public Usuario getUsuario()
    {
        try
        {
            if (usuario == null)
            {
                usuario = new Usuario();
                usuario.setLogin("");
                usuario.setSenha("");
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Ocorreu um erro ao iniciar!!");
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
                usuario.setSenha(Criptografia.codificarParaSSH(novaSenha));
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

    private String senha;
    private static final long serialVersionUID = 5585493974059809141L;
    private Usuario usuario;
    private String emailNovaSenha;
}
