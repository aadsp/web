package org.aadsp.controller.named.project.requisitos;

import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.annotations.Requisitos;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * @author Felipe Coelho
 * @version 01/05/2016
 */
@ViewScoped
@Named
public class DocumentoRequisitosEditar extends ABaseNamed
{

    public DocumentoRequisitosEditar()
    {
        this.documentoRequisitos = new DocumentoRequisitos();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDDocumentoRequisitos = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("DocumentoRequisitos")));
            this.documentoRequisitos.setID(IDDocumentoRequisitos);
            documentoRequisitos = documentoRequisitos.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            documentoRequisitos.excluir();
            Response.redirect("/web/faces/views/adm/PaginaConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o documento de requisitos!");
        }
    }

    public void editar()
    {
        try
        {
            documentoRequisitos.editar();
            Mensageiro.mensagemInfo("Documento de requisitos atualizado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar o documento de requisitos!");
        }
    }

    public DocumentoRequisitos getDocumentoRequisitos()
    {
        return documentoRequisitos;
    }

    public void setDocumentoRequisitos(DocumentoRequisitos documentoRequisitos)
    {
        this.documentoRequisitos = documentoRequisitos;
    }

    public List<Requisitos> listarRequisitos()
    {
        try
        {
            Requisitos requisitos = new Requisitos();
            requisitos.setDocumentoRequisitos(documentoRequisitos);
            return requisitos.listarPorDocumentoRequisitos();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar os requisitos do projeto!");
        }
        return null;
    }

    public void removerRequisitoProjeto(Requisitos requisito)
    {
        try
        {
            documentoRequisitos.excluir();
            Response.redirect("/web/faces/views/adm/PaginaConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o documento de requisitos!");
        }
    }

    public Requisitos getRequisitos()
    {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos)
    {
        this.requisitos = requisitos;
    }
    
    public void cadastrarRequisitos()
    {
        try
        {
            requisitos.setDocumentoRequisitos(documentoRequisitos);
            requisitos.setDataCadastro(new java.sql.Date(new Date().getTime()));
            requisitos.cadastrar();
            Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosEditar.xhtml?DocumentoRequisitos=" + Criptografia.codificarParaBase64(documentoRequisitos.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar o documento de requisitos!");
        }
    }
    
    private DocumentoRequisitos documentoRequisitos;
    private Requisitos requisitos;
}
