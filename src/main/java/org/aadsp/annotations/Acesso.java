
package org.aadsp.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** Classe de Entidade ACESSO.ACESSO, Representa o acesso por meio da função com a página
 * @author Felipe Coelho
 * @version  24/04/2016
 */
@Entity
@Table(name="ACESSO.ACESSO")
public class Acesso 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_funcao") private Integer ID_funcao;
    @Column(name="ID_pagina") private Integer ID_pagina;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID_funcao() {
        return ID_funcao;
    }

    public void setID_funcao(Integer ID_funcao) {
        this.ID_funcao = ID_funcao;
    }

    public Integer getID_pagina() {
        return ID_pagina;
    }

    public void setID_pagina(Integer ID_pagina) {
        this.ID_pagina = ID_pagina;
    }
    
    
    
}
