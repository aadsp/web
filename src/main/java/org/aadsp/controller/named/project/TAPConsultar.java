
package org.aadsp.controller.named.project;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.TAP;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  24/04/2016
 */
@ViewScoped
@Named
public class TAPConsultar extends ABaseNamed
{
    
   public TAPConsultar()
   {
       this.tap = new TAP();
   }
   
   public List<TAP> getListarTAPs()
   {
       try{
       return this.tap.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar os termos de abertura de projetos!!");
       }
       return null;
   }
   
   public void editar(TAP tap)
   {
   
   }
   
   private TAP tap;
    
}
