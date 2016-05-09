
package org.aadsp.controller.named.contributors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Edição
 * @author Felipe Coelho
 * @version  01/05/2016
 */
@ViewScoped
@Named
public class StakeholderEditar extends ABaseNamed
{
    
    public StakeholderEditar()
    {
        this.stakeholder = new Stakeholder();
        carregarDadosIniciais();
    }
   
    private void carregarDadosIniciais()
    {
        try
        {
            int IDStakeholder = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Stakeholder")));
            this.stakeholder.setID(IDStakeholder);
            this.stakeholder = stakeholder.consultarPorID();
        }catch(Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }
    
    public void excluir()
    {
      try
      {
        stakeholder.excluir();
        Response.redirect("/web/faces/views/colaboradores/StakeholderConsultar.xhtml");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível excluir os dados deste stakeholder!");
      }
    }
    
    public void editar()
    {
      try
      {
        stakeholder.editar();
        Mensageiro.mensagemInfo("Dados do Stakeholder atualizado com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível atualizar os dados do Stakeholder!");
      }
    }

    public Stakeholder getStakeholder() {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder) {
        this.stakeholder = stakeholder;
    }
  
    
    private Stakeholder stakeholder;
}
