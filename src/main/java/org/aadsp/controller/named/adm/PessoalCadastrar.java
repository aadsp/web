
package org.aadsp.controller.named.adm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Cadastro
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class PessoalCadastrar extends ABaseNamed implements ICadastro
{   
    public PessoalCadastrar()
    {
        data = new Date(new Date().getTime());
        this.funcoes = new HashMap<String, Integer>();
        this.funcao = new Funcao();
        this.usuario = new Usuario();
    }
    
    public boolean controleDeCadastro()
    {
        return this.usuario.getNome() != null;
    }
   
    public void cadastrar()
    {
      try
      {
        Funcao funcao = new Funcao();
        funcao.setID(funcaoSelecionada);
        this.usuario.setFuncao(funcao);
        this.usuario.cadastrar();
        Mensageiro.mensagemInfo("Cadastro realizado com sucesso!!");
      }catch(Exception e){
          Mensageiro.mensagemError("Não foi possível realizar o cadastro deste usuário!!");
      }
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
    
     public Date getData()
     {
        return data;
     }
    
    public void setData(Date date) throws ParseException
    {
       java.sql.Date dataSql = new java.sql.Date(date.getTime());
       this.usuario.setDataNascimento(dataSql);
    }
    
    public int getFuncaoSelecionada() {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(int funcaoSelecionada) {
        this.funcaoSelecionada = funcaoSelecionada;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
    private Map<String,Integer> funcoes;
    private int funcaoSelecionada;
    private Funcao funcao;
    private Usuario usuario;
    private Date data;
}
