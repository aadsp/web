
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.aadsp.annotations.model.ReuniaoAtaModel;

@Entity
@Table(name="PROJETO.PROJETO_AADSP_ATA")
public class ReuniaoAta implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID_ata") private Integer ID;
    @Column(name="titulo") private String titulo;
    @Column(name="pauta") private String pauta;
    @Column(name="assuntosTratados") private String assuntosTratados;
    @Column(name="dataCadastro") private Date dataCadastro;
    @Column(name="dataRealizacao") private Date dataRealizacao;
    
    @OneToOne
    @JoinColumn(name="ID_projeto") private Projeto projeto;
    @OneToOne
    @JoinColumn(name="ID_colaborador") private Colaborador colaborador;
    

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    
    public Projeto consultarProjeto()
    {
        Projeto projeto = new Projeto();
        projeto.setID(this.projeto.getID());
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
    
    public List<ReuniaoAta> listarPorFiltro(String filtro) throws Exception
    {
        ReuniaoAtaModel model = new ReuniaoAtaModel();
        return model.listarPorFiltro(filtro);
    }
}
