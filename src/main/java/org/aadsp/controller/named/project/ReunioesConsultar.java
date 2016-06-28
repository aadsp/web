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
import org.aadsp.framework.ABaseNamed;
import org.aadsp.framework.IConsulta;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

@ViewScoped
@Named
public class ReunioesConsultar extends ABaseNamed implements IConsulta
{

    public ReunioesConsultar()
    {
        try
        {
            this.projeto = new Projeto();
            this.listaProjetos = this.projeto.listar();
            this.filtro = new Filtro();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar os projetos!!");
        }
    }

    public void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "t.nome");
        atributoClasse.put("t.nome", "TAP");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Projeto> listarProjetos()
    {
        return this.listaProjetos;
    }

    public void editar(Projeto projeto)
    {
        try
        {
            Response.redirect("/web/faces/views/projetos/ATAConsultar.xhtml?Projeto=" + Criptografia.codificarParaBase64(projeto.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
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

    public Filtro getFiltro()
    {
        return filtro;
    }

    public void setFiltro(Filtro filtro)
    {
        this.filtro = filtro;
    }

    private Projeto projeto;
    private List<Projeto> listaProjetos;
    private Filtro filtro;

}
