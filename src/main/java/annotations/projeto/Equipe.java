package annotations.projeto;

import annotations.tap.TAP;
import annotations.acesso.Funcao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.projeto.EquipeModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_EQUIPE")
public class Equipe implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_equipe")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_funcao")
    private Funcao funcao;
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

    public Funcao getFuncao()
    {
        return funcao;
    }

    public void setFuncao(Funcao funcao)
    {
        this.funcao = funcao;
    }

    public TAP getTap()
    {
        return tap;
    }

    public void setTap(TAP tap)
    {
        this.tap = tap;
    }

    public void cadastrar()
    {
        EquipeModel model = new EquipeModel();
        model.salvar(this);
    }

    public void excluir()
    {
        EquipeModel model = new EquipeModel();
        model.excluir(this);
    }

    public void editar()
    {
        EquipeModel model = new EquipeModel();
        model.atualizar(this);
    }

    public String consultarNomeFuncao() throws Exception
    {
        Funcao model = new Funcao();
        model.setID(this.getFuncao().getID());
        return model.consultarPorID().getDescricao();
    }

    public List<Equipe> listar() throws Exception
    {
        EquipeModel model = new EquipeModel();
        return model.listar();
    }

    public List<Equipe> listarPorTAP() throws Exception
    {
        EquipeModel model = new EquipeModel();
        return model.listarPorTAP(this);
    }

    public Equipe consultarPorID() throws Exception
    {
        EquipeModel model = new EquipeModel();
        return model.consultarPorID(this);
    }

}
