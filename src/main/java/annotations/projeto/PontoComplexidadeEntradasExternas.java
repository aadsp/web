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
import model.projeto.PontoComplexidadeEntradasExternasModel;

@Entity
@Table(name = "PROJETO.PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS")
public class PontoComplexidadeEntradasExternas implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_pontoEntradasExternas")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_complexidadeNivel")
    private PontoComplexidadeNivel nivel;
    @Column(name = "minTED")
    private int minTED;
    @Column(name = "maxTED")
    private int maxTED;
    @Column(name = "minTAR")
    private int minTAR;
    @Column(name = "maxTAR")
    private int maxTAR;

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

    public int getMinTED()
    {
        return minTED;
    }

    public void setMinTED(int minTED)
    {
        this.minTED = minTED;
    }

    public int getMaxTED()
    {
        return maxTED;
    }

    public void setMaxTED(int maxTED)
    {
        this.maxTED = maxTED;
    }

    public int getMinTAR()
    {
        return minTAR;
    }

    public void setMinTAR(int minTAR)
    {
        this.minTAR = minTAR;
    }

    public int getMaxTAR()
    {
        return maxTAR;
    }

    public void setMaxTAR(int maxTAR)
    {
        this.maxTAR = maxTAR;
    }

    @Override
    public void cadastrar()
    {
        PontoComplexidadeEntradasExternasModel model = new PontoComplexidadeEntradasExternasModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoComplexidadeEntradasExternasModel model = new PontoComplexidadeEntradasExternasModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoComplexidadeEntradasExternasModel model = new PontoComplexidadeEntradasExternasModel();
        model.atualizar(this);
    }

    public List<PontoComplexidadeEntradasExternas> listar() throws Exception
    {
        PontoComplexidadeEntradasExternasModel model = new PontoComplexidadeEntradasExternasModel();
        return model.listar();
    }

    public PontoComplexidadeEntradasExternas consultarPorID() throws Exception
    {
        PontoComplexidadeEntradasExternasModel model = new PontoComplexidadeEntradasExternasModel();
        return model.consultarPorID(this);
    }

    public List<PontoComplexidadeEntradasExternas> listarPorFiltro(String filtro) throws Exception
    {
        PontoComplexidadeEntradasExternasModel model = new PontoComplexidadeEntradasExternasModel();
        return model.listarPorFiltro(filtro);
    }

}
