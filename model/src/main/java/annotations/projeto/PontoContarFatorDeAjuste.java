package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import interfaces.IAnnotations;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import model.projeto.PontoContarFatorDeAjusteModel;

@Entity
@Table(name = "PROJETO.PONTO_CONTAR_FATOR_DE_AJUSTE")
public class PontoContarFatorDeAjuste implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_fatorDeAjuste")
    private Integer ID;
    @Column(name = "justificativa", length = 1000)
    private String justificativa;
    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;
    @OneToOne
    @JoinColumn(name = "ID_caracteristicasGeraisDosSistemas")
    private PontoCaracteristicaGeraisDosSistemas caracteristicaGeraisDosSistemas;
    @OneToOne
    @JoinColumn(name = "ID_grauInfluencia")
    private PontoGrauDeInfluencia pontoGrauDeInfluencia;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getJustificativa()
    {
        return justificativa;
    }

    public void setJustificativa(String justificativa)
    {
        this.justificativa = justificativa;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public PontoCaracteristicaGeraisDosSistemas getCaracteristicaGeraisDosSistemas()
    {
        return caracteristicaGeraisDosSistemas;
    }

    public void setCaracteristicaGeraisDosSistemas(PontoCaracteristicaGeraisDosSistemas caracteristicaGeraisDosSistemas)
    {
        this.caracteristicaGeraisDosSistemas = caracteristicaGeraisDosSistemas;
    }

    public PontoGrauDeInfluencia getPontoGrauDeInfluencia()
    {
        return pontoGrauDeInfluencia;
    }

    public void setPontoGrauDeInfluencia(PontoGrauDeInfluencia pontoGrauDeInfluencia)
    {
        this.pontoGrauDeInfluencia = pontoGrauDeInfluencia;
    }

    @Override
    public void cadastrar()
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        model.atualizar(this);
    }

    public List<PontoContarFatorDeAjuste> listar() throws Exception
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        return model.listar();
    }
    
    public List<PontoContarFatorDeAjuste> listarPorProjeto() throws Exception
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        return model.listarPorProjeto(this);
    }

    public PontoContarFatorDeAjuste consultarPorID() throws Exception
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        return model.consultarPorID(this);
    }

    public List<PontoContarFatorDeAjuste> listarPorFiltro(String filtro) throws Exception
    {
        PontoContarFatorDeAjusteModel model = new PontoContarFatorDeAjusteModel();
        return model.listarPorFiltro(filtro);
    }

}
