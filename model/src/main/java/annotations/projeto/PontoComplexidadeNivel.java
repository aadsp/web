package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import interfaces.IAnnotations;
import model.projeto.PontoComplexidadeNivelModel;

@Entity
@Table(name = "PROJETO.PONTO_COMPLEXIDADE_NIVEL")
public class PontoComplexidadeNivel implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_complexidadeNivel")
    private Integer ID;
    @Column(name = "descricao", length = 50)
    private String descricao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
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
        PontoComplexidadeNivelModel model = new PontoComplexidadeNivelModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoComplexidadeNivelModel model = new PontoComplexidadeNivelModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoComplexidadeNivelModel model = new PontoComplexidadeNivelModel();
        model.atualizar(this);
    }

    public List<PontoComplexidadeNivel> listar() throws Exception
    {
        PontoComplexidadeNivelModel model = new PontoComplexidadeNivelModel();
        return model.listar();
    }

    public PontoComplexidadeNivel consultarPorID() throws Exception
    {
        PontoComplexidadeNivelModel model = new PontoComplexidadeNivelModel();
        return model.consultarPorID(this);
    }

    public List<PontoComplexidadeNivel> listarPorFiltro(String filtro) throws Exception
    {
        PontoComplexidadeNivelModel model = new PontoComplexidadeNivelModel();
        return model.listarPorFiltro(filtro);
    }

}
