
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.ReuniaoAtaModel;

@Entity
@Table(name="PROJETO.PROJETO_AADSP_ATA")
public class ReuniaoAta implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_projeto") private Integer ID_projeto;
    @Column(name="ID_colaborador") private Integer ID_colaborador;
    @Column(name="titulo") private String titulo;
    @Column(name="pauta") private String pauta;
    @Column(name="assuntosTratados") private String assuntosTratados;
    @Column(name="dataCadastro") private Date dataCadastro;
    @Column(name="dataRealizacao") private Date dataRealizacao;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID_projeto() {
        return ID_projeto;
    }

    public void setID_projeto(Integer ID_projeto) {
        this.ID_projeto = ID_projeto;
    }

    public Integer getID_colaborador() {
        return ID_colaborador;
    }

    public void setID_colaborador(Integer ID_colaborador) {
        this.ID_colaborador = ID_colaborador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getAssuntosTratados() {
        return assuntosTratados;
    }

    public void setAssuntosTratados(String assuntosTratados) {
        this.assuntosTratados = assuntosTratados;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    
    public Projeto consultarProjeto()
    {
        Projeto projeto = new Projeto();
        projeto.setID(this.ID_projeto);
        return projeto.consultar();
    }
    
    public List<ReuniaoAta> listar() throws Exception
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        return model.listar();
    }
    
    public List<ReuniaoAta> listarPorProjeto() throws Exception
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        return model.listarPorProjeto(this);
    }
    
    public void cadastrar()
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        model.salvar(this);
    }
    
    public ReuniaoAta consultarPorID() throws Exception
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        return model.consultarPorID(this);
    }
    
    public void editar()
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        model.atualizar(this);
    }
    
    public void excluir()
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        model.excluir(this);
    }
}
