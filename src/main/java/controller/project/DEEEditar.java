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
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            this.tabela1 = new PontoComplexidadeArquivosInternos();
            this.tabela2 = new PontoComplexidadeEntradasExternas();
            this.tabela3 = new PontoComplexidadeSaidasExternas();
            this.tabela4 = new PontoComplexidadeContribuicao();
            this.tabela5 = new PontoGrauDeInfluencia();
            this.projeto = new Projeto();

            this.projeto.setID(Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto"))));
            this.projeto = projeto.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Variaveis"> 
    
    private PontoComplexidadeArquivosInternos tabela1;
    private PontoComplexidadeEntradasExternas tabela2;
    private PontoComplexidadeSaidasExternas tabela3;
    private PontoComplexidadeContribuicao tabela4;
    private PontoGrauDeInfluencia tabela5;
    private Projeto projeto;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Acessores">
    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public PontoComplexidadeArquivosInternos getTabela1()
    {
        return tabela1;
    }

    public void setTabela1(PontoComplexidadeArquivosInternos tabela1)
    {
        this.tabela1 = tabela1;
    }

    public PontoComplexidadeEntradasExternas getTabela2()
    {
        return tabela2;
    }

    public void setTabela2(PontoComplexidadeEntradasExternas tabela2)
    {
        this.tabela2 = tabela2;
    }

    public PontoComplexidadeSaidasExternas getTabela3()
    {
        return tabela3;
    }

    public void setTabela3(PontoComplexidadeSaidasExternas tabela3)
    {
        this.tabela3 = tabela3;
    }

    public PontoComplexidadeContribuicao getTabela4()
    {
        return tabela4;
    }

    public void setTabela4(PontoComplexidadeContribuicao tabela4)
    {
        this.tabela4 = tabela4;
    }

    public PontoGrauDeInfluencia getTabela5()
    {
        return tabela5;
    }

    public void setTabela5(PontoGrauDeInfluencia tabela5)
    {
        this.tabela5 = tabela5;
    }
    // </editor-fold>
}
