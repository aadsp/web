package controller.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.acesso.Funcao;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;

/**
 * Classe que representa o objeto de tela Funcao Edição
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class FuncaoEditar extends ABaseNamed
{

    public FuncaoEditar()
    {
        this.funcao = new Funcao();
        carregarDadosIniciais();
    }

    public void carregarDadosIniciais()
    {
        try
        {
            int IDFuncao = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Funcao")));
            this.funcao.setID(IDFuncao);
            this.funcao = funcao.consultarPorID();

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados da função selecionada!");
        }
    }

    public void editar()
    {
        try
        {
            funcao.editar();
            Mensageiro.mensagemInfo("Função atualizada com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar a função!");
        }
    }

    public void excluir()
    {
        try
        {
            funcao.excluir();
            Response.redirect("/web/faces/views/adm/FuncaoConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar a função!");
        }

    }

    public Funcao getFuncao()
    {
        return funcao;
    }

    public void setFuncao(Funcao funcao)
    {
        this.funcao = funcao;
    }
    private Funcao funcao;
}
