
package org.aadsp.controller.named.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Session;
import org.apache.commons.mail.EmailException;

/**
 * 
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class PaginaCadastrar extends ABaseNamed
{
    
    public PaginaCadastrar()
    {
        this.pagina = new Pagina();
    }
    
    public boolean controleDeCadastro()
    {
        return this.pagina.getNome() != null;
    }
    
    public void cadastrar() throws MessagingException, EmailException
    {
      try
      {
        pagina.cadastrar();
        Mensageiro.mensagemInfo("Página cadastrada com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar a página!",(Usuario)Session.getAttribute("usuario"),e);
      }
    }
  
    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }
    private Pagina pagina;
}
