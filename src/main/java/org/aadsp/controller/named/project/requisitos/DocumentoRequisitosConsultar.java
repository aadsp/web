package org.aadsp.controller.named.project.requisitos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.framework.ABaseNamed;
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
public class DocumentoRequisitosConsultar extends ABaseNamed
{

    public DocumentoRequisitosConsultar()
    {
        try
        {
            this.documentoRequisitos = new DocumentoRequisitos();
            this.filtro = new Filtro();
            listadocumentoRequisitos = this.documentoRequisitos.listar();
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

        atributo.put("Título Projeto", "nome");
        atributoClasse.put("nome", "TAP");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<DocumentoRequisitos> getListarDocumentosDeRequisitos()
    {

        return listadocumentoRequisitos;
    }

    public void editar(DocumentoRequisitos documentoRequisitos)
    {
        try
        {
            Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosEditar.xhtml?DocumentoRequisitos=" + Criptografia.codificarParaBase64(documentoRequisitos.getID().toString()));
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
                listadocumentoRequisitos = this.documentoRequisitos.listarPorFiltro(filtro.filtro);
            } else
            {
                listadocumentoRequisitos = this.documentoRequisitos.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    List<DocumentoRequisitos> listadocumentoRequisitos;
    private DocumentoRequisitos documentoRequisitos;
    private Filtro filtro;

}
