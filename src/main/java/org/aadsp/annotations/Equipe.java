
package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.EquipeModel;

@Entity
@Table(name="TAP.TAP_AADSP_EQUIPE")
public class Equipe implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_funcao") private Integer ID_funcao;
    @Column(name="ID_tap") private Integer ID_tap;

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

    public Integer getID_tap() {
        return ID_tap;
    }

    public void setID_tap(Integer ID_tap) {
        this.ID_tap = ID_tap;
    }

    public String consultarNomeFuncao() throws Exception
    {
       Funcao model = new Funcao();
       model.setID(this.getID_funcao());
       return model.consultarPorID().getDescricao();
    }
    
    public List<Equipe> listar() throws Exception
    {
        EquipeModel  model = new EquipeModel();
        return model.listar();
    }
    
    public List<Equipe> listarPorTAP() throws Exception
    {
        EquipeModel  model = new EquipeModel();
        return model.listarPorTAP(this);
    }
    
    
    public void cadastrar(){
        EquipeModel model = new EquipeModel();
        model.salvar(this);
    }
    public Equipe consultarPorID() throws Exception
    {
        EquipeModel model = new EquipeModel();
        return model.consultarPorID(this);
    }
    
    public void excluir(){
        EquipeModel model = new EquipeModel();
        model.excluir(this);
    }
    
    public void editar(){
        EquipeModel model = new EquipeModel();
        model.atualizar(this);
    }
}
