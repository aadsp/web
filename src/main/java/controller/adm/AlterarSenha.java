package controller.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.acesso.Usuario;
import interfaces.ABaseNamed;
import interfaces.ICadastro;
import utils.Mensageiro;
import utils.Session;

/**
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class AlterarSenha extends ABaseNamed implements ICadastro
{

    public void alterar()
    {
        try
        {
            if (senha.equals(RepetirSenha))
            {
                Usuario usuario = (Usuario) Session.getAttribute("usuario");
                usuario.setSenha(senha);
                usuario.editar();
                Mensageiro.mensagemInfo("Senha alterada com sucesso");
            } else
            {
                Mensageiro.mensagemWarn("Você não repetiu a senha como solicitado!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível alterar a senha!");
        }
    }

    public boolean controleDeCadastro()
    {
        return this.senha != null;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getRepetirSenha()
    {
        return RepetirSenha;
    }

    public void setRepetirSenha(String RepetirSenha)
    {
        this.RepetirSenha = RepetirSenha;
    }

    private String senha;
    private String RepetirSenha;
}
