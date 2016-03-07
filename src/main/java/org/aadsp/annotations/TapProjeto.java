
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AADSP.TAP.AADSP_TAP_PROJETO")
public class TapProjeto implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nome") private String nome;
    @Column(name="versao") private double versao;
    @Column(name="dataAprovacao") private Date dataAprovacao;
    @Column(name="justificativa") private String justificativa;
    @Column(name="dataCriacao") private String dataCriacao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public double getVersao()
    {
        return versao;
    }

    public void setVersao(double versao)
    {
        this.versao = versao;
    }

    public Date getDataAprovacao()
    {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao)
    {
        this.dataAprovacao = dataAprovacao;
    }

    public String getJustificativa()
    {
        return justificativa;
    }

    public void setJustificativa(String justificativa)
    {
        this.justificativa = justificativa;
    }

    public String getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }
    
    
}
