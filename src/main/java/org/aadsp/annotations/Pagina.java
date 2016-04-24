
package org.aadsp.annotations;

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
        return model.consultar(pagina).nomeDaPagina;
    }
    
}
