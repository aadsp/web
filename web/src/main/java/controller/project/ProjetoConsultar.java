package controller.project;

import annotations.projeto.EAP;
import annotations.projeto.PontoContarTipoDadosFuncao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import annotations.projeto.Projeto;
import annotations.projeto.ProjetoCronograma;
import annotations.projeto.ProjetoRecursosAdicionais;
import annotations.projeto.ReuniaoAta;
import interfaces.ABaseNamed;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import utils.Criptografia;
import utils.Filtro;
import utils.Mensageiro;
import utils.Response;

@ViewScoped
@Named
public class ProjetoConsultar extends ABaseNamed
{

    public ProjetoConsultar()
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
    
    public void gerarDiagramDeFasesDoProjeto(Projeto projeto) throws Exception
    {
        this.fasesDoProjeto = null;
        this.fasesDoProjeto = new DefaultTreeNode("TAP", null);
        TreeNode node0 = new DefaultTreeNode("PROJETO", fasesDoProjeto);
        EAP eap = new EAP();
        eap.setProjeto(projeto);
        TreeNode node1;
        if(eap.consultarPorIDProjeto() != null)
           node1 = new DefaultTreeNode("EAP", node0);
        ReuniaoAta reuniao = new ReuniaoAta();
        reuniao.setProjeto(projeto);
        TreeNode node2;
        if(reuniao.listarPorProjeto().size() > 0)
             node2 = new DefaultTreeNode("ATAS ", node0);
        PontoContarTipoDadosFuncao estimativa = new PontoContarTipoDadosFuncao();
        estimativa.setProjeto(projeto);
        TreeNode node3;
        if(estimativa.listarPorProjeto().size() > 0)
             node3 = new DefaultTreeNode("DEE ", node0);
        ProjetoCronograma cronograma = new ProjetoCronograma();
        cronograma.setProjeto(projeto);
        TreeNode node4;
        if(cronograma.listarPorProjeto().size() > 0)
             node4 = new DefaultTreeNode("CEPS ", node0);
        ProjetoRecursosAdicionais recursos = new ProjetoRecursosAdicionais();
        recursos.setProjeto(projeto);
        TreeNode node5;
        if(cronograma.listarPorProjeto().size() > 0)
             node5 = new DefaultTreeNode("RE ", node0);
        
    }
    
    public TreeNode getFases() {
        return fasesDoProjeto;
    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "t.nome");
        atributoClasse.put("t.nome", "tap.TAP");
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
            Response.redirect("/web/faces/views/projetos/ProjetoEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(projeto.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
        }
    }

    public void gerarPDF(Projeto projeto) throws JRException, IOException, SQLException
    {
        Mensageiro.mensagemInfo("Funcionalidade em desenvolvimento!");
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
    private TreeNode fasesDoProjeto;
}
