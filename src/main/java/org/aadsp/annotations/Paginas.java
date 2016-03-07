
package org.aadsp.annotations;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL.AADSP_PERFIL_PAGINAS")
public class Paginas implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="pagina") private String pagina;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getPagina()
    {
        return pagina;
    }

    public void setPagina(String pagina)
    {
        this.pagina = pagina;
    }
    
}
