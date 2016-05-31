package org.aadsp.controller.named.project.requisitos;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Session;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class DocumentoRequisitosCadastrar extends ABaseNamed implements ICadastro
{

    public DocumentoRequisitosCadastrar()
    {
        this.documentoRequisitos = new DocumentoRequisitos();
    }

    @Override
    public boolean controleDeCadastro()
    {
        return this.documentoRequisitos.getIntroducao() != null;
    }

    public void cadastrar() throws MessagingException, EmailException
    {
        try
        {
            documentoRequisitos.cadastrar();
            Mensageiro.mensagemInfo("Documenot de requisitos cadastrado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar a documento de requisitos!", (Usuario) Session.getAttribute("usuario"), e);
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

    private DocumentoRequisitos documentoRequisitos;
}
