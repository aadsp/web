package controller.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.acesso.Usuario;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Filtro;
import utils.Mensageiro;
import utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 *
 * @author Felipe Coelho
 * @version 24/04/2016
 */
@ViewScoped
@Named
public class PessoalConsultar extends ABaseNamed
{
    public PessoalConsultar()
    {
        try
        {
            this.usuario = new Usuario();
            this.listaUsuarios = this.usuario.listar();
            this.filtro = new Filtro();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Ocorreu um erro tentar gerar a lista de usuários!!");
        }

    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "nome");
        atributo.put("CPF", "cpf");
        atributo.put("RG", "rg");
        atributo.put("Email", "email");
        atributo.put("Login", "login");

        atributoClasse.put("nome", "acesso.Usuario");
        atributoClasse.put("cpf", "acesso.Usuario");
        atributoClasse.put("rg", "acesso.Usuario");
        atributoClasse.put("email", "acesso.Usuario");
        atributoClasse.put("login", "acesso.Usuario");

        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Usuario> getListarUsuarios()
    {
        try
        {
            return this.listaUsuarios;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar usuário!!");
        }
        return null;
    }

    public void editar(Usuario usuario)
    {
        try
        {
            Response.redirect("/web/faces/views/adm/PessoalEditar.xhtml?Pessoal=" + Criptografia.codificarParaBase64(usuario.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar usuário!!");
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
                listaUsuarios = this.usuario.listarPorFiltro(filtro.filtro);
            } else
            {
                listaUsuarios = this.usuario.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Usuario usuario;
    private Filtro filtro;
    private List<Usuario> listaUsuarios;
}
