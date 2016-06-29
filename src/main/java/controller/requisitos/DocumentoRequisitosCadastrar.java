package controller.requisitos;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import annotations.requisitos.DocumentoRequisitos;
import annotations.requisitos.DocumentoRequisitosTemplate;
import annotations.requisitos.DocumentoRequisitosTipo;
import annotations.projeto.Projeto;
import annotations.acesso.Usuario;
import interfaces.ABaseNamed;
import interfaces.ICadastro;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;
import utils.Session;
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
                this.documentoRequisitos.setDescricaoGeralAtores(documentoRequisitosTemplate.getDescricaoGeralAtores());
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
            
            Projeto projeto = new Projeto();
            projeto.setID(projetoSelecionado);
            documentoRequisitos.setProjeto(projeto);
            DocumentoRequisitosTipo tipo = new DocumentoRequisitosTipo();
            tipo.setID(tipoDocumentoRequisitoSelecionado);
            documentoRequisitos.setDocumentoRequisitosTipo(tipo);
            documentoRequisitos.setDataCadastro(new java.sql.Date(new Date().getTime()));
            documentoRequisitos.cadastrar();
            controleCadastro = true;
            Mensageiro.mensagemInfo("Documenot de requisitos cadastrado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar a documento de requisitos!");
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

    public int getTipoDocumentoRequisitoSelecionado()
    {
        return tipoDocumentoRequisitoSelecionado;
    }

    public void setTipoDocumentoRequisitoSelecionado(int tipoDocumentoRequisitoSelecionado)
    {
        this.tipoDocumentoRequisitoSelecionado = tipoDocumentoRequisitoSelecionado;
    }

    public int getProjetoSelecionado()
    {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(int projetoSelecionado)
    {
        this.projetoSelecionado = projetoSelecionado;
    }

    public Map<String, Integer> tiposDocumentoRequisitos()
    {
        Map<String, Integer> map = new HashMap<>();
        try
        {
            DocumentoRequisitosTipo documentoTipo = new DocumentoRequisitosTipo();
            List<DocumentoRequisitosTipo> lista = documentoTipo.listar();

            for (DocumentoRequisitosTipo obj : lista)
            {
                map.put(obj.getNome(), obj.getID());
            }

        } catch (Exception ex)
        {
            Mensageiro.mensagemError("Não foi possível listar os tipos de documentos de requisitos!");
        }
        return map;
    }

    public Map<String, Integer> projetos()
    {
        Map<String, Integer> map = new HashMap<>();
        try
        {
            Projeto projeto = new Projeto();
            List<Projeto> lista = projeto.listarSemDocRequisitos();

            for (Projeto obj : lista)
            {
                map.put(obj.getTap().getNome(), obj.getID());
            }

        } catch (Exception ex)
        {
            Mensageiro.mensagemError("Não foi possível listar os projetos!");
        }
        return map;
    }

    private DocumentoRequisitos documentoRequisitos;
    private boolean controleCadastro;
    private int tipoDocumentoRequisitoSelecionado;
    private int projetoSelecionado;
    private DocumentoRequisitosTemplate documentoRequisitosTemplate;
}
