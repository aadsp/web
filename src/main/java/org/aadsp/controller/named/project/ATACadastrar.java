
package org.aadsp.controller.named.project;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.ReuniaoAta;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
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
public class ATACadastrar extends ABaseNamed implements ICadastro 
{
    
    public ATACadastrar()
    {
        this.reuniaoAta = new ReuniaoAta();
    }
    
    @Override
    public boolean controleDeCadastro()
    {
        return this.reuniaoAta.getInformacoesIniciais() != null;
    }
    
    public void cadastrar() throws MessagingException, EmailException
    {
      try
      {
        reuniaoAta.cadastrar();
        Mensageiro.mensagemInfo("ATA cadastrada com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar a ATA!",(Usuario)Session.getAttribute("usuario"),e);
      }
    }
  
    public ReuniaoAta getPagina() {
        return reuniaoAta;
    }

    public void setPagina(ReuniaoAta reuniaoAta){
        this.reuniaoAta = reuniaoAta;
    }
    private ReuniaoAta reuniaoAta;
}
