package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import interfaces.IAnnotations;
import model.projeto.PontoCaracteristicaGeraisDosSistemasModel;

@Entity
@Table(name = "PROJETO.PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS")
public class PontoCaracteristicaGeraisDosSistemas implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_caracteristicasGeraisDosSistemas")
    private Integer ID;
    @Column(name = "valor", length = 100)
    private String valor;
    @Column(name = "descricaoGeral", length = 300)
    private String descricaoGeral;
    @Column(name = "itensObservados", length = 1000)
    private String itensObservados;
    @Column(name = "pontosObservados", length = 1000)
    private String pontosObservados;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    public String getDescricaoGeral()
    {
        return descricaoGeral;
    }

    public void setDescricaoGeral(String descricaoGeral)
    {
        this.descricaoGeral = descricaoGeral;
    }

    public String getItensObservados()
    {
        return itensObservados;
    }

    public void setItensObservados(String itensObservados)
    {
        this.itensObservados = itensObservados;
    }

    public String getPontosObservados()
    {
        return pontosObservados;
    }

    public void setPontosObservados(String pontosObservados)
    {
        this.pontosObservados = pontosObservados;
    }

    @Override
    public void cadastrar()
    {
        PontoCaracteristicaGeraisDosSistemasModel model = new PontoCaracteristicaGeraisDosSistemasModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PontoCaracteristicaGeraisDosSistemasModel model = new PontoCaracteristicaGeraisDosSistemasModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PontoCaracteristicaGeraisDosSistemasModel model = new PontoCaracteristicaGeraisDosSistemasModel();
        model.atualizar(this);
    }

    public List<PontoCaracteristicaGeraisDosSistemas> listar() throws Exception
    {
        PontoCaracteristicaGeraisDosSistemasModel model = new PontoCaracteristicaGeraisDosSistemasModel();
        return model.listar();
    }

    public PontoCaracteristicaGeraisDosSistemas consultarPorID() throws Exception
    {
        PontoCaracteristicaGeraisDosSistemasModel model = new PontoCaracteristicaGeraisDosSistemasModel();
        return model.consultarPorID(this);
    }

    public List<PontoCaracteristicaGeraisDosSistemas> listarPorFiltro(String filtro) throws Exception
    {
        PontoCaracteristicaGeraisDosSistemasModel model = new PontoCaracteristicaGeraisDosSistemasModel();
        return model.listarPorFiltro(filtro);
    }

}
