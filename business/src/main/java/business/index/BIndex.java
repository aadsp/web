package business.index;

import annotations.acesso.Usuario;
import interfaces.IUsuario;
import javax.mail.MessagingException;
import org.apache.commons.mail.EmailException;
import utils.Criptografia;
import utils.Email;
import utils.GeradorDeSenha;

public class BIndex
{
    public IUsuario autenticar(String login, String senha) throws MessagingException, EmailException, Exception
    {
        Usuario copia;
        this.usuario = new Usuario();
        this.usuario.setLogin(login);
        this.usuario.setSenha(Criptografia.codificarParaSSH(senha));
        copia = usuario;
        usuario = usuario.autenticar();

        if (usuario != null && usuario.getLogin() != null && usuario.getSenha() != null)
            return usuario;
        return null;
    }
    
    public void solicitarNovaSenha(String emailNovaSenha) throws Exception
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
            }
            else  
                throw  new Exception();
    }

    private Usuario usuario;
}
