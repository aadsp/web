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
import model.projeto.PontoComplexidadeContribuicaoModel;

@Entity
@Table(name = "PROJETO.PONTO_COMPLEXIDADE_CONTRIBUICAO")
public class PontoComplexidadeContribuicao implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_pontoContribuicao")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_complexidadeNivel")
    private PontoComplexidadeNivel nivel;
    @Column(name = "ALI")
    private int ALI;
    @Column(name = "AIE")
    private int AIE;
    @Column(name = "EE")
    private int EE;
    @Column(name = "SE")
    private int CE;
    @Column(name = "CE")
    private int SE;

    public PontoComplexidadeNivel getNivel()
    {
        return nivel;
    }

    public void setNivel(PontoComplexidadeNivel nivel)
    {
        this.nivel = nivel;
    }

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public int getALI()
    {
        return ALI;
    }

    public void setALI(int ALI)
    {
        this.ALI = ALI;
    }

    public int getAIE()
    {
        return AIE;
    }

    public void setAIE(int AIE)
    {
        this.AIE = AIE;
    }

    public int getEE()
    {
        return EE;
    }

    public void setEE(int EE)
    {
        this.EE = EE;
    }

    public int getCE()
    {
        return CE;
    }

    public void setCE(int CE)
    {
        this.CE = CE;
    }

    public int getSE()
    {
        return SE;
    }

    public void setSE(int SE)
    {
        this.SE = SE;
    }

    @Override
    public void cadastrar()
    {
        PontoComplexidadeContribuicaoModel model = new PontoComplexidadeContribuicaoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoComplexidadeContribuicaoModel model = new PontoComplexidadeContribuicaoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoComplexidadeContribuicaoModel model = new PontoComplexidadeContribuicaoModel();
        model.atualizar(this);
    }

    public List<PontoComplexidadeContribuicao> listar() throws Exception
    {
        PontoComplexidadeContribuicaoModel model = new PontoComplexidadeContribuicaoModel();
        return model.listar();
    }

    public PontoComplexidadeContribuicao consultarPorID() throws Exception
    {
        PontoComplexidadeContribuicaoModel model = new PontoComplexidadeContribuicaoModel();
        return model.consultarPorID(this);
    }

    public List<PontoComplexidadeContribuicao> listarPorFiltro(String filtro) throws Exception
    {
        PontoComplexidadeContribuicaoModel model = new PontoComplexidadeContribuicaoModel();
        return model.listarPorFiltro(filtro);
    }

}
