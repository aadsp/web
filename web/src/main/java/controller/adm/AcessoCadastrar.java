package controller.adm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.acesso.Acesso;
import annotations.acesso.Funcao;
import annotations.acesso.Pagina;
import interfaces.ICadastro;
import interfaces.ABaseNamed;
import utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Acesso Cadastro
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class AcessoCadastrar extends ABaseNamed implements ICadastro
{

    public AcessoCadastrar()
    {

    }

    @PostConstruct
    public void init()
    {
        this.acesso = new Acesso();
        this.funcao = new Funcao();
        this.pagina = new Pagina();
        this.funcoes = new HashMap<String, Integer>();
        this.paginas = new HashMap<String, Integer>();
    }

    public boolean controleDeCadastro()
    {
        return this.acesso.getFuncao().getID() != null;
    }

    public void cadastrar()
    {
        try
        {
            Funcao funcao = new Funcao();
            Pagina pagina = new Pagina();
            funcao.setID(funcaoSelecionada);
            pagina.setID(paginaSelecionada);
            acesso.setFuncao(funcao);
            acesso.setPagina(pagina);
            if (!acesso.registrada())
            {
                acesso.cadastrar();
                Mensageiro.mensagemInfo("Cadastro realizado com sucesso!!");
            } else
            {
                Mensageiro.mensagemError("Esta página já foi cadastrada para esta função!!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Esta função já foi adicionada à esta página!!");
        }
    }

    public void onFuncaoSelecionada()
    {
        if (funcaoSelecionada != 0)
        {
            this.paginas = new HashMap<String, Integer>();
            Funcao funcao = new Funcao();
            funcao.setID(funcaoSelecionada);
            this.acesso.setFuncao(funcao);
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
                funcoes.put(obj.getDescricao(), obj.getID());
            }
            return funcoes;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar as funções no banco de dados!");
        }
        return null;
    }

    public Map<String, Integer> getPaginas()
    {
        try
        {
            if (funcaoSelecionada != 0)
            {
                List<Pagina> lista = pagina.listar();
                List<Acesso> acessoFuncao = acesso.listarPorFuncao();
                List<Integer> paginasID = new ArrayList<>();

                for (Acesso obj : acessoFuncao)
                {
                    paginasID.add(obj.getPagina().getID());
                }

                for (Pagina obj : lista)
                {
                    if (!paginasID.contains(obj.getID()))
                    {
                        paginas.put(obj.getNome(), obj.getID());
                    }
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
