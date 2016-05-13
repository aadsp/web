
package org.aadsp.controller.named.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Session;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class AlterarSenha extends ABaseNamed implements ICadastro
{   
    public void alterar()
    {
      try
      {
        if(senha.equals(RepetirSenha))
        {
           Usuario usuario = (Usuario) Session.getAttribute("usuario");
           usuario.setSenha(senha);
           usuario.editar();
           Mensageiro.mensagemInfo("Senha alterada com sucesso");
        }
        else
        {
            Mensageiro.mensagemWarn("Você não repetiu a senha como solicitado!");
        }
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível alterar a senha!");
      }
    }
    
    public boolean controleDeCadastro()
    {
        return this.senha != null;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepetirSenha() {
        return RepetirSenha;
    }

    public void setRepetirSenha(String RepetirSenha) {
        this.RepetirSenha = RepetirSenha;
    }
    
    private String senha;
    private String RepetirSenha;
}
