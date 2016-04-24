
package org.aadsp.interfaces;

import java.util.List;
import org.aadsp.annotations.Usuario;


public interface IUsuario 
{ 
   public String getLogin();
   public String getSenha();
   public String getNome();
   public void setLogin(String senha);
   public void setSenha(String senha);
   
   public Usuario autenticar();
   public Usuario validarLogin();
   public List<String> paginasAcesso()throws Exception;
   public String consultarFunacao() throws  Exception;
   
}
