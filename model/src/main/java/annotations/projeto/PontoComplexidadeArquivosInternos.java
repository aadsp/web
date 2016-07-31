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
import model.projeto.PontoComplexidadeArquivosInternosModel;

@Entity
@Table(name = "PROJETO.PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS")
public class PontoComplexidadeArquivosInternos implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_pontoArquivosInternos")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_complexidadeNivel")
    private PontoComplexidadeNivel nivel;
    @Column(name = "minTED")
    private int minTED;
    @Column(name = "maxTED")
    private int maxTED;
    @Column(name = "minTER")
    private int minTER;
    @Column(name = "maxTER")
    private int maxTER;

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

    public int getMinTER()
    {
        return minTER;
    }

    public void setMinTER(int minTER)
    {
        this.minTER = minTER;
    }

    public int getMaxTER()
    {
        return maxTER;
    }

    public void setMaxTER(int maxTER)
    {
        this.maxTER = maxTER;
    }

    @Override
    public void cadastrar()
    {
        PontoComplexidadeArquivosInternosModel model = new PontoComplexidadeArquivosInternosModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoComplexidadeArquivosInternosModel model = new PontoComplexidadeArquivosInternosModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoComplexidadeArquivosInternosModel model = new PontoComplexidadeArquivosInternosModel();
        model.atualizar(this);
    }

    public List<PontoComplexidadeArquivosInternos> listar() throws Exception
    {
        PontoComplexidadeArquivosInternosModel model = new PontoComplexidadeArquivosInternosModel();
        return model.listar();
    }

    public PontoComplexidadeArquivosInternos consultarPorID() throws Exception
    {
        PontoComplexidadeArquivosInternosModel model = new PontoComplexidadeArquivosInternosModel();
        return model.consultarPorID(this);
    }
    
    public List<PontoComplexidadeArquivosInternos> listarPorFiltro(String filtro) throws Exception
    {
        PontoComplexidadeArquivosInternosModel model = new PontoComplexidadeArquivosInternosModel();
        return model.listarPorFiltro(filtro);
    }

}
