
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.TAPEscopoAreaModel;
import org.aadsp.annotations.model.TAPEscopoModel;

@Entity
@Table(name="TAP.TAP_AADSP_ESCOPO")
public class TAPEscopo implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_tap") private Integer ID_tap;
    @Column(name="ID_escopoArea") private Integer ID_escopoArea;
    @Column(name="ID_escopoTipo") private Integer ID_escopoTipo;
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

    public Integer getID_tap() {
        return ID_tap;
    }

    public void setID_tap(Integer ID_tap) {
        this.ID_tap = ID_tap;
    }

    public Integer getID_escopoArea() {
        return ID_escopoArea;
    }

    public void setID_escopoArea(Integer ID_escopoArea) {
        this.ID_escopoArea = ID_escopoArea;
    }

    public Integer getID_escopoTipo() {
        return ID_escopoTipo;
    }

    public void setID_escopoTipo(Integer ID_escopoTipo) {
        this.ID_escopoTipo = ID_escopoTipo;
    }
    
    public void cadastrar(){
        TAPEscopoModel model = new TAPEscopoModel();
        model.salvar(this);
    }
    
    public void excluir(){
        TAPEscopoModel model = new TAPEscopoModel();
        model.excluir(this);
    }
    
    public void editar(){
        TAPEscopoModel model = new TAPEscopoModel();
        model.atualizar(this);
    }
    
    public List<TAPEscopo> listar() throws Exception
    {
        TAPEscopoModel model = new TAPEscopoModel();
        return model.listar();
    }
    
    public String descricaoArea()
    {
        TAPEscopoArea area = new TAPEscopoArea();
        area.setID(this.ID_escopoArea);
        area = area.consultar();
        return area.getDescricao();
    }
    
    public String descricaoTipo()
    {
        TAPEscopoTipo tipo = new TAPEscopoTipo();
        tipo.setID(this.ID_escopoTipo);
        tipo = tipo.consultar();
        return tipo.getDescricao();
    }
}
