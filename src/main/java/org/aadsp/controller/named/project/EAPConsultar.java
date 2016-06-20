package org.aadsp.controller.named.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import org.aadsp.annotations.EAP;
import org.aadsp.annotations.Projeto;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

@ViewScoped
@Named
public class EAPConsultar extends ABaseNamed
{

    public EAPConsultar()
    {
        try
        {
            this.eap = new EAP();
            this.listaEAP = this.eap.listar();
            this.filtro = new Filtro();
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

        atributo.put("Nome", "t.descricao");
        atributoClasse.put("t.descricao", "EAPTipo");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<EAP> listarEAPs()
    {
        return this.listaEAP;
    }

    public void editar(EAP eap)
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/EAPEditar.xhtml?EAP=" + Criptografia.codificarParaBase64(eap.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar EAP!!");
        }
    }

    public void gerarPDF(Projeto projeto) throws JRException, IOException, SQLException
    {

    }

    public void filtroConsulta()
    {
        try
        {
            if (this.filtro.filtro.endsWith(")"))
            {
                listaEAP = this.eap.listarPorFiltro(filtro.filtro);
            } else
            {
                listaEAP = this.eap.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
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

    private EAP eap;
    private List<EAP> listaEAP;
    private Filtro filtro;

}
