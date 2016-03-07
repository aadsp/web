
package org.aadsp.annotations;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO.AADSP_USUARIO_FUNCIONARIO_CADASTRO")
public class Funcionario implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_usuario") private Integer ID_usuario;
    @Column(name="cargaDiasPorSemana") private Integer cargaDiasPorSemana;
    @Column(name="cargaHorariaDiaria") private Integer cargaHorariaDiaria;
    @Column(name="salarioBase") private double salarioBase;
    @Column(name="alimentacao") private double alimentacao;
    @Column(name="transporte") private double transporte;
    @Column(name="fgts") private double fgts;

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

    public Integer getCargaDiasPorSemana() {
        return cargaDiasPorSemana;
    }

    public void setCargaDiasPorSemana(Integer cargaDiasPorSemana) {
        this.cargaDiasPorSemana = cargaDiasPorSemana;
    }

    public Integer getCargaHorariaDiaria() {
        return cargaHorariaDiaria;
    }

    public void setCargaHorariaDiaria(Integer cargaHorariaDiaria) {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(double alimentacao) {
        this.alimentacao = alimentacao;
    }

    public double getTransporte() {
        return transporte;
    }

    public void setTransporte(double transporte) {
        this.transporte = transporte;
    }

    public double getFgts() {
        return fgts;
    }

    public void setFgts(double fgts) {
        this.fgts = fgts;
    }
    
    
    
}
