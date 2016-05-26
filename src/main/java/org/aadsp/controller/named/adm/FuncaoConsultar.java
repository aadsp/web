package org.aadsp.controller.named.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Funcao;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class FuncaoConsultar extends ABaseNamed
{

    public FuncaoConsultar()
    {
        try
        {
            this.funcao = new Funcao();
            this.filtro = new Filtro();
            listarFuncoes = this.funcao.listar();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar Funções!!");
        }

    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "descricao");
        atributo.put("Sigla", "sigla");

        atributoClasse.put("descricao", "Funcao");
        atributoClasse.put("sigla", "Funcao");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Funcao> getListarFuncoes()
    {
        return listarFuncoes;

    }

    public void editar(Funcao funcao)
    {
        try
        {
            Response.redirect("/web/faces/views/adm/FuncaoEditar.xhtml?Funcao=" + Criptografia.codificarParaBase64(funcao.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar Função!!");
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
                listarFuncoes = this.funcao.listarPorFiltro(filtro.filtro);
            } else
            {
                listarFuncoes = this.funcao.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Funcao funcao;
    private List<Funcao> listarFuncoes;
    private Filtro filtro;

}
