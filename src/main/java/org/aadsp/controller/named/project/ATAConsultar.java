package org.aadsp.controller.named.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import org.aadsp.annotations.Projeto;
import org.aadsp.annotations.ReuniaoAta;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.RelatorioIReport;
import org.aadsp.utils.Response;

@ViewScoped
@Named
public class ATAConsultar extends ABaseNamed
{

    public ATAConsultar()
    {
        try
        {
            this.reuniaoAta = new ReuniaoAta();
            this.filtro = new Filtro();
            carregarDadosIniciais();
            criarFiltro();
            this.listaAtasReuniao = this.reuniaoAta.listarPorProjeto();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar as Atas do projeto!!");
        }
    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Titulo", "r.titulo");
        atributoClasse.put("r.titulo", "ReuniaoAta");
        filtro.setAtributo(atributo, atributoClasse);
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

    public List<ReuniaoAta> listarAtas()
    {
        return this.listaAtasReuniao;
    }

    public void editar(ReuniaoAta reuniaoAta)
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/ATAEditar.xhtml?ReuniaoAta=" + Criptografia.codificarParaBase64(reuniaoAta.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Ata do Projeto!!");
        }
    }

    public void gerarPDF(ReuniaoAta reuniaoAta) throws JRException, IOException, SQLException
    {
        try
        {
            RelatorioIReport report = new RelatorioIReport();
            HashMap map = new HashMap();
            map.put("ID_ata", reuniaoAta.getID());
            report.gerarPDF("ATA", map);
        } catch (JRException | IOException | SQLException e)
        {
            Mensageiro.mensagemError("Não possível gerar o relatório em PDF exception:" + e.getMessage());
        }
    }

    public void novo()
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/ATACadastrar.xhtml?Projeto=" + Criptografia.codificarParaBase64(Integer.toString(IDProjeto)));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Ata do Projeto!!");
        }
    }

    public Filtro getFiltro()
    {
        return filtro;
    }

    public void setFiltro(Filtro filtro)
    {
        this.filtro = filtro;
    }

    public void filtroConsulta()
    {
        try
        {
            if (this.filtro.filtro.endsWith(")"))
            {
                listaAtasReuniao = this.reuniaoAta.listarPorFiltro(filtro.filtro);
            } else
            {
                listaAtasReuniao = this.reuniaoAta.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private ReuniaoAta reuniaoAta;
    private int IDProjeto;
    private List<ReuniaoAta> listaAtasReuniao;
    private Filtro filtro;
}
