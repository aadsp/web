
package org.aadsp.controller.named.project;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.TAP;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela TAP Cadastrar
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class TAPCadastrar extends ABaseNamed
{   
    public TAPCadastrar()
    {
        dataInicio = new Date(new Date().getTime());
        dataFim = new Date(new Date().getTime());
        this.tap = new TAP();
    }
   
    public void cadastrar()
    {
      try
      {
        tap.setDataCriacao(new java.sql.Date(new Date().getTime()));
        tap.cadastrar();
        Mensageiro.mensagemInfo("O TAP foi cadastrado com sucesso!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar o TAP!");
      }
    }
    
    public Date getDataInicio()
    {
      return dataInicio;
    }
    
    public void setDataInicio(Date date) throws ParseException
    {
       java.sql.Date dataSql = new java.sql.Date(date.getTime());
       this.tap.setDataInicio(dataSql);
    }

    public TAP getTap() {
        return tap;
    }

    public void setTap(TAP tap) {
        this.tap = tap;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date date) 
    {
       java.sql.Date dataSql = new java.sql.Date(date.getTime());
       this.tap.setDataFim(dataSql);
    }
    
    private TAP tap;
    private Date dataInicio;
    private Date dataFim;
}
