
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.ResponsavelModel;

@Entity
@Table(name="TAP.TAP_AADSP_RESPONSAVEL")
public class Responsavel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_usuario") private Integer ID_usuario;
    @Column(name="ID_tap") private Integer ID_tap;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(Integer ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public Integer getID_tap() {
        return ID_tap;
    }

    public void setID_tap(Integer ID_tap) {
        this.ID_tap = ID_tap;
    }
    
    public List<Responsavel> listarPorIDTAP() throws Exception
    {
        ResponsavelModel model = new ResponsavelModel();
        return model.listarPorIDTap(this);
    }        

    
    public void cadastrar(){
        ResponsavelModel model = new ResponsavelModel();
        model.salvar(this);
    }
    public Responsavel consultar() throws Exception
    {
        ResponsavelModel model = new ResponsavelModel();
        return model.consultar(this);
    }
    
    public void excluir(){
        ResponsavelModel model = new ResponsavelModel();
        model.excluir(this);
    }
    
    public void editar(){
        ResponsavelModel model = new ResponsavelModel();
        model.atualizar(this);
    }
    
    public Responsavel consultarReposanvelPorIDUsuario() throws Exception
    {
       ResponsavelModel model = new ResponsavelModel();
       return model.consultarPorIDTapIDUsuario(this);
    }
    
}
