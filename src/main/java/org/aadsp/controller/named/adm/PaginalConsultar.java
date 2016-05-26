package org.aadsp.controller.named.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Pagina;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 *
 * @author Felipe Coelho
 * @version 24/04/2016
 */
@ViewScoped
@Named
public class PaginalConsultar extends ABaseNamed
{

    public PaginalConsultar()
    {
        try
        {
            this.pagina = new Pagina();
            this.filtro = new Filtro();
            listaPaginas = this.pagina.listar();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar páginas!!");
        }
    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "nome");
        atributoClasse.put("nome", "Pagina");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Pagina> getListarPaginas()
    {

        return listaPaginas;
    }

    public void editar(Pagina pagina)
    {
        try
        {
            Response.redirect("/web/faces/views/adm/PaginaEditar.xhtml?Pagina=" + Criptografia.codificarParaBase64(pagina.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Página!!");
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
                listaPaginas = this.pagina.listarPorFiltro(filtro.filtro);
            } else
            {
                listaPaginas = this.pagina.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    List<Pagina> listaPaginas;
    private Pagina pagina;
    private Filtro filtro;

}
