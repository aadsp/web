package org.aadsp.controller.named.project.requisitos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.DiagramaUML;
import org.aadsp.annotations.DiagramaUMLTipo;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.annotations.ProjetoTela;
import org.aadsp.annotations.Requisitos;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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
        descricaoProjetoTela = "Insira um descrição para este mockup!";
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

    public List<DiagramaUML> listarDiagramasUMLDoProjeto()
    {
        try
        {
            DiagramaUML diagrama = new DiagramaUML();
            diagrama.setProjeto(documentoRequisitos.getProjeto());

            return diagrama.listarPorIDProjeto();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar os diagramas do projeto!!");
        }
        return null;
    }

    public void selecionarDiagrama(DiagramaUML diagrama)
    {
        try
        {
            Response.redirect("../../img/diagramas/uml/" + diagrama.getImagem());
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Erro ao selecionar imagem do diagrama UML");
        }

    }

    public void remvoerDiagramaSelecionado(DiagramaUML diagrama)
    {
        try
        {
            String caminhoServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");

            File file = new File(caminhoServidor + "/img/diagramas/uml/" + diagrama.getImagem());
            file.delete();

            diagrama.excluir();

            Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosEditar.xhtml?DocumentoRequisitos=" + Criptografia.codificarParaBase64(documentoRequisitos.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o diagrama selecionado!!");
        }
    }

    public List<ProjetoTela> listarMockupDoProjeto()
    {
        try
        {
            ProjetoTela projetoTela = new ProjetoTela();
            projetoTela.setProjeto(documentoRequisitos.getProjeto());

            return projetoTela.listarPorProjeto();
        } catch (Exception ex)
        {
            Mensageiro.mensagemInfo("Não foi possível listar os mockup de tela!!");
        }
        return null;
    }

    public void selecionarMockup(ProjetoTela projetoTela)
    {
        try
        {
            Response.redirect("../../img/requisitos/telas/" + projetoTela.getImagem());
        } catch (Exception e)
        {
            Mensageiro.mensagemInfo("Erro ao selecionar imagem do diagrama UML");
        }
    }

    public void removerMockupDoProjeto(ProjetoTela projetoTela)
    {
        try
        {
            String caminhoServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");

            File file = new File(caminhoServidor + "/img/requisitos/telas/" + projetoTela.getImagem());
            file.delete();

            projetoTela.excluir();

            Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosEditar.xhtml?DocumentoRequisitos=" + Criptografia.codificarParaBase64(documentoRequisitos.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o mockup selecionado!!");
        }
    }

    public String getImagem()
    {
        if (imagem != null)
        {
            return imagem.getFileName();
        } else
        {
            return "Nenhuma imagem adicionada!";
        }
    }

    public String getImgProjetoTela()
    {
        if (imgProjetoTela != null)
        {
            return imgProjetoTela.getFileName();
        } else
        {
            return "Nenhuma imagem adicionada!";
        }
    }

    public void fileUploadImagem(FileUploadEvent event) throws Exception
    {
        imagem = event.getFile();
        novoNomeImagem = new java.util.Date().getTime() + "";

        caminhoImagemServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/img/diagramas/uml/" + novoNomeImagem;

        arquivoImagem = event.getFile().getContents();
    }

    public void fileUploadImgProjetoTela(FileUploadEvent event) throws Exception
    {
        imgProjetoTela = event.getFile();
        novoNomeImgProjetoTela = new java.util.Date().getTime() + "";

        caminhoImgProjetoTelaServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/img/projeto/telas/" + novoNomeImgProjetoTela;

        arquivoImgProjetoTela = event.getFile().getContents();
    }

    public int getTipoDiagramaSelecionado()
    {
        return tipoDiagramaSelecionado;
    }

    public void setTipoDiagramaSelecionado(int tipoDiagramaSelecionado)
    {
        this.tipoDiagramaSelecionado = tipoDiagramaSelecionado;
    }

    public Map<String, Integer> listarTiposDiagramUML() throws Exception
    {
        try
        {
            DiagramaUMLTipo tipo = new DiagramaUMLTipo();
            Map<String, Integer> mapTipos = new HashMap<>();

            for (DiagramaUMLTipo obj : tipo.listar())
            {
                mapTipos.put(obj.getDescricao(), obj.getID());
            }
            return mapTipos;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar os tipos de diagramas do projeto!");
        }
        return null;
    }

    public void salvarDiagrama()
    {
        try
        {
            if (tipoDiagramaSelecionado != 0)
            {
                DiagramaUML diagrama = new DiagramaUML();
                DiagramaUMLTipo tipoDiagrama = new DiagramaUMLTipo();

                FileOutputStream fos;
                fos = new FileOutputStream(caminhoImagemServidor);
                fos.write(arquivoImagem);
                fos.close();

                diagrama.setProjeto(documentoRequisitos.getProjeto());
                tipoDiagrama.setID(tipoDiagramaSelecionado);
                diagrama.setImagem(novoNomeImagem);
                diagrama.setDiagramaUMLTipo(tipoDiagrama);
                diagrama.cadastrar();

                Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosEditar.xhtml?DocumentoRequisitos=" + Criptografia.codificarParaBase64(documentoRequisitos.getID().toString()));
            } else
            {
                Mensageiro.mensagemInfo("Não foi selecionado o tipo de diagrama UML!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao salvar diagrama UML");
        }

    }

    public String getDescricaoProjetoTela()
    {
        return descricaoProjetoTela;
    }

    public void setDescricaoProjetoTela(String descricaoProjetoTela)
    {
        this.descricaoProjetoTela = descricaoProjetoTela;
    }

    public void salvarProjetoDeTela()
    {
        try
        {

            ProjetoTela tela = new ProjetoTela();

            FileOutputStream fos;
            fos = new FileOutputStream(caminhoImgProjetoTelaServidor);
            fos.write(arquivoImgProjetoTela);
            fos.close();

            tela.setProjeto(documentoRequisitos.getProjeto());
            tela.setDescricao(descricaoProjetoTela);
            tela.setImagem(novoNomeImgProjetoTela);

            tela.cadastrar();

            Response.redirect("/web/faces/views/requisitos/DocumentoRequisitosEditar.xhtml?DocumentoRequisitos=" + Criptografia.codificarParaBase64(documentoRequisitos.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao salvar projeto de tela mockup!");
        }

    }
    
    private int tipoDiagramaSelecionado;
    private String descricaoProjetoTela;
    private String caminhoImagemServidor;
    private String caminhoImgProjetoTelaServidor;
    private byte[] arquivoImagem;
    private byte[] arquivoImgProjetoTela;
    private String novoNomeImagem;
    private String novoNomeImgProjetoTela;
    private DiagramaUML diagramaSelecionado;
    private UploadedFile imagem;
    private UploadedFile imgProjetoTela;
    private DocumentoRequisitos documentoRequisitos;
    private Requisitos requisitos;
}
