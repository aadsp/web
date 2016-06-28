package org.aadsp.controller.named.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import org.aadsp.annotations.TAP;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.RelatorioIReport;
import org.aadsp.utils.Response;

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
        atributoClasse.put("nome", "TAP");
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
