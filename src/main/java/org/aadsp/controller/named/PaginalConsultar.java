
package org.aadsp.controller.named;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  24/04/2016
 */
@ViewScoped
@Named
public class PaginalConsultar extends ABaseBean
{
    
   public PaginalConsultar()
   {
       this.pagina = new Pagina();
   }
   
   public List<Pagina> getListarPaginas()
   {
       try{
       return this.pagina.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar páginas!!");
       }
       return null;
   }
   
   public void editar(Pagina pagina)
   {
   
   }
   
   private Pagina pagina;
    
}
