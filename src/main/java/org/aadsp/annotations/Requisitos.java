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
    private Date dataCadastro;

    @OneToOne
    @JoinColumn(name = "ID_documentoRequisitos")
    private DocumentoRequisitos documentoRequisitos;

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

    public Date getDataCadastro()
    {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }

    public DocumentoRequisitos getDocumentoRequisitos()
    {
        return documentoRequisitos;
    }

    public void setDocumentoRequisitos(DocumentoRequisitos documentoRequisitos)
    {
        this.documentoRequisitos = documentoRequisitos;
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

    public List<Requisitos> listarPorDocumentoRequisitos() throws Exception
    {
        RequisitosModel model = new RequisitosModel();
        return model.listarPorDocumentoRequisitos(this);
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
