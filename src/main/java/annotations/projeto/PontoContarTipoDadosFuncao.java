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
import model.projeto.PontoContarTipoDadosFuncaoModel;

@Entity
@Table(name = "PROJETO.PONTO_CONTAR_TIPO_DADOS_FUNCAO")
public class PontoContarTipoDadosFuncao implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_contarTipoDado")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_pontoTipoDados")
    private PontoTipoDadosTipo tipoDados;
    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;

    @Column(name = "valorTipoDados")
    private int valorTipoDados;
    @Column(name = "descricaoTipoDados", length = 100)
    private String descricaoTipoDados;

    @Column(name = "valorTED")
    private int valorTED;
    @Column(name = "descricaoTED", length = 100)
    private String descricaoTED;

    @Column(name = "valorTER")
    private int valorTER;
    @Column(name = "descricaoTER", length = 100)
    private String descricaoTER;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public PontoTipoDadosTipo getTipoDados()
    {
        return tipoDados;
    }

    public void setTipoDados(PontoTipoDadosTipo tipoDados)
    {
        this.tipoDados = tipoDados;
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

    public int getValorTER()
    {
        return valorTER;
    }

    public void setValorTER(int valorTER)
    {
        this.valorTER = valorTER;
    }

    public String getDescricaoTER()
    {
        return descricaoTER;
    }

    public void setDescricaoTER(String descricaoTER)
    {
        this.descricaoTER = descricaoTER;
    }

    public int getValorTipoDados()
    {
        return valorTipoDados;
    }

    public void setValorTipoDados(int valorTipoDados)
    {
        this.valorTipoDados = valorTipoDados;
    }

    public String getDescricaoTipoDados()
    {
        return descricaoTipoDados;
    }

    public void setDescricaoTipoDados(String descricaoTipoDados)
    {
        this.descricaoTipoDados = descricaoTipoDados;
    }

    @Override
    public void cadastrar()
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        model.atualizar(this);
    }

    public List<PontoContarTipoDadosFuncao> listar() throws Exception
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        return model.listar();
    }

    public List<PontoContarTipoDadosFuncao> listarPorProjeto() throws Exception
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        return model.listarPorProjeto(this);
    }

    public PontoContarTipoDadosFuncao consultarPorID() throws Exception
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        return model.consultarPorID(this);
    }

    public List<PontoContarTipoDadosFuncao> listarPorFiltro(String filtro) throws Exception
    {
        PontoContarTipoDadosFuncaoModel model = new PontoContarTipoDadosFuncaoModel();
        return model.listarPorFiltro(filtro);
    }

}
