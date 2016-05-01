
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
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal detalhamento
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class PessoalEditar extends ABaseNamed
{   
    public PessoalEditar()
    {
        data = new Date(new Date().getTime());
        this.funcoes = new HashMap<String, Integer>();
        this.funcao = new Funcao();
        this.usuario = new Usuario();
        carregarDadosIniciais();
    }
    
    public void carregarDadosIniciais()
    {
        try
        {
         int IDPessoal = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Pessoal")));
         this.usuario.setID(IDPessoal);
         this.usuario = usuario.consultar();
         this.data = usuario.getDataNascimento();
        }catch(Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados do usuário!!");
        }
    }
    
    
    public void editar()
    {
      try
      {
        this.usuario.setId_funcao(funcaoSelecionada);
        this.usuario.editar();
        Mensageiro.mensagemInfo("Dados do usuário foram atualizados com sucesso!!");
      }catch(Exception e){
          Mensageiro.mensagemError("Não foi possível realizar a atualização dos dados deste usuário!!");
      }
    }
    
    public void excluir()
    {
      try
      {
        this.usuario.excluir();
        Response.redirect("/web/faces/views/adm/PessoalConsultar.xhtml");
      }catch(Exception e){
          Mensageiro.mensagemError("Não foi possível realizar a exclusão do usuário!!");
      }
    }
    
    public void alterarSenha()
    {
       try
       {
        Response.redirect("/web/faces/views/adm/PessoalAterarSenha.xhtml?Pessoal="+ Criptografia.codificarParaBase64(usuario.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar usuário!!");
       }
    }
    
    public Map<String,Integer> getFuncoes(){
       try{

            List<Funcao> lista = funcao.listar();
       for(Funcao obj: lista){
           if(!obj.getID().equals(usuario.getId_funcao()))
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
