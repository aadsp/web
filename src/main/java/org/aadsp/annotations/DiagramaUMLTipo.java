package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.DiagramaUMLTipoModel;
import org.aadsp.framework.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_DIAGRAMA_UML_TIPO")
public class DiagramaUMLTipo implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_diagramaUMLTipo")
    private Integer ID;
    @Column(name = "descricao",length = 100)
    private String descricao;

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

    @Override
    public void cadastrar()
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        model.atualizar(this);
    }

    public String consultarNomePagina(DiagramaUMLTipo diagramaUMLTipo)
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        return model.consultarPorID(this).descricao;
    }

    public List<DiagramaUMLTipo> listar() throws Exception
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        return model.listar();
    }

    public DiagramaUMLTipo consultarPorID() throws Exception
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        return model.consultarPorID(this);
    }

    public List<DiagramaUMLTipo> listarPorFiltro(String filtro) throws Exception
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        return model.listarPorFiltro(filtro);
    }

}
