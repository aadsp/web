package annotations.requisitos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import model.requisitos.DocumentoRequisitosTemplateModel;
import model.acesso.PaginaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "REQUISITOS.REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_TEMPLATE")
public class DocumentoRequisitosTemplate implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_documentoRequisitosTemplate")
    private Integer ID;
    @Column(name = "nome", length = 100)
    private String nome;
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

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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
