
package org.aadsp.annotations;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL.AADSP_PERFIL_PERMISSOES")
public class Permissoes implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_usuarioTipo") private Integer ID_usuarioTipo;
    @Column(name="ID_paginas") private Integer ID_paginas;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Integer getID_usuarioTipo()
    {
        return ID_usuarioTipo;
    }

    public void setID_usuarioTipo(Integer ID_usuarioTipo)
    {
        this.ID_usuarioTipo = ID_usuarioTipo;
    }

    public Integer getID_paginas()
    {
        return ID_paginas;
    }

    public void setID_paginas(Integer ID_pagina)
    {
        this.ID_paginas = ID_pagina;
    }
    
}
