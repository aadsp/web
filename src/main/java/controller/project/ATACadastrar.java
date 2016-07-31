package controller.project;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import annotations.colaborador.Colaborador;
import annotations.projeto.Projeto;
import annotations.projeto.ReuniaoAta;
import annotations.acesso.Usuario;
import interfaces.ICadastro;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;
import utils.Session;
import org.apache.commons.mail.EmailException;

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
        try
        {
            IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
            Projeto projeto = new Projeto();
            projeto.setID(IDProjeto);
            reuniaoAta.setProjeto(projeto);
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
        }
    }

    @Override
    public boolean controleDeCadastro()
    {
        return this.reuniaoAta.getPauta() != null;
    }

    public void cadastrar() throws MessagingException, EmailException
    {
        try
        {
            reuniaoAta.setDataCadastro(new java.sql.Date(new Date().getTime()));
            Colaborador colaborador = new Colaborador();
            colaborador.setID(organizadorSelecionado);
            reuniaoAta.setColaborador(colaborador);
            reuniaoAta.cadastrar();
            Mensageiro.mensagemInfo("ATA cadastrada com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar a ATA!", (Usuario) Session.getAttribute("usuario"), e);
        }
    }

    public void voltar()
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/ATAConsultar.xhtml?Projeto=" + Criptografia.codificarParaBase64(Integer.toString(IDProjeto)));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
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

    public void setPagina(ReuniaoAta reuniaoAta)
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

    public Map<String, Integer> getOrganizadores()
    {
        try
        {
            Colaborador colaborador = new Colaborador();
            List<Colaborador> lista = colaborador.listar();

            Map<String, Integer> tapMap = new HashMap<String, Integer>();

            for (Colaborador obj : lista)
            {
                tapMap.put(obj.consultarNomeColaborador(), obj.getID());
            }
            return tapMap;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os projetos utilizados!");
        }
        return null;
    }

    public int getOrganizadorSelecionado()
    {
        return organizadorSelecionado;
    }

    public void setOrganizadorSelecionado(int organizadorSelecionado)
    {
        this.organizadorSelecionado = organizadorSelecionado;
    }

    private ReuniaoAta reuniaoAta;
    private int IDProjeto;
    private int organizadorSelecionado;
    private Date dataRealizacao;
}
