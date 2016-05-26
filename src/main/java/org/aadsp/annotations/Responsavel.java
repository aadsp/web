package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.aadsp.annotations.model.ResponsavelModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "TAP.TAP_AADSP_RESPONSAVEL")
public class Responsavel implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_responsavel")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_usuario")
    private Usuario usuario;
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

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public TAP getTap()
    {
        return tap;
    }

    public void setTap(TAP tap)
    {
        this.tap = tap;
    }

    public List<Responsavel> listarPorIDTAP() throws Exception
    {
        ResponsavelModel model = new ResponsavelModel();
        return model.listarPorIDTap(this);
    }

    @Override
    public void cadastrar()
    {
        ResponsavelModel model = new ResponsavelModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        ResponsavelModel model = new ResponsavelModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        ResponsavelModel model = new ResponsavelModel();
        model.atualizar(this);
    }

    public Responsavel consultar() throws Exception
    {
        ResponsavelModel model = new ResponsavelModel();
        return model.consultar(this);
    }

    public Responsavel consultarReposanvelPorIDUsuario() throws Exception
    {
        ResponsavelModel model = new ResponsavelModel();
        return model.consultarPorIDTapIDUsuario(this);
    }

}
