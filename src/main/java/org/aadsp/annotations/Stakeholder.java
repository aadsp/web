package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.StakeholderModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_STAKEHOLDER")
public class Stakeholder implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_stakeholder")
    private Integer ID;
    @Column(name = "nome",length = 80)
    private String nome;
    @Column(name = "rg",length = 30)
    private String rg;
    @Column(name = "cpf",length = 30)
    private String cpf;
    @Column(name = "email",length = 100)
    private String email;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public void cadastrar()
    {
        StakeholderModel model = new StakeholderModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        StakeholderModel model = new StakeholderModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        StakeholderModel model = new StakeholderModel();
        model.atualizar(this);
    }

    public List<Stakeholder> listar() throws Exception
    {
        StakeholderModel model = new StakeholderModel();
        return model.listar();
    }

    public Stakeholder consultarPorID() throws Exception
    {
        StakeholderModel model = new StakeholderModel();
        return model.consultarPorID(this);
    }

    public List<Stakeholder> listarPorFiltro(String filtro) throws Exception
    {
        StakeholderModel model = new StakeholderModel();
        return model.listarPorFiltro(filtro);
    }

}
