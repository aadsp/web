
package org.aadsp.controller.named.project;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.TAP;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela TAP Cadastrar
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class TAPEditar extends ABaseNamed
{   
    public TAPEditar()
    {
        dataInicio = new Date(new Date().getTime());
        dataFim = new Date(new Date().getTime());
        this.tap = new TAP();
        carregarDadosIniciais();        
    }
    
    private void carregarDadosIniciais()
    {
       try{
        int TAPID = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("TAP")));
        tap.setID(TAPID);
        tap = tap.consultar();
        dataFim = tap.getDataFim();
        dataInicio = tap.getDataInicio();
       }catch(Exception e)
       {
           Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
       }
    }
    
    
    public void addResponsavel()
    {
    
    }
    
    public void addEscopo()
    {
    
    }
    
    public void addPatrocinador()
    {
    
    }
    
    
    public void addStakeholder()
    {
    
    }
    
   
    public void editar()
    {
      try
      {
        tap.setDataCriacao(new java.sql.Date(new Date().getTime()));
        tap.cadastrar();
        Mensageiro.mensagemInfo("O TAP foi atualizado com sucesso!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível atualizar o TAP!");
      }
    }
    
    public void excluir()
    {
      try
      {
        tap.deletar();
        Mensageiro.mensagemInfo("O TAP foi excluido com sucesso!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível excluir o TAP!");
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
