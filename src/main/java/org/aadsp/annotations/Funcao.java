package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.FuncaoModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "ACESSO.ACESSO_AADSP_FUNCAO")
public class Funcao implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_funcao")
    private Integer ID;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "descricao")
    private String descricao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getSigla()
    {
        return sigla;
    }

    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    @Override
    public void cadastrar()
    {
        FuncaoModel model = new FuncaoModel();
        model.salvar(this);
    }

    @Override
    public void editar()
    {
        FuncaoModel model = new FuncaoModel();
        model.atualizar(this);
    }

    @Override
    public void excluir()
    {
        FuncaoModel model = new FuncaoModel();
        model.excluir(this);
    }

    public List<Funcao> listar() throws Exception
    {
        FuncaoModel model = new FuncaoModel();
        return model.listar();
    }

    public Funcao consultarPorID() throws Exception
    {
        FuncaoModel model = new FuncaoModel();
        return model.consultarPorID(this);
    }

    public List<Funcao> listarPorFiltro(String filtro) throws Exception
    {
        FuncaoModel model = new FuncaoModel();
        return model.listarPorFiltro(filtro);
    }
}
