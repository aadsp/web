package annotations.acesso;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.acesso.AcessoModel;
import model.projeto.DiagramaUMLTipoModel;
import interfaces.IAnnotations;

/**
 *
 * @author Felipe Coelho
 * @version 24/04/2016
 */
@Entity
@Table(name = "ACESSO.ACESSO_AADSP_ACESSO")
public class Acesso implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_acesso")
    private Integer ID;
    @OneToOne
    @JoinColumn(name = "ID_funcao")
    private Funcao funcao;
    @OneToOne
    @JoinColumn(name = "ID_pagina")
    private Pagina pagina;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Funcao getFuncao()
    {
        return funcao;
    }

    public void setFuncao(Funcao funcao)
    {
        this.funcao = funcao;
    }

    public Pagina getPagina()
    {
        return pagina;
    }

    public void setPagina(Pagina pagina)
    {
        this.pagina = pagina;
    }

    @Override
    public void cadastrar()
    {
        AcessoModel model = new AcessoModel();
        model.salvar(this);
    }

    @Override
    public void excluir()
    {
        AcessoModel model = new AcessoModel();
        model.excluir(this);
    }

    @Override
    public void editar()
    {
        DiagramaUMLTipoModel model = new DiagramaUMLTipoModel();
        model.atualizar(this);
    }

    public Acesso consultar() throws Exception
    {
        AcessoModel model = new AcessoModel();
        return model.consultar(this);
    }

    public String consultarFuncao() throws Exception
    {
        Funcao funcao = new Funcao();
        funcao.setID(this.getFuncao().getID());
        funcao = funcao.consultarPorID();
        return funcao.getDescricao();
    }

    public String consultarPagina() throws Exception
    {
        Pagina pagina = new Pagina();
        pagina.setID(this.getPagina().getID());
        pagina = pagina.consultarPorID();
        return pagina.getNome();
    }

    public List<Acesso> listarPorFuncao() throws Exception
    {
        AcessoModel model = new AcessoModel();
        return model.listar(this);
    }

    public boolean registrada() throws Exception
    {
        AcessoModel model = new AcessoModel();
        return model.registrada(this) != null;
    }

    public List<Acesso> listar() throws Exception
    {
        AcessoModel model = new AcessoModel();
        return model.listar();
    }

    public List<Acesso> listarPorFiltro(String filtro) throws Exception
    {
        AcessoModel model = new AcessoModel();
        return model.listarPorFiltro(filtro);
    }
}
