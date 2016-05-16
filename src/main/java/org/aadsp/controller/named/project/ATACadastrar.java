
package org.aadsp.controller.named.project;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.ReuniaoAta;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;
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
        dataRealizacao = new Date(new Date().getTime());
        carregarDadosIniciais();
    }
    
    public void carregarDadosIniciais()
    {
       try{
        IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
        reuniaoAta.setID_projeto(IDProjeto);
       }catch(Exception e)
       {
           Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
       }
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
        reuniaoAta.setDataCadastro(new java.sql.Date(new Date().getTime()));
        reuniaoAta.cadastrar();
        Mensageiro.mensagemInfo("ATA cadastrada com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar a ATA!",(Usuario)Session.getAttribute("usuario"),e);
      }
    }
    
    public void voltar()
    {
       try
       {
        Response.redirect("/web/faces/views/projetos/ATAConsultar.xhtml?Projeto="+ Criptografia.codificarParaBase64(Integer.toString(IDProjeto)));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
       }
    }

    public ReuniaoAta getReuniaoAta() {
        return reuniaoAta;
    }

    public void setReuniaoAta(ReuniaoAta reuniaoAta) {
        this.reuniaoAta = reuniaoAta;
    }
  
    
    public void setPagina(ReuniaoAta reuniaoAta){
        this.reuniaoAta = reuniaoAta;
    }
    
    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date date) {
       dataRealizacao = date;
       java.sql.Date dataSql = new java.sql.Date(date.getTime());
       this.reuniaoAta.setDataRealizacao(dataSql);
    }
    
    private ReuniaoAta reuniaoAta;
    private int IDProjeto;
    private Date dataRealizacao;
}
