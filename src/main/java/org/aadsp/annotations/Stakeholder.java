
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.StakeholderModel;

@Entity
@Table(name="TAP.TAP_AADSP_STAKEHOLDER")
public class Stakeholder implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nome") private String nome;
    @Column(name="rg") private String rg;
    @Column(name="cpf") private String cpf;
    @Column(name="email") private String email;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Stakeholder> listar() throws Exception
    {
        StakeholderModel  model = new StakeholderModel();
        return model.listar();
    }
    
    public void cadastrar(){
        StakeholderModel model = new StakeholderModel();
        model.salvar(this);
    }
    public Stakeholder consultarPorID() throws Exception
    {
        StakeholderModel model = new StakeholderModel();
        return model.consultarPorID(this);
    }
    
    public void excluir(){
        StakeholderModel model = new StakeholderModel();
        model.excluir(this);
    }
    
    public void editar(){
        StakeholderModel model = new StakeholderModel();
        model.atualizar(this);
    }
}
