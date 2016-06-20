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
import org.aadsp.annotations.model.EAPAtividadeModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE")
public class EAPAtividade implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_eapAtividade")
    private Integer ID;

    @OneToOne
    @JoinColumn(name = "ID_eap")
    private EAP eap;

    @OneToOne
    @JoinColumn(name = "ID_eapPacote")
    private EAPPacote eapPacote;

    @Column(name = "descricao", length = 255)
    private String descricao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public EAP getEap()
    {
        return eap;
    }

    public void setEap(EAP eap)
    {
        this.eap = eap;
    }

    public EAPPacote getEapPacote()
    {
        return eapPacote;
    }

    public void setEapPacote(EAPPacote eapPacote)
    {
        this.eapPacote = eapPacote;
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
        EAPAtividadeModel model = new EAPAtividadeModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        EAPAtividadeModel model = new EAPAtividadeModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        EAPAtividadeModel model = new EAPAtividadeModel();
        model.atualizar(this);
    }

    public List<EAPAtividade> listar() throws Exception
    {
        EAPAtividadeModel model = new EAPAtividadeModel();
        return model.listar();
    }
    
    public List<EAPAtividade> listarPorEAP() throws Exception
    {
        EAPAtividadeModel model = new EAPAtividadeModel();
        return model.listarPorEAP(this);
    }

    public EAPAtividade consultarPorID() throws Exception
    {
        EAPAtividadeModel model = new EAPAtividadeModel();
        return model.consultarPorID(this);
    }

    public List<EAPAtividade> listarPorFiltro(String filtro) throws Exception
    {
        EAPAtividadeModel model = new EAPAtividadeModel();
        return model.listarPorFiltro(filtro);
    }

}
