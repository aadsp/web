
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.PaginaModel;

@Entity
@Table(name="ACESSO.ACESSO_AADSP_PAGINA")
public class Pagina implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nome") private String nome;

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
    
    public String consultarNomePagina(Pagina pagina)
    {
        PaginaModel model = new PaginaModel();
        return model.consultarPorID(pagina).nome;
    }
    
    public List<Pagina> listar() throws Exception
    {
        PaginaModel  model = new PaginaModel();
        return model.listar();
    }
    
    public void cadastrar(){
        PaginaModel model = new PaginaModel();
        model.salvar(this);
    }
    public Pagina consultarPorID() throws Exception
    {
        PaginaModel model = new PaginaModel();
        return model.consultarPorID(this);
    }
}
