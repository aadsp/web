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
import org.aadsp.annotations.model.ColaboradorModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "COLABORADOR.COLABORADOR_AADSP_COLABORADOR")
public class Colaborador implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_colaborador")
    private Integer ID;
    @Column(name = "numeroPIS",length = 60)
    private String numeroPIS;
    @Column(name = "dataContrato")
    private Date dataContrato;
    @Column(name = "valorBruto",scale = 2)
    private double valorBruto;

    @OneToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public String getNumeroPIS()
    {
        return numeroPIS;
    }

    public void setNumeroPIS(String numeroPIS)
    {
        this.numeroPIS = numeroPIS;
    }

    public Date getDataContrato()
    {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato)
    {
        this.dataContrato = dataContrato;
    }

    public double getValorBruto()
    {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto)
    {
        this.valorBruto = valorBruto;
    }

    @Override
    public void cadastrar()
    {
        ColaboradorModel model = new ColaboradorModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        ColaboradorModel model = new ColaboradorModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        ColaboradorModel model = new ColaboradorModel();
        model.atualizar(this);
    }

    public String consultarNomeColaborador() throws Exception
    {
        Usuario model = new Usuario();
        model.setID(this.usuario.getID());
        return model.consultar().getNome();
    }

    public String consultarFuncaoColaborador() throws Exception
    {
        Usuario modelUsuario = new Usuario();
        modelUsuario.setID(this.usuario.getID());
        modelUsuario = modelUsuario.consultar();
        Funcao model = new Funcao();
        model.setID(modelUsuario.getFuncao().getID());
        return model.consultarPorID().getDescricao();
    }

    public Colaborador consultar() throws Exception
    {
        ColaboradorModel model = new ColaboradorModel();
        return model.consultarPorID(this);
    }

    public List<Colaborador> listar() throws Exception
    {
        ColaboradorModel model = new ColaboradorModel();
        return model.listar();
    }

    public List<Colaborador> listarPorFiltro(String filtro) throws Exception
    {
        ColaboradorModel model = new ColaboradorModel();
        return model.listarPorFiltro(filtro);
    }
}
