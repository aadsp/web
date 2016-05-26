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
import org.aadsp.annotations.model.ProjetoModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_PROJETO")
public class Projeto implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_projeto")
    private Integer ID;

    @Column(name = "dataInicio")
    private Date dataInicio;
    @Column(name = "dataTermino")
    private Date dataTermino;
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    @Column(name = "investimento")
    private double investimento;

    @OneToOne
    @JoinColumn(name = "ID_tap")
    private TAP tap;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Date getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio)
    {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino()
    {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino)
    {
        this.dataTermino = dataTermino;
    }

    public Date getDataCadastro()
    {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }

    public double getInvestimento()
    {
        return investimento;
    }

    public void setInvestimento(double investimento)
    {
        this.investimento = investimento;
    }

    public TAP getTap()
    {
        return tap;
    }

    public void setTap(TAP tap)
    {
        this.tap = tap;
    }

    @Override
    public void cadastrar()
    {
        ProjetoModel model = new ProjetoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        ProjetoModel model = new ProjetoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        ProjetoModel model = new ProjetoModel();
        model.atualizar(this);
    }

    public Projeto consultar()
    {
        ProjetoModel model = new ProjetoModel();
        return model.consultarPorID(this);
    }

    public List<Projeto> listar() throws Exception
    {
        ProjetoModel model = new ProjetoModel();
        return model.listar();
    }

    public Projeto consultarPorID()
    {
        ProjetoModel model = new ProjetoModel();
        return model.consultarPorID(this);
    }

    public List<Projeto> listarPorFiltro(String filtro) throws Exception
    {
        ProjetoModel model = new ProjetoModel();
        return model.listarPorFiltro(filtro);
    }
}
