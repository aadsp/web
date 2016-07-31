package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import interfaces.IAnnotations;
import model.projeto.PontoGrauDeInfluencialModel;

@Entity
@Table(name = "PROJETO.PONTO_GRAU_INFLUENCIA")
public class PontoGrauDeInfluencia implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_grauInfluencia")
    private Integer ID;
    @Column(name = "grau")
    private int grau;
    @Column(name = "descricao", length = 30)
    private String descricao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public int getGrau()
    {
        return grau;
    }

    public void setGrau(int grau)
    {
        this.grau = grau;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    @Override
    public void cadastrar()
    {
        PontoGrauDeInfluencialModel model = new PontoGrauDeInfluencialModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoGrauDeInfluencialModel model = new PontoGrauDeInfluencialModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoGrauDeInfluencialModel model = new PontoGrauDeInfluencialModel();
        model.atualizar(this);
    }

    public List<PontoGrauDeInfluencia> listar() throws Exception
    {
        PontoGrauDeInfluencialModel model = new PontoGrauDeInfluencialModel();
        return model.listar();
    }

    public PontoGrauDeInfluencia consultarPorID() throws Exception
    {
        PontoGrauDeInfluencialModel model = new PontoGrauDeInfluencialModel();
        return model.consultarPorID(this);
    }

    public List<PontoGrauDeInfluencia> listarPorFiltro(String filtro) throws Exception
    {
        PontoGrauDeInfluencialModel model = new PontoGrauDeInfluencialModel();
        return model.listarPorFiltro(filtro);
    }

}
