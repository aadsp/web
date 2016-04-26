
package org.aadsp.annotations;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.PaginaModel;

@Entity
@Table(name="ACESSO.PAGINA")
public class Pagina 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nomeDaPagina") private String nomeDaPagina;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNomeDaPagina() {
        return nomeDaPagina;
    }

    public void setNomeDaPagina(String nomeDaPagina) {
        this.nomeDaPagina = nomeDaPagina;
    }
    
    public String consultarNomePagina(Pagina pagina)
    {
        PaginaModel model = new PaginaModel();
        return model.consultarPorID(pagina).nomeDaPagina;
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
