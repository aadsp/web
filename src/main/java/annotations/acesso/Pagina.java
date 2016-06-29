package annotations.acesso;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import model.acesso.PaginaModel;
import interfaces.IAnnotations;

@Entity
@Table(name = "ACESSO.ACESSO_AADSP_PAGINA")
public class Pagina implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_pagina")
    private Integer ID;
    @Column(name = "nome",length = 60)
    private String nome;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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

    public String consultarNomePagina(Pagina pagina)
    {
        PaginaModel model = new PaginaModel();
        return model.consultarPorID(pagina).nome;
    }

    public List<Pagina> listar() throws Exception
    {
        PaginaModel model = new PaginaModel();
        return model.listar();
    }

    public Pagina consultarPorID() throws Exception
    {
        PaginaModel model = new PaginaModel();
        return model.consultarPorID(this);
    }

    public List<Pagina> listarPorFiltro(String filtro) throws Exception
    {
        PaginaModel model = new PaginaModel();
        return model.listarPorFiltro(filtro);
    }

}
