
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.StakeholderTAPModel;

@Entity
@Table(name="TAP.TAP_AADSP_STAKEHOLDER_TAP")
public class StakeholderTAP implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_stakeholder") private Integer ID_stakeholder;
    @Column(name="ID_tap") private Integer ID_tap;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID_stakeholder() {
        return ID_stakeholder;
    }

    public void setID_stakeholder(Integer ID_stakeholder) {
        this.ID_stakeholder = ID_stakeholder;
    }

    public Integer getID_tap() {
        return ID_tap;
    }

    public void setID_tap(Integer ID_tap) {
        this.ID_tap = ID_tap;
    }

    public String consultarNomeStakeholder() throws Exception
    {
        Stakeholder model = new Stakeholder();
        model.setID(this.ID_stakeholder);
        return model.consultarPorID().getNome();
    }
    
    public List<StakeholderTAP> listar() throws Exception
    {
        StakeholderTAPModel  model = new StakeholderTAPModel();
        return model.listar();
    }
    
    public void cadastrar(){
        StakeholderTAPModel model = new StakeholderTAPModel();
        model.salvar(this);
    }
    public StakeholderTAP consultarPorID() throws Exception
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        return model.consultarPorID(this);
    }
    
    public void excluir(){
        StakeholderTAPModel model = new StakeholderTAPModel();
        model.excluir(this);
    }
    
    public void editar(){
        StakeholderTAPModel model = new StakeholderTAPModel();
        model.atualizar(this);
    }
    
    public List<StakeholderTAP> listarPorIDTAP() throws Exception
    {
        StakeholderTAPModel model = new StakeholderTAPModel();
        return model.listarPorIDTap(this);
    }
}
