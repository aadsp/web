package annotations.tap;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.tap.PatrocinadorModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "TAP.PATROCINADOR")
public class Patrocinador implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_patrocinador")
    private Integer ID;

    @OneToOne
    @JoinColumn(name = "ID_tap")
    private TAP tap;
    @OneToOne
    @JoinColumn(name = "ID_stakeholder")
    private Stakeholder stakeholder;
    @OneToOne
    @JoinColumn(name = "ID_empresa")
    private Empresa empresa;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public TAP getTap()
    {
        return tap;
    }

    public void setTap(TAP tap)
    {
        this.tap = tap;
    }

    public Stakeholder getStakeholder()
    {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder)
    {
        this.stakeholder = stakeholder;
    }

    public Empresa getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(Empresa empresa)
    {
        this.empresa = empresa;
    }

    @Override
    public void cadastrar()
    {
        PatrocinadorModel model = new PatrocinadorModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PatrocinadorModel model = new PatrocinadorModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PatrocinadorModel model = new PatrocinadorModel();
        model.atualizar(this);
    }

    public String consultarNomeEmpresa() throws Exception
    {
        Empresa empresa = new Empresa();
        empresa.setID(this.getEmpresa().getID());
        return empresa.consultarPorID().getRazaoSocial();
    }

    public String consultarNomeStakeholder() throws Exception
    {
        Stakeholder stakeholder = new Stakeholder();
        stakeholder.setID(this.getStakeholder().getID());
        return stakeholder.consultarPorID().getNome();
    }

    public List<Patrocinador> listar() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listar();
    }

    public Patrocinador consultarPorID() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.consultarPorID(this);
    }

    public List<Patrocinador> listarPorIDTAP() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listarPorIDTap(this);
    }

    public List<Patrocinador> listarPorEmpresas() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listarPorEmpresas(this);
    }

    public List<Patrocinador> listarPorStakeholder() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listarPorStakeholder(this);
    }
}
