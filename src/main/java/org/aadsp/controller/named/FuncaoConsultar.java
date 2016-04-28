
package org.aadsp.controller.named;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Funcao;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class FuncaoConsultar extends ABaseNamed
{
    
   public FuncaoConsultar()
   {
       this.funcao = new Funcao();
   }
   
   public List<Funcao> getListarFuncoes()
   {
       try{
       return this.funcao.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar Funções!!");
       }
       return null;
   }
   
   public void editar(Funcao funcao)
   {
   
   }
   
   private Funcao funcao;
    
}
