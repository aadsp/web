
package org.aadsp.controller.named.contributors;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Empresa;
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
public class EmpresaConsultar extends ABaseNamed
{
    
   public EmpresaConsultar()
   {
       this.empresa = new Empresa();
   }
   
   public List<Empresa> getListarEmpresas()
   {
       try{
       return this.empresa.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar empresas cadastradas!!");
       }
       return null;
   }
   
   public void editar(Empresa empresa)
   {
       try
       {
        Response.redirect("/web/faces/views/colaboradores/EmpresaEditar.xhtml?empresa="+ Criptografia.codificarParaBase64(empresa.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar empresa!!");
       }
   }
   
   private Empresa empresa;
    
}
