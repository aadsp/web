
package org.aadsp.controller.named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Acesso;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Pagina;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Acesso Cadastro
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class AcessoCadastrar extends ABaseNamed
{
    
    public AcessoCadastrar()
    {
      this.acesso = new Acesso();
      this.funcao = new Funcao();
      this.pagina = new Pagina();
      this.funcoes = new HashMap<String, Integer>();
      this.paginas = new HashMap<String, Integer>();
    }
   
    public void cadastrar()
    {
      try
      {
        acesso.setID_funcao(funcaoSelecionada);
        acesso.setID_pagina(paginaSelecionada);
        acesso.cadastrar();
        Mensageiro.mensagemInfo("Cadastro realizado com sucesso!!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar está função à página!!");
      }   
    }
    
  
    public int getFuncaoSelecionada() {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(int funcaoSelecionada) {
        this.funcaoSelecionada = funcaoSelecionada;
    }

    public int getPaginaSelecionada() {
        return paginaSelecionada;
    }

    public void setPaginaSelecionada(int paginaSelecionada) {
        this.paginaSelecionada = paginaSelecionada;
    }
    
    public Map<String,Integer> getFuncoes(){
       try{

            List<Funcao> lista = funcao.listar();
       for(Funcao obj: lista){
           funcoes.put(obj.getDescricao(),obj.getID());
       }
       return funcoes;
       }catch(Exception e){
           Mensageiro.mensagemError("Não foi possível consultar as funções no banco de dados!");
       }
        return null;
    }
    
    public Map<String,Integer> getPaginas(){
       try{

            List<Pagina> lista = pagina.listar();
       for(Pagina obj: lista){
           paginas.put(obj.getNome(),obj.getID());
       }
       return paginas;
       }catch(Exception e){
           Mensageiro.mensagemError("Não foi possível consultar as páginas no banco de dados!");
       }
        return null;
    }
    
    private int funcaoSelecionada;
    private int paginaSelecionada;
    private Funcao funcao;
    private Pagina pagina;
    private Map<String,Integer> funcoes;
    private Map<String,Integer> paginas; 
    private Acesso acesso;
}
