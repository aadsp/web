
package org.aadsp.controller.named.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Pagina;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
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
   
    public void cadastrar()
    {
      try
      {
        pagina.cadastrar();
        Mensageiro.mensagemInfo("Página cadastrada com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar a página!");
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
