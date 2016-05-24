
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.TAPEscopoAreaModel;

@Entity
@Table(name="TAP.TAP_AADSP_ESCOPO_AREA")
public class TAPEscopoArea implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID_escopoArea") private Integer ID;
    @Column(name="descricao") private String descricao;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void cadastrar(){
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        model.salvar(this);
    }
    
    public TAPEscopoArea consultar()
    {
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        return model.consultarPorID(this);
    }
    
    public void excluir(){
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        model.excluir(this);
    }
    
    public void editar(){
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        model.atualizar(this);
    }
    
    public List<TAPEscopoArea> listar() throws Exception
    {
        TAPEscopoAreaModel model = new TAPEscopoAreaModel();
        return model.listar();
    }
}
