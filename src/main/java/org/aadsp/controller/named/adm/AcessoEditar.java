package org.aadsp.controller.named.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Acesso;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Pagina;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Acesso Detalhamento
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class AcessoEditar extends ABaseNamed
{

    public AcessoEditar()
    {
        this.acesso = new Acesso();
        this.funcao = new Funcao();
        this.pagina = new Pagina();
        this.funcoes = new HashMap<String, Integer>();
        this.paginas = new HashMap<String, Integer>();
        carregarDadosIniciais();
    }

    public void carregarDadosIniciais()
    {
        try
        {
            int IDAcesso = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Acesso")));
            acesso.setID(IDAcesso);
            acesso = acesso.consultar();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados da página!!");
        }
    }

    public void editar()
    {
        try
        {
            Funcao funcao = new Funcao();
            Pagina pagina = new Pagina();

            acesso.setFuncao(funcao);
            acesso.setPagina(pagina);
            acesso.cadastrar();
            Mensageiro.mensagemInfo("Atualização realizada com suceso!!");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível realizar esta operação!!");
        }
    }

    public void excluir()
    {
        try
        {
            acesso.excluir();
            Response.redirect("/web/faces/views/adm/AcessoConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível realizar esta operação!!");
        }
    }

    public int getFuncaoSelecionada()
    {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(int funcaoSelecionada)
    {
        this.funcaoSelecionada = funcaoSelecionada;
    }

    public int getPaginaSelecionada()
    {
        return paginaSelecionada;
    }

    public void setPaginaSelecionada(int paginaSelecionada)
    {
        this.paginaSelecionada = paginaSelecionada;
    }

    public Map<String, Integer> getFuncoes()
    {
        try
        {

            List<Funcao> lista = funcao.listar();
            for (Funcao obj : lista)
            {
                if (!this.acesso.getFuncao().getID().equals(obj.getID()))
                {
                    funcoes.put(obj.getDescricao(), obj.getID());
                }
            }
            return funcoes;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar as funções no banco de dados!");
        }
        return null;
    }

    public Acesso getAcesso()
    {
        return acesso;
    }

    public void setAcesso(Acesso acesso)
    {
        this.acesso = acesso;
    }

    public Map<String, Integer> getPaginas()
    {
        try
        {

            List<Pagina> lista = pagina.listar();
            for (Pagina obj : lista)
            {
                if (!this.acesso.getPagina().getID().equals(obj.getID()))
                {
                    paginas.put(obj.getNome(), obj.getID());
                }
            }
            return paginas;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar as páginas no banco de dados!");
        }
        return null;
    }

    private int funcaoSelecionada;
    private int paginaSelecionada;
    private Funcao funcao;
    private Pagina pagina;
    private Map<String, Integer> funcoes;
    private Map<String, Integer> paginas;
    private Acesso acesso;
}
