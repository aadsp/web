
package org.aadsp.controller.named.project;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  02/05/2016
 */
@ViewScoped
@Named
public class StakeholderConsultar extends ABaseNamed
{
    
   public StakeholderConsultar()
   {
       this.stakeholder = new Stakeholder();
   }
   
   public List<Stakeholder> getListarStakeholders()
   {
       try{
       return this.stakeholder.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar stakeholders cadastrados!!");
       }
       return null;
   }
   
   public void editar(Stakeholder stakeholder)
   {
       try
       {
        Response.redirect("/web/faces/views/projetos/StakeholderEditar.xhtml?Stakeholder="+ Criptografia.codificarParaBase64(stakeholder.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar Página!!");
       }
   }
   
   private Stakeholder stakeholder;
    
}
