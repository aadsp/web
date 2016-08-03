package controller.index;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import business.index.BIndex;
import interfaces.ABaseNamed;
import interfaces.IUsuario;
import utils.Mensageiro;
import utils.Response;
import utils.Session;

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
    public Index()
    {
        try
        {
            bIndex = new BIndex();
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Ocorreu um erro ao iniciar!!");
        }
    }
    
    public void autenticar()
    {
        try
        {
            usuario = bIndex.autenticar(login, senha);

            if (usuario != null && usuario.getLogin() != null && usuario.getSenha() != null)
            {
                List<String> paginasPermitidas = usuario.paginasAcesso();

                Session.setAttribute("usuario", usuario);
                Session.setAttribute("paginasAcesso", paginasPermitidas);

                Response.redirect("/web/faces/views/menu/Index.xhtml");
            } else
            {
                Mensageiro.mensagemInfo("Não foi possível realizar a autenticação do usuário!");
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
           bIndex.solicitarNovaSenha(emailNovaSenha);

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

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }
    
    private String senha;
    private String login;
    private IUsuario usuario;
    private BIndex bIndex;
    private String emailNovaSenha;
    private static final long serialVersionUID = 5585493974059809141L;

}
