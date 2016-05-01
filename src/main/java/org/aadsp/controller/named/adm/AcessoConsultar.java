
package org.aadsp.controller.named.adm;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.association.AcessoFuncao;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Acesso Consulta
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class AcessoConsultar extends ABaseNamed
{
    
   public AcessoConsultar()
   {
       this.acessoFuncao = new AcessoFuncao();
   }
   
   public List<AcessoFuncao> getListarAcessoFuncao()
   {
       try{
       return this.acessoFuncao.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar Funções por páginas!!");
       }
       return null;
   }
   
   public void editar(AcessoFuncao acessoFuncao)
   {
       try
       {
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+acessoFuncao.getId());
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar TAP!!");
       }
   }
   
   private AcessoFuncao acessoFuncao;
    
}
