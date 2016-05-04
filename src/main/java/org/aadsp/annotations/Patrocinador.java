
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.PatrocinadorModel;

@Entity
@Table(name="TAP.TAP_AADSP_PATROCINADOR")
public class Patrocinador implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_tap") private Integer ID_tap;
    @Column(name="ID_stakeholder") private Integer ID_stakeholder;
    @Column(name="ID_empresa") private Integer ID_empresa;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID_tap() {
        return ID_tap;
    }

    public void setID_tap(Integer ID_tap) {
        this.ID_tap = ID_tap;
    }

    public Integer getID_stakeholder() {
        return ID_stakeholder;
    }

    public void setID_stakeholder(Integer ID_stakeholder) {
        this.ID_stakeholder = ID_stakeholder;
    }

    public Integer getID_empresa() {
        return ID_empresa;
    }

    public void setID_empresa(Integer ID_empresa) {
        this.ID_empresa = ID_empresa;
    }
    
    public String consultarNomeEmpresa() throws Exception
    {
        Empresa empresa = new Empresa();
        empresa.setID(this.ID_empresa);
        return empresa.consultarPorID().getRazaoSocial();
    }
    
    public String consultarNomeStakeholder() throws Exception
    {
        Stakeholder stakeholder = new Stakeholder();
        stakeholder.setID(this.ID_stakeholder);
        return stakeholder.consultarPorID().getNome();
    }
    
    
    public List<Patrocinador> listar() throws Exception
    {
        PatrocinadorModel  model = new PatrocinadorModel();
        return model.listar();
    }
    
    public void cadastrar(){
        PatrocinadorModel model = new PatrocinadorModel();
        model.salvar(this);
    }
    public Patrocinador consultarPorID() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.consultarPorID(this);
    }
    
    public void excluir(){
        PatrocinadorModel model = new PatrocinadorModel();
        model.excluir(this);
    }
    
    public void editar(){
        PatrocinadorModel model = new PatrocinadorModel();
        model.atualizar(this);
    }
    
    public List<Patrocinador> listarPorIDTAP() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listarPorIDTap(this);
    }
    
    public List<Patrocinador> listarPorEmpresas() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listarPorEmpresas(this);
    }
    
    public List<Patrocinador> listarPorStakeholder() throws Exception
    {
        PatrocinadorModel model = new PatrocinadorModel();
        return model.listarPorStakeholder(this);
    }
}
