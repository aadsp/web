package annotations.projeto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.projeto.DiagramaUMLModel;
import model.acesso.PaginaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_DIAGRAMA_UML")
public class DiagramaUML implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_diagramaUML")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;
    @OneToOne
    @JoinColumn(name = "ID_diagramaUMLTipo")
    private DiagramaUMLTipo diagramaUMLTipo;
    @Column(name="imagem",length = 100)
    private String imagem;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public DiagramaUMLTipo getDiagramaUMLTipo()
    {
        return diagramaUMLTipo;
    }

    public void setDiagramaUMLTipo(DiagramaUMLTipo diagramaUMLTipo)
    {
        this.diagramaUMLTipo = diagramaUMLTipo;
    }

    public String getImagem()
    {
        return imagem;
    }

    public void setImagem(String imagem)
    {
        this.imagem = imagem;
    }

    @Override
    public void cadastrar()
    {
        PaginaModel model = new PaginaModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        PaginaModel model = new PaginaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        PaginaModel model = new PaginaModel();
        model.atualizar(this);
    }

    public List<DiagramaUML> listar() throws Exception
    {
        DiagramaUMLModel model = new DiagramaUMLModel();
        return model.listar();
    }
    
    public List<DiagramaUML> listarPorIDProjeto() throws Exception
    {
        DiagramaUMLModel model = new DiagramaUMLModel();
        return model.listarPorIDProjeto(this);
    }

}
