package org.aadsp.controller.named.project;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.ReuniaoAta;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Edição
 *
 * @author Felipe Coelho
 * @version 01/05/2016
 */
@ViewScoped
@Named
public class ATAEditar extends ABaseNamed
{

    public ATAEditar()
    {
        this.reuniaoAta = new ReuniaoAta();
        carregarDadosIniciais();
        this.dataRealizacao = new Date(reuniaoAta.getDataRealizacao().getTime());
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDReuniaoAta = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("ReuniaoAta")));
            this.reuniaoAta.setID(IDReuniaoAta);
            this.reuniaoAta = reuniaoAta.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            reuniaoAta.excluir();
            Response.redirect("/web/faces/views/projetos/ATAConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir a ATA de reunião!");
        }
    }

    public void editar()
    {
        try
        {
            reuniaoAta.editar();
            Mensageiro.mensagemInfo("Ata de reunião atualizada com sucesso!!");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar a ATA de reunião!");
        }
    }

    public ReuniaoAta getReuniaoAta()
    {
        return reuniaoAta;
    }

    public void setReuniaoAta(ReuniaoAta reuniaoAta)
    {
        this.reuniaoAta = reuniaoAta;
    }
    
    public Date getDataRealizacao()
    {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date date)
    {
        dataRealizacao = date;
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.reuniaoAta.setDataRealizacao(dataSql);
    }
    
    public void voltar()
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/ATAConsultar.xhtml?Projeto=" + Criptografia.codificarParaBase64(Integer.toString(this.reuniaoAta.getProjeto().getID())));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
        }
    }

    private ReuniaoAta reuniaoAta;
    private Date dataRealizacao;
    
}
