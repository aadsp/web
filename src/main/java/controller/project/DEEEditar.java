package controller.project;

import annotations.projeto.PontoComplexidadeArquivosInternos;
import annotations.projeto.PontoComplexidadeContribuicao;
import annotations.projeto.PontoComplexidadeEntradasExternas;
import annotations.projeto.PontoComplexidadeSaidasExternas;
import annotations.projeto.PontoContarTipoDadosFuncao;
import annotations.projeto.PontoContarTipoTransacao;
import annotations.projeto.PontoGrauDeInfluencia;
import annotations.projeto.PontoTipoDadosTipo;
import annotations.projeto.PontoTipoTransacaoTipo;
import annotations.projeto.Projeto;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import interfaces.ABaseNamed;
import java.util.HashMap;
import java.util.Map;
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
            this.contarTipoTransacao = new PontoContarTipoTransacao();
            this.contarTipoDadosFuncao = new PontoContarTipoDadosFuncao();

            this.projeto.setID(Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto"))));
            this.projeto = projeto.consultarPorID();
            this.contarTipoTransacao.setProjeto(projeto);
            this.contarTipoDadosFuncao.setProjeto(projeto);
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public Map<String, Integer> getTipoTransacao()
    {
        try
        {
            this.tipoTransacaoMap = new HashMap<>();
            PontoTipoTransacaoTipo tipoElemento = new PontoTipoTransacaoTipo();
            for (PontoTipoTransacaoTipo obj : tipoElemento.listar())
            {
                this.tipoTransacaoMap.put(obj.getSigla() + " - " + obj.getDescricao(), obj.getID());
            }

            return tipoTransacaoMap;

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os tipos de transação no banco de dados!");
        }
        return null;
    }

    public Map<String, Integer> getTipoDados()
    {
        try
        {
            this.tipoDadosTipo = new HashMap<>();
            PontoTipoDadosTipo tipoElemento = new PontoTipoDadosTipo();
            for (PontoTipoDadosTipo obj : tipoElemento.listar())
            {
                this.tipoDadosTipo.put(obj.getSigla() + " - " + obj.getDescricao(), obj.getID());
            }

            return tipoDadosTipo;

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os tipos de dados no banco de dados!");
        }
        return null;
    }

    public void contarFuncaoTipoTransacaoSalvar()
    {
        try
        {
            if (tipoTransacaoSelecionada != 0)
            {
                PontoTipoTransacaoTipo pontoTransacao = new PontoTipoTransacaoTipo();
                pontoTransacao.setID(tipoTransacaoSelecionada);
                contarTipoTransacao.setTipoTransacao(pontoTransacao);
                contarTipoTransacao.setProjeto(projeto);
                contarTipoTransacao.cadastrar();

                Response.redirect("/web/faces/views/projetos/DEEEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(projeto.getID().toString()));
            } else
            {
                Mensageiro.mensagemInfo("Não foi selecionado o tipo de transação!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possivel realizar esta operação!");
        }
    }
    
    public void contarFuncaoTipoDadosSalvar()
    {
        try
        {
            if (tipoDadosSelecionado != 0)
            {
                PontoTipoDadosTipo pontoDados = new PontoTipoDadosTipo();
                pontoDados.setID(tipoDadosSelecionado);
                contarTipoDadosFuncao.setTipoDados(pontoDados);
                contarTipoDadosFuncao.setProjeto(projeto);
                contarTipoDadosFuncao.cadastrar();

                Response.redirect("/web/faces/views/projetos/DEEEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(projeto.getID().toString()));
            } else
            {
                Mensageiro.mensagemInfo("Não foi selecionado o tipo de dados!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possivel realizar esta operação!");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Variaveis"> 
    private int tipoTransacaoSelecionada;
    private int tipoDadosSelecionado;
    private Map<String, Integer> tipoTransacaoMap;
    private Map<String, Integer> tipoDadosTipo;
    private PontoContarTipoTransacao contarTipoTransacao;
    private PontoContarTipoDadosFuncao contarTipoDadosFuncao;

    private PontoComplexidadeArquivosInternos tabela1;
    private PontoComplexidadeEntradasExternas tabela2;
    private PontoComplexidadeSaidasExternas tabela3;
    private PontoComplexidadeContribuicao tabela4;
    private PontoGrauDeInfluencia tabela5;
    private Projeto projeto;

    public int getTipoDadosSelecionado()
    {
        return tipoDadosSelecionado;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Acessores">
    public void setTipoDadosSelecionado(int tipoDadosSelecionado)
    {
        this.tipoDadosSelecionado = tipoDadosSelecionado;
    }

    public PontoContarTipoDadosFuncao getContarTipoDadosFuncao()
    {
        return contarTipoDadosFuncao;
    }

    public void setContarTipoDadosFuncao(PontoContarTipoDadosFuncao contarTipoDadosFuncao)
    {
        this.contarTipoDadosFuncao = contarTipoDadosFuncao;
    }

    public PontoContarTipoTransacao getContarTipoTransacao()
    {
        return contarTipoTransacao;
    }

    public void setContarTipoTransacao(PontoContarTipoTransacao contarTipoTransacao)
    {
        this.contarTipoTransacao = contarTipoTransacao;
    }

    public int getTipoTransacaoSelecionada()
    {
        return tipoTransacaoSelecionada;
    }

    public void setTipoTransacaoSelecionada(int tipoTransacaoSelecionada)
    {
        this.tipoTransacaoSelecionada = tipoTransacaoSelecionada;
    }

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
