package controller.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import annotations.tap.TAP;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Filtro;
import utils.Mensageiro;
import utils.RelatorioIReport;
import utils.Response;

@ViewScoped
@Named
public class TAPConsultar extends ABaseNamed
{

    public TAPConsultar()
    {
        try
        {
            this.tap = new TAP();
            listaTAP = this.tap.listar();
            filtro = new Filtro();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar os termos de abertura de projetos!!");
        }
    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "nome");
        atributoClasse.put("nome", "acesso.TAP");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<TAP> getListarTAPs()
    {
        return listaTAP;

    }

    public void editar(TAP tap)
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar TAP!!");
        }
    }

    public void gerarPDF(TAP tap) throws JRException, IOException, SQLException
    {
        try
        {
            RelatorioIReport report = new RelatorioIReport();
            HashMap map = new HashMap();
            map.put("ID_tap", tap.getID());
            report.gerarPDF("TAP", map);
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
                listaTAP = this.tap.listarPorFiltro(filtro.filtro);
            } else
            {
                listaTAP = this.tap.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private TAP tap;
    private Filtro filtro;
    private List<TAP> listaTAP;
}
