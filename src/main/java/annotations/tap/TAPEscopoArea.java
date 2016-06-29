package annotations.tap;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import model.tap.TAPEscopoAreaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_ESCOPO_AREA")
public class TAPEscopoArea implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_escopoArea")
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
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        model.atualizar(this);
    }

    public TAPEscopoArea consultar()
    {
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        return model.consultarPorID(this);
    }

    public List<TAPEscopoArea> listar() throws Exception
    {
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        return model.listar();
    }
}
