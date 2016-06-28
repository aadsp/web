package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.EmpresaModel;
import org.aadsp.framework.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_EMPRESA")
public class Empresa implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_empresa")
    private Integer ID;
    @Column(name = "razaoSocial",length = 100)
    private String razaoSocial;
    @Column(name = "cnpj",length = 60)
    private String cnpj;
    @Column(name = "cpf",length = 60)
    private String cpf;
    @Column(name = "telefone",length = 20)
    private String telefone;
    @Column(name = "email", length = 100)
    private String email;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getRazaoSocial()
    {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial)
    {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
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
    public void excluir()
    {
        EmpresaModel model = new EmpresaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        EmpresaModel model = new EmpresaModel();
        model.atualizar(this);
    }

    @Override
    public void cadastrar()
    {
        EmpresaModel model = new EmpresaModel();
        model.salvar(this);
    }

    public List<Empresa> listar() throws Exception
    {
        EmpresaModel model = new EmpresaModel();
        return model.listar();
    }

    public Empresa consultarPorID() throws Exception
    {
        EmpresaModel model = new EmpresaModel();
        return model.consultarPorID(this);
    }

    public List<Empresa> listarPorFiltro(String filtro) throws Exception
    {
        EmpresaModel model = new EmpresaModel();
        return model.listarPorFiltro(filtro);
    }

}
