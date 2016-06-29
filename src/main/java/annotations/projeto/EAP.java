package annotations.projeto;

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
import model.projeto.EAPModel;
import model.acesso.PaginaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_DIAGRAMA_EAP")
public class EAP implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_eap")
    private Integer ID;
    
    @OneToOne
    @JoinColumn(name = "ID_eapTipo")
    private EAPTipo eapTipo;
    
    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;
    
    @Column(name = "dataCadastro")
    private Date dataCriacao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public EAPTipo getEapTipo()
    {
        return eapTipo;
    }

    public void setEapTipo(EAPTipo eapTipo)
    {
        this.eapTipo = eapTipo;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public Date getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
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

    public List<EAP> listar() throws Exception
    {
        EAPModel model = new EAPModel();
        return model.listar();
    }
    
    public List<EAP> listarPorProjeto() throws Exception
    {
        EAPModel model = new EAPModel();
        return model.listarPorProjeto(this);
    }
    
    public EAP consultarPorID() throws Exception
    {
        EAPModel model = new EAPModel();
        return model.consultarPorID(this);
    }

    public List<EAP> listarPorFiltro(String filtro) throws Exception
    {
        EAPModel model = new EAPModel();
        return model.listarPorFiltro(filtro);
    }

}
