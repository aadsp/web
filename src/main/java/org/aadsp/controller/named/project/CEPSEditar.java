package org.aadsp.controller.named.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.Projeto;
import org.aadsp.annotations.ProjetoCronograma;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.framework.ICadastro;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;
import org.apache.commons.mail.EmailException;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

@ViewScoped
@Named
public class CEPSEditar extends ABaseNamed implements ICadastro
{

    public CEPSEditar()
    {
        this.dataInicio = new Date(new Date().getTime());
        this.dataTermino = new Date(new Date().getTime());
        this.controleDeCadastro = false;
        this.cronograma = new ProjetoCronograma();
        this.listaAtividades = new ArrayList<>();
        carregarDadosIniciais();
    }

    public void carregarDadosIniciais()
    {
        try
        {
            int IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
            Projeto projeto = new Projeto();
            projeto.setID(IDProjeto);
            cronograma.setProjeto(projeto);
            listaAtividades = cronograma.listarPorProjeto();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
        }

        lazyEventModel = new LazyScheduleModel()
        {

            @Override
            public void loadEvents(Date start, Date end)
            {
                if (!listaAtividades.isEmpty())
                {
                    for (ProjetoCronograma obj : listaAtividades)
                    {
                        addEvent(new DefaultScheduleEvent(obj.getAtividade().toUpperCase(), obj.getDataInicio(), obj.getDataTermino()));
                    }
                }
            }
        };
    }

    @Override
    public boolean controleDeCadastro()
    {
        return controleDeCadastro;
    }

    public ScheduleModel getLazyEventModel()
    {
        return lazyEventModel;
    }

    public Date getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio)
    {
        this.dataInicio = dataInicio;
        java.sql.Date dataSql = new java.sql.Date(dataInicio.getTime());
        this.cronograma.setDataInicio(dataSql);
    }

    public Date getDataTermino()
    {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino)
    {
        this.dataTermino = dataTermino;
        java.sql.Date dataSql = new java.sql.Date(dataTermino.getTime());
        this.cronograma.setDataTermino(dataSql);
    }

    public ProjetoCronograma getCronograma()
    {
        return cronograma;
    }

    public void setCronograma(ProjetoCronograma cronograma)
    {
        this.cronograma = cronograma;
    }

    public void cadastrarAtividade()
    {
        try
        {
            Projeto projeto = cronograma.getProjeto();
            projeto = projeto.consultarPorID();
            cronograma.setProjeto(projeto);
            if (cronograma.verificarPeriodoInProjeto())
            {
                cronograma.cadastrar();
                Response.redirect("/web/faces/views/projetos/CEPSEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(cronograma.getProjeto().getID().toString()));
            } else
            {
                SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
                Mensageiro.mensagemInfo("Esta atividade está fora do período do projeto ( " + dataFormatada.format(cronograma.getProjeto().getDataInicio()) + " ~ "+ dataFormatada.format(cronograma.getProjeto().getDataTermino()) +"  )!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar esta atividade!");
        }
    }

    public List<ProjetoCronograma> listaAtividadesDoProjeto()
    {
        try
        {
            return listaAtividades;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar as atividades do projeto!");
        }
        return null;
    }

    public void remvoerCronograma(ProjetoCronograma cronograma)
    {
        try
        {
            cronograma.excluir();
            Response.redirect("/web/faces/views/projetos/CEPSEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(cronograma.getProjeto().getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir a atividade selecionada!");
        }
    }

    private Date dataInicio;
    private Date dataTermino;
    private ScheduleModel lazyEventModel;
    private ProjetoCronograma cronograma;
    private List<ProjetoCronograma> listaAtividades;
    private boolean controleDeCadastro;
}
