package annotations.requisitos;

import annotations.requisitos.DocumentoRequisitos;
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
import model.requisitos.RequisitosHistoriaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "REQUISITOS.REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_HISTORIA_DE_USUARIO")
public class RequisitosHistoria implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_requisitoHistoria")
    private Integer ID;
    @Column(name = "acao", length = 800)
    private String acao;
    @Column(name = "funcionalidade", length = 1000)
    private String funcionalidade;
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

    public String getAcao()
    {
        return acao;
    }

    public void setAcao(String acao)
    {
        this.acao = acao;
    }

    public String getFuncionalidade()
    {
        return funcionalidade;
    }

    public void setFuncionalidade(String funcionalidade)
    {
        this.funcionalidade = funcionalidade;
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
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        model.atualizar(this);
    }

    public List<RequisitosHistoria> listar() throws Exception
    {
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        return model.listar();
    }

    public List<RequisitosHistoria> listarPorDocumentoRequisitos() throws Exception
    {
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        return model.listarPorDocumentoRequisitos(this);
    }

    public RequisitosHistoria consultarPorID() throws Exception
    {
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        return model.consultarPorID(this);
    }

    public List<RequisitosHistoria> listarPorFiltro(String filtro) throws Exception
    {
        RequisitosHistoriaModel model = new RequisitosHistoriaModel();
        return model.listarPorFiltro(filtro);
    }

}
