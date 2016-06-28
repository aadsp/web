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
import org.aadsp.annotations.model.ProjetoRecursosAdicionaisModel;
import org.aadsp.framework.IAnnotations;

@Entity
@Table(name = "PROJETO.PROJETO_AADSP_PROJETO_RECUROS_ADICIONAIS")
public class ProjetoRecursosAdicionais implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_recursosAdicionais")
    private Integer ID;
    @Column(name = "descricao", length = 300)
    private String descricao;
    @Column(name = "dataCadastro")
    private Date dataCadastro;
    @Column(name = "valor", precision = 2)
    private double valor;

    @OneToOne
    @JoinColumn(name = "ID_projeto")
    private Projeto projeto;

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

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    @Override
    public void cadastrar()
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        model.atualizar(this);
    }

    public List<ProjetoRecursosAdicionais> listar() throws Exception
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        return model.listar();
    }
    
    public List<ProjetoRecursosAdicionais> listarPorProjeto() throws Exception
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        return model.listarPorProjeto(this);
    }
    public ProjetoRecursosAdicionais consultarPorID() throws Exception
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        return model.consultarPorID(this);
    }

    public List<ProjetoRecursosAdicionais> listarPorFiltro(String filtro) throws Exception
    {
        ProjetoRecursosAdicionaisModel model = new ProjetoRecursosAdicionaisModel();
        return model.listarPorFiltro(filtro);
    }

}
