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
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.RelatorioIReport;
import org.aadsp.utils.Response;

@ViewScoped
@Named
public class REConsultar extends ABaseNamed
{

    public REConsultar()
    {
        try
        {
            this.projeto = new Projeto();
            this.filtro = new Filtro();
            this.listaProjetos = this.projeto.listar();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar os projetos!!");
        }
    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome do projeto", "t.nome");
        atributoClasse.put("t.nome", "TAP");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Projeto> listarProjetos()
    {
        return listaProjetos;

    }

    public void editar(Projeto projeto)
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/REEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(projeto.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
        }
    }

    public void gerarPDF(Projeto projeto) throws JRException, IOException, SQLException
    {
        try
        {
            RelatorioIReport report = new RelatorioIReport();
            HashMap map = new HashMap();
            map.put("ID_projeto", projeto.getID());
            report.gerarPDF("RE", map);
        } catch (JRException | IOException | SQLException e)
        {
            Mensageiro.mensagemError("Não possível gerar o relatório em PDF exception:" + e.getMessage());
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
                listaProjetos = this.projeto.listarPorFiltro(filtro.filtro);
            } else
            {
                listaProjetos = this.projeto.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Projeto projeto;
    private List<Projeto> listaProjetos;
    private Filtro filtro;
}
