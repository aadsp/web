
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.aadsp.annotations.model.TAPEscopoModel;

@Entity
@Table(name="TAP.TAP_AADSP_ESCOPO")
public class TAPEscopo implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID_escopo") private Integer ID;
    @Column(name="descricao") private String descricao;
    
    @OneToOne
    @JoinColumn(name="ID_tap") private TAP tap;
    @OneToOne
    @JoinColumn(name="ID_escopoArea") private TAPEscopoArea escopoArea;
    @OneToOne
    @JoinColumn(name="ID_escopoTipo") private TAPEscopoTipo escopoTipo;
    
    

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

    public TAPEscopoArea getEscopoArea() {
        return escopoArea;
    }

    public void setEscopoArea(TAPEscopoArea escopoArea) {
        this.escopoArea = escopoArea;
    }

    public TAPEscopoTipo getEscopoTipo() {
        return escopoTipo;
    }

    public void setEscopoTipo(TAPEscopoTipo escopoTipo) {
        this.escopoTipo = escopoTipo;
    }

    public TAP getTap() {
        return tap;
    }

    public void setTap(TAP tap) {
        this.tap = tap;
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
    
    public List<TAPEscopo> listarIDTap() throws Exception
    {
        TAPEscopoModel model = new TAPEscopoModel();
        return model.listarIDTap(this);
    }
    
    public String descricaoArea()
    {
        TAPEscopoArea area = new TAPEscopoArea();
        area.setID(this.escopoArea.getID());
        area = area.consultar();
        return area.getDescricao();
    }
    
    public String descricaoTipo()
    {
        TAPEscopoTipo tipo = new TAPEscopoTipo();
        tipo.setID(this.getEscopoTipo().getID());
        tipo = tipo.consultar();
        return tipo.getDescricao();
    }
}
