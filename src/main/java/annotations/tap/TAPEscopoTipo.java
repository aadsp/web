package annotations.tap;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import model.tap.TAPEscopoTipoModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_ESCOPO_TIPO")
public class TAPEscopoTipo implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_escopoTipo")
    private Integer ID;
    @Column(name = "descricao",length = 100)
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
        TAPEscopoTipoModel model = new TAPEscopoTipoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        TAPEscopoTipoModel model = new TAPEscopoTipoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        TAPEscopoTipoModel model = new TAPEscopoTipoModel();
        model.atualizar(this);
    }

    public TAPEscopoTipo consultar()
    {
        TAPEscopoTipoModel model = new TAPEscopoTipoModel();
        return model.consultarPorID(this);
    }

    public List<TAPEscopoTipo> listar() throws Exception
    {
        TAPEscopoTipoModel model = new TAPEscopoTipoModel();
        return model.listar();
    }
}
