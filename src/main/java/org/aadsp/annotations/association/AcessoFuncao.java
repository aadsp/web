
package org.aadsp.annotations.association;

import java.util.ArrayList;
import java.util.List;
import org.aadsp.annotations.Acesso;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.model.AcessoModel;

/** Classe que armazena uma função e um acesso
 *
 * @author Felipe
 * @version 25/04/2016
 */
public class AcessoFuncao
{
    private int  ID;
    private Funcao funcao;
    private Pagina pagina;
    
    public AcessoFuncao()
    {
        this.funcao = new Funcao();
        this.pagina = new Pagina();
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    public List<AcessoFuncao> listar() throws Exception
    {
        List<AcessoFuncao> lista = new ArrayList<>();
        AcessoModel acessoModel = new AcessoModel();
        
        for(Acesso obj :acessoModel.listar())
        {
            AcessoFuncao acessoFuncao = new AcessoFuncao();
            acessoFuncao.setID(obj.getID());
            Funcao funcao = new Funcao();
            Pagina pagina = new Pagina();
            funcao.setID(obj.getID_funcao());
            pagina.setID(obj.getID_pagina());
            funcao = funcao.consultarPorID();
            pagina = pagina.consultarPorID();
            acessoFuncao.setFuncao(funcao);
            acessoFuncao.setPagina(pagina);
            lista.add(acessoFuncao);
        }
        return lista;
    }
}
