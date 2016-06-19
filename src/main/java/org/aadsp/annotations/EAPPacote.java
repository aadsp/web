package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.EAPPacoteModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_DIAGRAMA_EAP_PACOTE")
public class EAPPacote implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_eapPacote")
    private Integer ID;
    @Column(name = "descricao", length = 60)
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
        EAPPacoteModel model = new EAPPacoteModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        EAPPacoteModel model = new EAPPacoteModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        EAPPacoteModel model = new EAPPacoteModel();
        model.atualizar(this);
    }

    public String consultarNomeEAP(EAPPacote eapPacote)
    {
        EAPPacoteModel model = new EAPPacoteModel();
        return model.consultarPorID(eapPacote).descricao;
    }

    public List<EAPPacote> listar() throws Exception
    {
        EAPPacoteModel model = new EAPPacoteModel();
        return model.listar();
    }

    public EAPPacote consultarPorID() throws Exception
    {
        EAPPacoteModel model = new EAPPacoteModel();
        return model.consultarPorID(this);
    }

    public List<EAPPacote> listarPorFiltro(String filtro) throws Exception
    {
        EAPPacoteModel model = new EAPPacoteModel();
        return model.listarPorFiltro(filtro);
    }

}
