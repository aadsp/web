package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import interfaces.IAnnotations;
import model.projeto.PontoTipoTransacaoTipoModel;

@Entity
@Table(name = "PROJETO.PONTO_TIPO_TRANSACAO_TIPO")
public class PontoTipoTransacaoTipo implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_tipoTransacaoTipo")
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
        PontoTipoTransacaoTipoModel model = new PontoTipoTransacaoTipoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoTipoTransacaoTipoModel model = new PontoTipoTransacaoTipoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoTipoTransacaoTipoModel model = new PontoTipoTransacaoTipoModel();
        model.atualizar(this);
    }

    public List<PontoTipoTransacaoTipo> listar() throws Exception
    {
        PontoTipoTransacaoTipoModel model = new PontoTipoTransacaoTipoModel();
        return model.listar();
    }

    public PontoTipoTransacaoTipo consultarPorID() throws Exception
    {
        PontoTipoTransacaoTipoModel model = new PontoTipoTransacaoTipoModel();
        return model.consultarPorID(this);
    }

    public List<PontoTipoTransacaoTipo> listarPorFiltro(String filtro) throws Exception
    {
        PontoTipoTransacaoTipoModel model = new PontoTipoTransacaoTipoModel();
        return model.listarPorFiltro(filtro);
    }

}
