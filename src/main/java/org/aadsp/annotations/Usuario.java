
package org.aadsp.annotations;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.aadsp.annotations.model.AcessoModel;
import org.aadsp.annotations.model.FuncaoModel;
import org.aadsp.annotations.model.UsuarioModel;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;

@Entity
@Table(name="ACESSO.ACESSO_AADSP_USUARIO")
public class Usuario implements Serializable,IUsuario
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nome") private String nome;
    @Column(name="dataNascimento") private Date dataNascimento;
    @Column(name="ID_funcao") private Integer id_funcao;
    @Column(name="cpf") private String cpf;
    @Column(name="rg") private String rg;
    @Column(name="email") private String email;
    @Column(name="login") private String login;
    @Column(name="senha") private String senha;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(Integer id_usuarioTipo) {
        this.id_funcao = id_usuarioTipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   @Override
   public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) 
    {
        try {
            this.senha = Criptografia.codificarParaSSH(senha);
        } catch (NoSuchAlgorithmException ex) {
            Mensageiro.mensagemError("Não foi encontrado o algoritmo de criptografia!!");
        } catch (UnsupportedEncodingException ex) {
            Mensageiro.mensagemError("Não foi suportada a codificação de criptografia!!");
        }
    }

    @Override
    public Usuario autenticar() 
    {
        UsuarioModel modelo = new UsuarioModel();
        return modelo.autenticar(this);
    }

    @Override
    public Usuario validarLogin() 
    {
       UsuarioModel modelo = new UsuarioModel();
       return modelo.validarLogin(this);
    }

    @Override
    public List<String> paginasAcesso() throws Exception
    {
        List<String> lista = new ArrayList<>();
        Acesso obj = new Acesso();
        obj.setID_funcao(this.id_funcao);
        AcessoModel acessoModel = new AcessoModel();
        List<Acesso> listaAcesso = acessoModel.listar(obj);
        List<String> paginas = new ArrayList<>();
        
        for(Acesso acesso: listaAcesso){
            Pagina pagina = new Pagina();
            pagina.setID(acesso.getID_pagina());
            paginas.add(pagina.consultarNomePagina(pagina));
        }
        return paginas;
       
    }

    @Override
    public String consultarFuncao() throws  Exception
    {
        FuncaoModel model = new FuncaoModel();
        Funcao obj = new Funcao();
        obj.setID(this.id_funcao);
        obj = model.consultarPorID(obj);
        return obj.getDescricao();
    }
    
    @Override
    public List<Usuario> listar() throws  Exception
    {
        UsuarioModel model = new UsuarioModel();
        return model.listar();
    }
    
    public void cadastrar()throws Exception
    {
        UsuarioModel model = new UsuarioModel();
        model.salvar(this);
    }
    
    public void editar(){
        UsuarioModel model = new UsuarioModel();
        model.atualizar(this);
    }
    
    public void excluir()
    {
        UsuarioModel model = new UsuarioModel();
        model.excluir(this);
    }
    
    public Usuario consultar() throws Exception
    {
        UsuarioModel model = new UsuarioModel();
        return model.consultarPorID(this);
    }
    
    public Usuario consultarPorEmail() throws Exception{
        UsuarioModel model = new UsuarioModel();
        return model.consultarPorEmail(this);
    }
    
}
