package org.aadsp.controller.named.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Pagina;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Edição
 *
 * @author Felipe Coelho
 * @version 01/05/2016
 */
@ViewScoped
@Named
public class PaginaEditar extends ABaseNamed
{

    public PaginaEditar()
    {
        this.pagina = new Pagina();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDPagina = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Pagina")));
            this.pagina.setID(IDPagina);
            this.pagina = pagina.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            pagina.excluir();
            Response.redirect("/web/faces/views/adm/PaginaConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir a página!");
        }
    }

    public void editar()
    {
        try
        {
            pagina.editar();
            Mensageiro.mensagemInfo("Página atualizada com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar a página!");
        }
    }

    public Pagina getPagina()
    {
        return pagina;
    }

    public void setPagina(Pagina pagina)
    {
        this.pagina = pagina;
    }
    private Pagina pagina;
}
