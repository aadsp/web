package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.DocumentoRequisitosTemplateModel;
import org.aadsp.annotations.model.PaginaModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "REQUISITOS.REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_TEMPLATE")
public class DocumentoRequisitosTemplate implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_documentoRequisitosTemplate")
    private Integer ID;
    private Projeto projeto;
    @Column(name = "introducao")
    private String introducao;
    @Column(name = "visaoGeral")
    private String visaoGeral;
    @Column(name = "convencoesTermoAbreviacoes")
    private String convencoesTermoAbreviacoes;
    @Column(name = "identificacaoDosRequisitos")
    private String identificacaoDosRequisitos;
    @Column(name = "descricaoReferencia")
    private String descricaoReferencia;
    @Column(name = "abrangenciaSistemasRelacionados")
    private String abrangenciaSistemasRelacionados;
    @Column(name = "descricaoGeralUsuarios")
    private String descricaoGeralUsuarios;
    @Column(name = "descricaoRequisitosFuncionais")
    private String descricaoRequisitosFuncionais;
    @Column(name = "descricaoRequisitosNFuncionais")
    private String descricaoRequisitosNFuncionais;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public String getIntroducao()
    {
        return introducao;
    }

    public void setIntroducao(String introducao)
    {
        this.introducao = introducao;
    }

    public String getVisaoGeral()
    {
        return visaoGeral;
    }

    public void setVisaoGeral(String visaoGeral)
    {
        this.visaoGeral = visaoGeral;
    }

    public String getConvencoesTermoAbreviacoes()
    {
        return convencoesTermoAbreviacoes;
    }

    public void setConvencoesTermoAbreviacoes(String convencoesTermoAbreviacoes)
    {
        this.convencoesTermoAbreviacoes = convencoesTermoAbreviacoes;
    }

    public String getIdentificacaoDosRequisitos()
    {
        return identificacaoDosRequisitos;
    }

    public void setIdentificacaoDosRequisitos(String identificacaoDosRequisitos)
    {
        this.identificacaoDosRequisitos = identificacaoDosRequisitos;
    }

    public String getDescricaoReferencia()
    {
        return descricaoReferencia;
    }

    public void setDescricaoReferencia(String descricaoReferencia)
    {
        this.descricaoReferencia = descricaoReferencia;
    }

    public String getAbrangenciaSistemasRelacionados()
    {
        return abrangenciaSistemasRelacionados;
    }

    public void setAbrangenciaSistemasRelacionados(String abrangenciaSistemasRelacionados)
    {
        this.abrangenciaSistemasRelacionados = abrangenciaSistemasRelacionados;
    }

    public String getDescricaoGeralUsuarios()
    {
        return descricaoGeralUsuarios;
    }

    public void setDescricaoGeralUsuarios(String descricaoGeralUsuarios)
    {
        this.descricaoGeralUsuarios = descricaoGeralUsuarios;
    }

    public String getDescricaoRequisitosFuncionais()
    {
        return descricaoRequisitosFuncionais;
    }

    public void setDescricaoRequisitosFuncionais(String descricaoRequisitosFuncionais)
    {
        this.descricaoRequisitosFuncionais = descricaoRequisitosFuncionais;
    }

    public String getDescricaoRequisitosNFuncionais()
    {
        return descricaoRequisitosNFuncionais;
    }

    public void setDescricaoRequisitosNFuncionais(String descricaoRequisitosNFuncionais)
    {
        this.descricaoRequisitosNFuncionais = descricaoRequisitosNFuncionais;
    }

    @Override
    public void cadastrar()
    {
        PaginaModel model = new PaginaModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PaginaModel model = new PaginaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PaginaModel model = new PaginaModel();
        model.atualizar(this);
    }

    public List<DocumentoRequisitosTemplate> listar() throws Exception
    {
        DocumentoRequisitosTemplateModel model = new DocumentoRequisitosTemplateModel();
        return model.listar();
    }

    public DocumentoRequisitosTemplate consultarPorID() throws Exception
    {
        DocumentoRequisitosTemplateModel model = new DocumentoRequisitosTemplateModel();
        return model.consultarPorID(this);
    }

    public List<DocumentoRequisitosTemplate> listarPorFiltro(String filtro) throws Exception
    {
        DocumentoRequisitosTemplateModel model = new DocumentoRequisitosTemplateModel();
        return model.listarPorFiltro(filtro);
    }

}
