
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.ColaboradorModel;

@Entity
@Table(name="COLABORADOR.COLABORADOR_AADSP_COLABORADOR")
public class Colaborador implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_usuario") private Integer ID_usuario;
    @Column(name="numeroPIS") private String numeroPIS;
    @Column(name="dataContrato") private Date dataContrato;
    @Column(name="valorBruto") private double valorBruto;

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

    public String getNumeroPIS() {
        return numeroPIS;
    }

    public void setNumeroPIS(String numeroPIS) {
        this.numeroPIS = numeroPIS;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String consultarNomeColaborador() throws Exception
    {
        Usuario model = new Usuario();
        model.setID(this.ID_usuario);
        return model.consultar().getNome();
    }
    
    public String consultarFuncaoColaborador() throws Exception
    {
        Usuario modelUsuario = new Usuario();
        modelUsuario.setID(this.ID_usuario);
        modelUsuario = modelUsuario.consultar();
        Funcao model = new Funcao();
        model.setID(modelUsuario.getId_funcao());
        return model.consultarPorID().getDescricao();
    }
    
    public Colaborador consultar() throws Exception
    {
        ColaboradorModel model = new ColaboradorModel();
        return model.consultarPorID(this);
    }
    
    public List<Colaborador> listar() throws Exception
    {
        ColaboradorModel  model = new ColaboradorModel();
        return model.listar();
    }
    
    public void cadastrar(){
        ColaboradorModel model = new ColaboradorModel();
        model.salvar(this);
    }
    
    public void excluir(){
        ColaboradorModel model = new ColaboradorModel();
        model.excluir(this);
    }
    
    public void editar(){
        ColaboradorModel model = new ColaboradorModel();
        model.atualizar(this);
    }
}
