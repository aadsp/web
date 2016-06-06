package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.PaginaModel;
import org.aadsp.annotations.model.RequisitosModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "REQUISITOS.REQUISITOS_AADSP_REQUISITO")
public class Requisitos implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_requisito")
    private Integer ID;
    @Column(name = "descricao", length = 150)
    private String descricao;
    @Column(name = "dataCadastro")
    private String dataCadastro;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDataCadastro()
    {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public void cadastrar()
    {
        RequisitosModel model = new RequisitosModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        RequisitosModel model = new RequisitosModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        RequisitosModel model = new RequisitosModel();
        model.atualizar(this);
    }

    public List<Requisitos> listar() throws Exception
    {
        RequisitosModel model = new RequisitosModel();
        return model.listar();
    }

    public Requisitos consultarPorID() throws Exception
    {
        RequisitosModel model = new RequisitosModel();
        return model.consultarPorID(this);
    }

    public List<Requisitos> listarPorFiltro(String filtro) throws Exception
    {
        RequisitosModel model = new RequisitosModel();
        return model.listarPorFiltro(filtro);
    }

}
