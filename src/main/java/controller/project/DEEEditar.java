package controller.project;

import annotations.projeto.PontoComplexidadeArquivosInternos;
import annotations.projeto.PontoComplexidadeContribuicao;
import annotations.projeto.PontoComplexidadeEntradasExternas;
import annotations.projeto.PontoComplexidadeSaidasExternas;
import annotations.projeto.PontoGrauDeInfluencia;
import annotations.projeto.Projeto;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import interfaces.ABaseNamed;
import java.util.List;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;

/**
 *
 * @author Felipe Coelho
 * @version 01/05/2016
 */
@ViewScoped
@Named
public class DEEEditar extends ABaseNamed
{

    public DEEEditar()
    {
        this.tabela1 = new PontoComplexidadeArquivosInternos();
        this.tabela2 = new PontoComplexidadeEntradasExternas();
        this.tabela3 = new PontoComplexidadeSaidasExternas();
        this.tabela4 = new PontoComplexidadeContribuicao();
        this.tabela5 = new PontoGrauDeInfluencia();
        this.projeto = new Projeto();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
            projeto.setID(IDProjeto);
            projeto = projeto.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public List<PontoComplexidadeArquivosInternos> listarTable1()
    {
        try
        {
            return tabela1.listar();
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível construir os dados de base da tabela 1");
        }
        return null;
    }

    public List<PontoComplexidadeEntradasExternas> listarTable2()
    {
        try
        {
            return tabela2.listar();
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível construir os dados de base da tabela 2");
        }
        return null;
    }
    
    public List<PontoComplexidadeSaidasExternas> listarTable3()
    {
        try
        {
            return tabela3.listar();
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível construir os dados de base da tabela 3");
        }
        return null;
    }
    
    public List<PontoComplexidadeContribuicao> listarTable4()
    {
        try
        {
            return tabela4.listar();
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível construir os dados de base da tabela 4");
        }
        return null;
    }
    
    public List<PontoGrauDeInfluencia> listarTable5()
    {
        try
        {
            return tabela5.listar();
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Não foi possível construir os dados de base da tabela 5");
        }
        return null;
    }
    
    private PontoComplexidadeArquivosInternos tabela1;
    private PontoComplexidadeEntradasExternas tabela2;
    private PontoComplexidadeSaidasExternas tabela3;
    private PontoComplexidadeContribuicao tabela4;
    private PontoGrauDeInfluencia tabela5;
    private Projeto projeto;
}
