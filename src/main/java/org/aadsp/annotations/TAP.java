
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.TAPModel;

/**
 * Classe que representa a tabela do banco 
 * @author Felipe
 */
@Entity
@Table(name="TAP.TAP_AADSP_TAP")
public class TAP implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nome") private String nome;
    @Column(name="justificativa") private String justificativa;
    @Column(name="objetivo") private String objetivo;
    @Column(name="alinhamentoEstrategico") private String alinhamentoEstrategico;
    @Column(name="custo") private double custo;
    @Column(name="dataInicio") private Date dataInicio;
    @Column(name="dataFim") private Date dataFim;
    @Column(name="dataHomologacao") private Date dataHomologacao;
    @Column(name="dataCriacao") private Date dataCriacao;
    @Column(name="premissas") private String premissas;
    @Column(name="restricoes") private String restricoes;
    @Column(name="riscosIniciais") private String riscosIniciais;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getAlinhamentoEstrategico() {
        return alinhamentoEstrategico;
    }

    public void setAlinhamentoEstrategico(String alinhamentoEstrategico) {
        this.alinhamentoEstrategico = alinhamentoEstrategico;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataHomologacao() {
        return dataHomologacao;
    }

    public void setDataHomologacao(Date dataHomologacao) {
        this.dataHomologacao = dataHomologacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getPremissas() {
        return premissas;
    }

    public void setPremissas(String premissas) {
        this.premissas = premissas;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }

    public String getRiscosIniciais() {
        return riscosIniciais;
    }

    public void setRiscosIniciais(String riscosIniciais) {
        this.riscosIniciais = riscosIniciais;
    }
    
    public List<TAP> listar() throws Exception
    {
        TAPModel  model = new TAPModel();
        return model.listar();
    }
    
    public void cadastrar()
    {
        TAPModel model = new TAPModel();
        model.salvar(this);
    }
    
    public void deletar()
    {
        TAPModel model = new TAPModel();
        model.excluir(this);
    }
    
    public void atualizar()
    {
        TAPModel model = new TAPModel();
        model.atualizar(this);
    }
}
