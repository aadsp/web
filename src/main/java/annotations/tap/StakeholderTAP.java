package annotations.tap;

import annotations.tap.TAP;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.tap.StakeholderTAPModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_STAKEHOLDER_TAP")
public class StakeholderTAP implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_stakeholderTap")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_stakeholder")
    private Stakeholder stakeholder;
    @OneToOne
    @JoinColumn(name = "ID_tap")
    private TAP tap;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Stakeholder getStakeholder()
    {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder)
    {
        this.stakeholder = stakeholder;
    }

    public TAP getTap()
    {
        return tap;
    }

    public void setTap(TAP tap)
    {
        this.tap = tap;
    }

    @Override
    public void cadastrar()
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        model.atualizar(this);
    }

    public String consultarNomeStakeholder() throws Exception
    {
        Stakeholder model = new Stakeholder();
        model.setID(this.getStakeholder().getID());
        return model.consultarPorID().getNome();
    }

    public List<StakeholderTAP> listar() throws Exception
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        return model.listar();
    }

    public StakeholderTAP consultarPorID() throws Exception
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        return model.consultarPorID(this);
    }

    public List<StakeholderTAP> listarPorIDTAP() throws Exception
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        return model.listarPorIDTap(this);
    }
}
