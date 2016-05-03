
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.EmpresaModel;

@Entity
@Table(name="TAP.TAP_AADSP_EMPRESA")
public class Empresa implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="razaoSocial") private String razaoSocial;
    @Column(name="cnpj") private String cnpj;
    @Column(name="cpf") private String cpf;
    @Column(name="telefone") private String telefone;
    @Column(name="email") private String email;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Empresa> listar() throws Exception
    {
        EmpresaModel  model = new EmpresaModel();
        return model.listar();
    }
    
    public void cadastrar(){
        EmpresaModel model = new EmpresaModel();
        model.salvar(this);
    }
    public Empresa consultarPorID() throws Exception
    {
        EmpresaModel model = new EmpresaModel();
        return model.consultarPorID(this);
    }
    
    public void excluir(){
        EmpresaModel model = new EmpresaModel();
        model.excluir(this);
    }
    
    public void editar(){
        EmpresaModel model = new EmpresaModel();
        model.atualizar(this);
    }
}
