package org.aadsp.controller.named;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.TipoUsuarioCRUD;
import org.aadsp.annotations.crud.UsuarioCRUD;
import org.aadsp.annotations.rn.EnderecoRN;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@ViewScoped
@Named
public class PessoalCadastrar extends ABaseBean
{   
    private Usuario usuario;
    private TipoUsuario tipo;
    private int funcaoSelecionada;
    private Map<String,Integer> funcoes;
    private EnderecoRN endereco;
    private Date data;
    
    
    public PessoalCadastrar()
    {
        this.usuario = new Usuario();
        this.tipo = new TipoUsuario();
        this.funcoes = new HashMap<String, Integer>();
        this.endereco = new EnderecoRN();
        data = new Date(new Date().getTime());
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data) throws ParseException
    {
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        this.usuario.setDataNascimento(dataSql);
    }
    
    public int getFuncaoSelecionada()
    {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(int funcaoSelecionada)
    {
        this.funcaoSelecionada = funcaoSelecionada;
    }
    
    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }
    
    public EnderecoRN getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(EnderecoRN endereco)
    {
        this.endereco = endereco;
    }
    
    public Map<String,Integer> getFuncoes(){
       try{
            TipoUsuarioCRUD crud = new TipoUsuarioCRUD();;
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            List<TipoUsuario> lista = crud.listar();
       for(TipoUsuario obj: lista){
           funcoes.put(obj.getDescricao(),obj.getID());
       }
       return funcoes;
       }catch(Exception e){
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!  ",  "Não foi possível consultar as funções dos usuários no banco de dados!"));
       }
        return null;
    }
    
    public void consultarCep()
    {
       try
       {
        if(this.endereco.consultarEndereco(endereco.getLogradouro()))
        {
            this.usuario.setId_enderecoLogradouro(endereco.getLogradouro().getID());
        }
       }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!  ",  "Não foi possível consultar o CEP no banco de dados!"));
       }
    }
    
    public void cadastrar() throws ParseException
    {
       try{
            UsuarioCRUD crud = new UsuarioCRUD();;
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            this.tipo.setID(funcaoSelecionada);
            this.usuario.setId_usuarioTipo(tipo.getID());
            crud.salvar(usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO," SUCESSO! ",  "O cadastro do usuário foi realizado com sucesso!"));
            usuario = new Usuario();
       }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO! ",  "Não foi possível realizar o cadastro no banco de dados!"));
       }
    }
}
