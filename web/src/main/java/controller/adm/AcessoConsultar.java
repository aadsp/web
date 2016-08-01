package controller.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.acesso.Acesso;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Filtro;
import utils.Mensageiro;
import utils.Response;

/**
 * Classe que representa o objeto de tela Acesso Consulta
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class AcessoConsultar extends ABaseNamed
{

    public AcessoConsultar()
    {
        try
        {
            this.acesso = new Acesso();
            this.filtro = new Filtro();
            this.listaAcesso = this.acesso.listar();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar Funções por páginas!!");
        }
    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Função", "f.descricao");
        atributo.put("Página", "p.nome");

        atributoClasse.put("f.descricao", "Funcao");
        atributoClasse.put("p.nome", "Pagina");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Acesso> getListarAcessoFuncao()
    {
        return listaAcesso;
    }

    public void editar(Acesso acessoFuncao)
    {
        try
        {
            Response.redirect("/web/faces/views/adm/AcessoEditar.xhtml?Acesso=" + Criptografia.codificarParaBase64(Integer.toString(acessoFuncao.getID())));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar controle de acesso!!");
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
                listaAcesso = this.acesso.listarPorFiltro(filtro.filtro);
            } else
            {
                listaAcesso = this.acesso.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Acesso acesso;
    private List<Acesso> listaAcesso;
    private Filtro filtro;

}
