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
import model.projeto.PontoContarTipoTransacaoModel;

@Entity
@Table(name = "PROJETO.PONTO_CONTAR_TIPO_TRANSACAO")
public class PontoContarTipoTransacao implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_contarTipoTransacao")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_tipoTransacaoTipo")
    private PontoTipoTransacaoTipo tipoTransacao;
    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;

    @Column(name = "valorTipoTransacao")
    private int valorTipoTransacao;
    @Column(name = "descricaoTipoTransacao", length = 100)
    private String descricaoTipoTransacao;

    @Column(name = "valorTED")
    private int valorTED;
    @Column(name = "descricaoTED", length = 100)
    private String descricaoTED;

    @Column(name = "valorTAR")
    private int valorTAR;
    @Column(name = "descricaoTAR", length = 100)
    private String descricaoTAR;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public PontoTipoTransacaoTipo getTipoTransacao()
    {
        return tipoTransacao;
    }

    public void setTipoTransacao(PontoTipoTransacaoTipo tipoTransacao)
    {
        this.tipoTransacao = tipoTransacao;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public int getValorTED()
    {
        return valorTED;
    }

    public void setValorTED(int valorTED)
    {
        this.valorTED = valorTED;
    }

    public String getDescricaoTED()
    {
        return descricaoTED;
    }

    public void setDescricaoTED(String descricaoTED)
    {
        this.descricaoTED = descricaoTED;
    }

    public int getValorTAR()
    {
        return valorTAR;
    }

    public void setValorTAR(int valorTAR)
    {
        this.valorTAR = valorTAR;
    }

    public String getDescricaoTAR()
    {
        return descricaoTAR;
    }

    public void setDescricaoTAR(String descricaoTAR)
    {
        this.descricaoTAR = descricaoTAR;
    }

    public int getValorTipoTransacao()
    {
        return valorTipoTransacao;
    }

    public void setValorTipoTransacao(int valorTipoTransacao)
    {
        this.valorTipoTransacao = valorTipoTransacao;
    }

    public String getDescricaoTipoTransacao()
    {
        return descricaoTipoTransacao;
    }

    public void setDescricaoTipoTransacao(String descricaoTipoTransacao)
    {
        this.descricaoTipoTransacao = descricaoTipoTransacao;
    }

    @Override
    public void cadastrar()
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        model.atualizar(this);
    }

    public List<PontoContarTipoTransacao> listar() throws Exception
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        return model.listar();
    }

    public List<PontoContarTipoTransacao> listarPorProjeto() throws Exception
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        return model.listarPorProjeto(this);
    }

    public PontoContarTipoTransacao consultarPorID() throws Exception
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        return model.consultarPorID(this);
    }

    public List<PontoContarTipoTransacao> listarPorFiltro(String filtro) throws Exception
    {
        PontoContarTipoTransacaoModel model = new PontoContarTipoTransacaoModel();
        return model.listarPorFiltro(filtro);
    }

}
