package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import interfaces.IAnnotations;
import model.projeto.PontoTipoDadosTipoModel;

@Entity
@Table(name = "PROJETO.PONTO_TIPO_DADOS_TIPO")
public class PontoTipoDadosTipo implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_pontoTipoDados")
    private Integer ID;
    @Column(name = "sigla", length = 10)
    private String sigla;
    @Column(name = "descricao", length = 60)
    private String descricao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getSigla()
    {
        return sigla;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
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
        PontoTipoDadosTipoModel model = new PontoTipoDadosTipoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoTipoDadosTipoModel model = new PontoTipoDadosTipoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoTipoDadosTipoModel model = new PontoTipoDadosTipoModel();
        model.atualizar(this);
    }

    public List<PontoTipoDadosTipo> listar() throws Exception
    {
        PontoTipoDadosTipoModel model = new PontoTipoDadosTipoModel();
        return model.listar();
    }

    public PontoTipoDadosTipo consultarPorID() throws Exception
    {
        PontoTipoDadosTipoModel model = new PontoTipoDadosTipoModel();
        return model.consultarPorID(this);
    }

    public List<PontoTipoDadosTipo> listarPorFiltro(String filtro) throws Exception
    {
        PontoTipoDadosTipoModel model = new PontoTipoDadosTipoModel();
        return model.listarPorFiltro(filtro);
    }

}
