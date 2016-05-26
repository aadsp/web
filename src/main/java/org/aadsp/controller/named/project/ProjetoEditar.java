package org.aadsp.controller.named.project;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Projeto;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

@ViewScoped
@Named
public class ProjetoEditar extends ABaseNamed
{

    public ProjetoEditar()
    {
        this.projeto = new Projeto();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
            this.projeto.setID(IDProjeto);
            this.projeto = projeto.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            projeto.excluir();
            Response.redirect("/web/faces/views/projetos/ProjetoConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o projeto!");
        }
    }

    public void editar()
    {
        try
        {
            projeto.editar();
            Mensageiro.mensagemInfo("Projeto atualizado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar o projeto!");
        }
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    private Projeto projeto;
}
