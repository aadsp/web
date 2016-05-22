
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.ProjetoModel;

@Entity
@Table(name="PROJETO.PROJETO_AADSP_PROJETO")
public class Projeto implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_tap") private Integer ID_tap;
    @Column(name="dataInicio") private Date dataInicio;
    @Column(name="dataTermino") private Date dataTermino;
    @Column(name="dataCadastro") private Date dataCadastro;
    @Column(name="investimento") private double investimento;

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }
    
    public TAP consultarTAP() throws Exception{
        TAP tap = new TAP();
        tap.setID(this.ID_tap);
        return tap.consultar();
    }
    
    public Projeto consultar()
    {
       ProjetoModel  model = new ProjetoModel();
       return model.consultarPorID(this);
    }
    
    public List<Projeto> listar() throws Exception
    {
        ProjetoModel  model = new ProjetoModel();
        return model.listar();
    }
    
    public void cadastrar(){
        ProjetoModel model = new ProjetoModel();
        model.salvar(this);
    }
    
    public void excluir(){
        ProjetoModel model = new ProjetoModel();
        model.excluir(this);
    }
    
    public void editar(){
        ProjetoModel model = new ProjetoModel();
        model.atualizar(this);
    }
    
    public List<Projeto> listarPorFiltro(String filtro) throws Exception
    {
        ProjetoModel model = new ProjetoModel();
        return model.listarPorFiltro(filtro);
    }
}
