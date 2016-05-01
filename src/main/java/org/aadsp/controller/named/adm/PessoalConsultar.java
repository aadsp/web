
package org.aadsp.controller.named.adm;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  24/04/2016
 */
@ViewScoped
@Named
public class PessoalConsultar extends ABaseNamed
{
    
   public PessoalConsultar()
   {
       this.usuario = new Usuario();
   }
   
   public List<Usuario> getListarUsuarios()
   {
       try{
       return this.usuario.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar usuário!!");
       }
       return null;
   }
   
   public void editar(Usuario usuario)
   {
       try
       {
        Response.redirect("/web/faces/views/adm/PessoalEditar.xhtml?Pessoal="+ Criptografia.codificarParaBase64(usuario.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar usuário!!");
       }
   }
   
   private IUsuario usuario;
    
}
