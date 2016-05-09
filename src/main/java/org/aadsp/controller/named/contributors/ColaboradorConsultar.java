
package org.aadsp.controller.named.contributors;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Colaborador;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Colaborador Consulta
 * @author Felipe Coelho
 * @version  08/05/2016
 */
@ViewScoped
@Named
public class ColaboradorConsultar extends ABaseNamed
{
    
   public ColaboradorConsultar()
   {
       this.colaborador = new Colaborador();
   }
   
   public List<Colaborador> getListarColaboradores()
   {
       try{
       return this.colaborador.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar colaboradores cadastrados!!");
       }
       return null;
   }
   
   public void editar(Colaborador colaborador)
   {
       try
       {
        Response.redirect("/web/faces/views/colaboradores/ColaboradorEditar.xhtml?empresa="+ Criptografia.codificarParaBase64(colaborador.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar colaborador!!");
       }
   }
   
   private Colaborador colaborador;
    
}
