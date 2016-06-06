package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.aadsp.annotations.model.DocumentoRequisitosModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "REQUISITOS.REQUISITOS_AADSP_DOCUMENTO_REQUISITOS")
public class DocumentoRequisitos implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_documentoRequisitos")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;
    @Column(name = "introducao", length = 500)
    private String introducao;
    @Column(name = "visaoGeral", length = 500)
    private String visaoGeral;
    @Column(name = "convencoesTermoAbreviacoes", length = 500)
    private String convencoesTermoAbreviacoes;
    @Column(name = "identificacaoDosRequisitos", length = 500)
    private String identificacaoDosRequisitos;
    @Column(name = "descricaoReferencia", length = 300)
    private String descricaoReferencia;
    @Column(name = "abrangenciaSistemasRelacionados", length = 500)
    private String abrangenciaSistemasRelacionados;
    @Column(name = "descricaoGeralAtores", length = 300)
    private String descricaoGeralAtores;
    @Column(name = "descricaoGeralSistema", length = 500)
    private String descricaoGeralSistema;
    @Column(name = "descricaoRequisitosFuncionais", length = 500)
    private String descricaoRequisitosFuncionais;
    @Column(name = "descricaoRequisitosNFuncionais", length = 500)
    private String descricaoRequisitosNFuncionais;
    @Column(name = "versao", scale = 2)
    private double versao;
    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @OneToOne
    @JoinColumn(name = "ID_documentoRequisitosTipo")
    private DocumentoRequisitosTipo documentoRequisitosTipo;

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

    public String getDescricaoGeralAtores()
    {
        return descricaoGeralAtores;
    }

    public void setDescricaoGeralAtores(String descricaoGeralAtores)
    {
        this.descricaoGeralAtores = descricaoGeralAtores;
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

    public String getDescricaoGeralSistema()
    {
        return descricaoGeralSistema;
    }

    public void setDescricaoGeralSistema(String descricaoGeralSistema)
    {
        this.descricaoGeralSistema = descricaoGeralSistema;
    }

    public DocumentoRequisitosTipo getDocumentoRequisitosTipo()
    {
        return documentoRequisitosTipo;
    }

    public void setDocumentoRequisitosTipo(DocumentoRequisitosTipo documentoRequisitosTipo)
    {
        this.documentoRequisitosTipo = documentoRequisitosTipo;
    }

    public double getVersao()
    {
        return versao;
    }

    public void setVersao(double versao)
    {
        this.versao = versao;
    }

    public Date getDataCadastro()
    {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public void cadastrar()
    {
        DocumentoRequisitosModel model = new DocumentoRequisitosModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        DocumentoRequisitosModel model = new DocumentoRequisitosModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        DocumentoRequisitosModel model = new DocumentoRequisitosModel();
        model.atualizar(this);
    }

    public List<DocumentoRequisitos> listar() throws Exception
    {
        DocumentoRequisitosModel model = new DocumentoRequisitosModel();
        return model.listar();
    }

    public DocumentoRequisitos consultarPorID() throws Exception
    {
        DocumentoRequisitosModel model = new DocumentoRequisitosModel();
        return model.consultarPorID(this);
    }

    public List<DocumentoRequisitos> listarPorFiltro(String filtro) throws Exception
    {
        DocumentoRequisitosModel model = new DocumentoRequisitosModel();
        return model.listarPorFiltro(filtro);
    }

}
