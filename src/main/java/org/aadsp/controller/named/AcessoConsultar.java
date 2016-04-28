
package org.aadsp.controller.named;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.association.AcessoFuncao;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Mensageiro;

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
   
   }
   
   private AcessoFuncao acessoFuncao;
    
}
