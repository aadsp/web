
package org.aadsp.controller.named.project;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class StakeholderCadastrar extends ABaseNamed
{
    
    public StakeholderCadastrar()
    {
        this.stakeholder = new Stakeholder();
    }
   
    public void cadastrar()
    {
      try
      {
        stakeholder.cadastrar();
        Mensageiro.mensagemInfo("Stakeholder cadastrado com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar o staeholder!");
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
