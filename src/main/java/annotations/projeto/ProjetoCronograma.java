package annotations.projeto;

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
import model.projeto.ProjetoCronogramaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_CRONOGRAMA")
public class ProjetoCronograma implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_cronograma")
    private Integer ID;

    @Column(name = "atividade", length = 250)
    private String atividade;
    @Column(name = "dataInicio")
    private Date dataInicio;
    @Column(name = "dataTermino")
    private Date dataTermino;

    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getAtividade()
    {
        return atividade;
    }

    public void setAtividade(String atividade)
    {
        this.atividade = atividade;
    }

    public Date getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio)
    {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino()
    {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino)
    {
        this.dataTermino = dataTermino;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    @Override
    public void cadastrar()
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        model.atualizar(this);
    }

    public ProjetoCronograma consultar()
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        return model.consultarPorID(this);
    }

    public List<ProjetoCronograma> listar() throws Exception
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        return model.listar();
    }

    public List<ProjetoCronograma> listarPorProjeto() throws Exception
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        return model.listarPorProjeto(this);
    }

    public ProjetoCronograma consultarPorID()
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        return model.consultarPorID(this);
    }

    public boolean verificarPeriodoInProjeto()
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        return model.verificarPeriodoInProjeto(this);
    }

    public List<ProjetoCronograma> listarPorFiltro(String filtro) throws Exception
    {
        ProjetoCronogramaModel model = new ProjetoCronogramaModel();
        return model.listarPorFiltro(filtro);
    }
}
