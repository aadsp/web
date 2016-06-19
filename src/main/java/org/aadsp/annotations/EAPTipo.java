package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.EAPTipoModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_DIAGRAMA_EAP_TIPO")
public class EAPTipo implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_eapTipo")
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
        EAPTipoModel model = new EAPTipoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        EAPTipoModel model = new EAPTipoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        EAPTipoModel model = new EAPTipoModel();
        model.atualizar(this);
    }

    public String consultarNomeTipo(EAPTipo eapTippo)
    {
        EAPTipoModel model = new EAPTipoModel();
        return model.consultarPorID(eapTippo).descricao;
    }

    public List<EAPTipo> listar() throws Exception
    {
        EAPTipoModel model = new EAPTipoModel();
        return model.listar();
    }
    
    public EAPTipo consultarPorID() throws Exception
    {
        EAPTipoModel model = new EAPTipoModel();
        return model.consultarPorID(this);
    }

    public List<EAPTipo> listarPorFiltro(String filtro) throws Exception
    {
        EAPTipoModel model = new EAPTipoModel();
        return model.listarPorFiltro(filtro);
    }

}
