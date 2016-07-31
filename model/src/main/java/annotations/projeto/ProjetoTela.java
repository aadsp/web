package annotations.projeto;

import annotations.requisitos.RequisitosHistoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.projeto.ProjetoTelaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.TELAS")
public class ProjetoTela implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_projetoTelas")
    private Integer ID;
    @Column(name = "imagem", length = 60)
    private String imagem;
    @Column(name = "descricao", length = 800)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;

    @OneToOne
    @JoinColumn(name = "ID_requisito")
    private RequisitosHistoria requisitos;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getImagem()
    {
        return imagem;
    }

    public void setImagem(String imagem)
    {
        this.imagem = imagem;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public RequisitosHistoria getRequisitos()
    {
        return requisitos;
    }

    public void setRequisitos(RequisitosHistoria requisitos)
    {
        this.requisitos = requisitos;
    }

    @Override
    public void cadastrar()
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        model.atualizar(this);
    }

    public List<ProjetoTela> listar() throws Exception
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        return model.listar();
    }
    
    public List<ProjetoTela> listarPorProjeto() throws Exception
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        return model.listarPorProjeto(this);
    }        
            
    public ProjetoTela consultarPorID() throws Exception
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        return model.consultarPorID(this);
    }

    public List<ProjetoTela> listarPorFiltro(String filtro) throws Exception
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        return model.listarPorFiltro(filtro);
    }

}
