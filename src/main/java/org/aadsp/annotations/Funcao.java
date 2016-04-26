
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.FuncaoModel;

@Entity
@Table(name="ACESSO.FUNCAO")
public class Funcao implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="sigla") private String sigla;
    @Column(name="descricao") private String descricao;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<Funcao> listar() throws Exception
    {
        FuncaoModel model = new FuncaoModel();
        return model.listar();
    }
    
    public void cadastrar()
    {
        FuncaoModel model = new FuncaoModel();
        model.salvar(this);
    }
    
    public Funcao consultarPorID() throws Exception
    {
        FuncaoModel model = new FuncaoModel();
        return model.consultarPorID(this);
    }
}
