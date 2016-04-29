
package org.aadsp.controller.named.adm;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Mensageiro;

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
   
   }
   
   private IUsuario usuario;
    
}
