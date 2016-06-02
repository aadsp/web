package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.DocumentoRequisitosTipoModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "REQUISITOS.REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_TIPO")
public class DocumentoRequisitosTipo implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_documentoRequisitosTipo")
    private Integer ID;
    @Column(name = "nome")
    private String nome;

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

    @Override
    public void cadastrar()
    {
        DocumentoRequisitosTipoModel model = new DocumentoRequisitosTipoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        DocumentoRequisitosTipoModel model = new DocumentoRequisitosTipoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        DocumentoRequisitosTipoModel model = new DocumentoRequisitosTipoModel();
        model.atualizar(this);
    }
    
    public List<DocumentoRequisitosTipo> listar() throws Exception
    {
        DocumentoRequisitosTipoModel model = new DocumentoRequisitosTipoModel();
        return model.listar();
    }

    public DocumentoRequisitosTipo consultarPorID() throws Exception
    {
        DocumentoRequisitosTipoModel model = new DocumentoRequisitosTipoModel();
        return model.consultarPorID(this);
    }

    public List<DocumentoRequisitosTipo> listarPorFiltro(String filtro) throws Exception
    {
        DocumentoRequisitosTipoModel model = new DocumentoRequisitosTipoModel();
        return model.listarPorFiltro(filtro);
    }

}
