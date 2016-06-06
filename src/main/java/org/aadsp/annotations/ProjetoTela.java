package org.aadsp.annotations;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.PaginaModel;
import org.aadsp.annotations.model.ProjetoTelaModel;
import org.aadsp.interfaces.IAnnotations;

@Entity
@Table(name = "ACESSO.ACESSO_AADSP_PAGINA")
public class ProjetoTela implements Serializable, IAnnotations
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
        ProjetoTelaModel model = new ProjetoTelaModel();
        model.atualizar(this);
    }

    public List<ProjetoTela> listar() throws Exception
    {
        ProjetoTelaModel model = new ProjetoTelaModel();
        return model.listar();
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
