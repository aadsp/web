package controller.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.projeto.Projeto;
import annotations.projeto.ProjetoRecursosAdicionais;
import interfaces.ABaseNamed;
import interfaces.ICadastro;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;

@ViewScoped
@Named
public class REEditar extends ABaseNamed implements ICadastro
{
    
    public REEditar()
    {
        this.recursosEspeciais = new ProjetoRecursosAdicionais();
        this.listaRecursosEspeciais = new ArrayList<>();
        carregarDadosIniciais();
    }
    
    public void carregarDadosIniciais()
    {
        try
        {
            int IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
            Projeto projeto = new Projeto();
            projeto.setID(IDProjeto);
            recursosEspeciais.setProjeto(projeto);
            listaRecursosEspeciais = recursosEspeciais.listarPorProjeto();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
        }
    }
    
    @Override
    public boolean controleDeCadastro()
    {
        return controleDeCadastro;
    }
    
    public ProjetoRecursosAdicionais getRequisitosEspeciais()
    {
        return recursosEspeciais;
    }
    
    public void setRequisitosEspeciais(ProjetoRecursosAdicionais requisitosEspeciais)
    {
        this.recursosEspeciais = requisitosEspeciais;
    }
    
    public void cadastrarRecursoEspecial()
    {
        try
        {
            Projeto projeto = recursosEspeciais.getProjeto();
            projeto = projeto.consultarPorID();
            recursosEspeciais.setProjeto(projeto);
            recursosEspeciais.setDataCadastro(new java.sql.Date(new Date().getTime()));
            recursosEspeciais.cadastrar();
            Response.redirect("/web/faces/views/projetos/REEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(recursosEspeciais.getProjeto().getID().toString()));
            
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar este recurso especial!");
        }
    }
    
    public List<ProjetoRecursosAdicionais> listaRecursosEspeciaisDoProjeto()
    {
        try
        {
            return listaRecursosEspeciais;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar os recursos especiais do projeto!");
        }
        return null;
    }
    
    public void removerRecursoEspecial(ProjetoRecursosAdicionais recursosDoProjeto)
    {
        try
        {
            recursosDoProjeto.excluir();
            Response.redirect("/web/faces/views/projetos/REEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(recursosDoProjeto.getProjeto().getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o recurso especial selecionado!");
        }
    }
    
    private ProjetoRecursosAdicionais recursosEspeciais;
    private List<ProjetoRecursosAdicionais> listaRecursosEspeciais;
    private boolean controleDeCadastro;
}
