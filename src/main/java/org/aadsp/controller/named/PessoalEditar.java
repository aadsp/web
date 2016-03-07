package org.aadsp.controller.named;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.annotations.Logradouro;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.LogradouroCRUD;
import org.aadsp.annotations.crud.TipoUsuarioCRUD;
import org.aadsp.annotations.crud.UsuarioCRUD;
import org.aadsp.annotations.rn.EnderecoRN;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@ManagedBean
@ViewScoped
public class PessoalEditar extends ABaseBean
{   
    private Usuario usuario;
    private EnderecoRN endereco;
    private Logradouro logradouro;
    private Date data;
    private TipoUsuario tipo;
    private int funcaoSelecionada;
    TipoUsuario funcaoAtual;
    private Map<String,Integer> funcoes;
    
    public PessoalEditar(){
        this.inicializar();
    }
    
    @PostConstruct
    public void inicializar() {
     try{
        funcoes = new HashMap<String, Integer>();
        logradouro = new Logradouro();
        endereco = new EnderecoRN();
        funcaoAtual = new TipoUsuario();
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("usuario");
        data = usuario.getDataNascimento();
        LogradouroCRUD crud = new LogradouroCRUD();
        crud.setSession(FactoryHibernate.getSessionFactory().openSession());
        TipoUsuarioCRUD funcaoAtualCrud = new TipoUsuarioCRUD();;
        funcaoAtualCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
        logradouro.setID(usuario.getId_enderecoLogradouro());
        logradouro = crud.consultarPorID(logradouro);
        endereco.setLogradouro(logradouro);
        if(this.endereco.consultarEndereco(endereco.getLogradouro()))
        {
            this.usuario.setId_enderecoLogradouro(endereco.getLogradouro().getID());
        }
        data = usuario.getDataNascimento(); 
        funcaoAtual = new TipoUsuario();
        funcaoAtual.setID(usuario.getId_usuarioTipo());
        funcaoAtual = funcaoAtualCrud.consultarPorID(funcaoAtual);
     }catch(Exception e){
         FacesContext context = FacesContext.getCurrentInstance();
         context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!  ",  "Não foi possível consultar as informações do usuário!"));
     }
    }

    public int getFuncaoSelecionada() {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(int funcaoSelecionada) {
        this.funcaoSelecionada = funcaoSelecionada;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    public EnderecoRN getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(EnderecoRN endereco)
    {
        this.endereco = endereco;
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

    public TipoUsuario getFuncaoAtual() {
        return funcaoAtual;
    }

    public void setFuncaoAtual(TipoUsuario funcaoAtual) {
        this.funcaoAtual = funcaoAtual;
    }
    
    
    
    public void editar() throws ParseException
    {
       try{
            UsuarioCRUD crud = new UsuarioCRUD();;
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            if(funcaoSelecionada == 0)
                funcaoSelecionada = usuario.getId_usuarioTipo();
            tipo = new TipoUsuario();
            this.tipo.setID(funcaoSelecionada);
            this.usuario.setId_usuarioTipo(tipo.getID());
            crud.atualizar(usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO," SUCESSO! ",  "O cadastro do usuário foi atualizado com sucesso!"));
            usuario = new Usuario();
       }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO! ",  "Não foi possível atualizar o cadastro do usuário!"));
       }
    }
    
    
}
