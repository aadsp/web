package org.aadsp.controller.named.project.requisitos;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.annotations.DocumentoRequisitosTemplate;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;
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
        this.documentoRequisitosTemplate = new DocumentoRequisitosTemplate();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            if (Response.getParametroURL("Temp") != null)
            {
                int IDTemplate = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Temp")));
                this.documentoRequisitosTemplate.setID(IDTemplate);
                this.documentoRequisitosTemplate = documentoRequisitosTemplate.consultarPorID();

                this.documentoRequisitos.setIntroducao(documentoRequisitosTemplate.getIntroducao());
                this.documentoRequisitos.setVisaoGeral(documentoRequisitosTemplate.getVisaoGeral());
                this.documentoRequisitos.setConvencoesTermoAbreviacoes(documentoRequisitosTemplate.getConvencoesTermoAbreviacoes());
                this.documentoRequisitos.setIdentificacaoDosRequisitos(documentoRequisitosTemplate.getIdentificacaoDosRequisitos());
                this.documentoRequisitos.setDescricaoReferencia(documentoRequisitosTemplate.getDescricaoReferencia());
                this.documentoRequisitos.setDescricaoGeralSistema(documentoRequisitosTemplate.getDescricaoGeralSistema());
                this.documentoRequisitos.setAbrangenciaSistemasRelacionados(documentoRequisitosTemplate.getAbrangenciaSistemasRelacionados());
                this.documentoRequisitos.setDescricaoGeralUsuarios(documentoRequisitosTemplate.getDescricaoGeralUsuarios());
                this.documentoRequisitos.setDescricaoRequisitosFuncionais(documentoRequisitosTemplate.getDescricaoRequisitosFuncionais());
                this.documentoRequisitos.setDescricaoRequisitosNFuncionais(documentoRequisitosTemplate.getDescricaoRequisitosNFuncionais());

            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    @Override
    public boolean controleDeCadastro()
    {
        return controleCadastro;
    }

    public void cadastrar() throws MessagingException, EmailException
    {
        try
        {
            documentoRequisitos.cadastrar();
            controleCadastro = true;
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

    public List<DocumentoRequisitosTemplate> listarModelosDocRequisitos()
    {
        try
        {
            return documentoRequisitosTemplate.listar();
        } catch (Exception ex)
        {
            Mensageiro.mensagemInfo("Não foi possível listar os modelos de documentos de requisitos");
        }
        return null;
    }

    public void selecionarModelo(DocumentoRequisitosTemplate template)
    {
        try
        {
            Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosCadastrar.xhtml?Temp=" + Criptografia.codificarParaBase64(template.getID().toString()));
        } catch (IOException ex)
        {
            Mensageiro.mensagemError("Não foi possível selecionar o template desejado!!");
        }
    }

    private DocumentoRequisitos documentoRequisitos;
    private boolean controleCadastro;
    private DocumentoRequisitosTemplate documentoRequisitosTemplate;
}
