package org.aadsp.controller.named;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.Paginas;
import org.aadsp.annotations.Permissoes;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.AutenticacaoCRUD;
import org.aadsp.annotations.crud.PaginasCRUD;
import org.aadsp.annotations.crud.PermissoesCRUD;
import org.aadsp.annotations.crud.UsuarioCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.HibernateException;


@SessionScoped
@Named
public class Index extends ABaseBean
{   
    
    public Index(){
       autenticacao = new Autenticacao();
       autenticacao.setLogin("");
       autenticacao.setSenha("");
    }

    public Autenticacao getAutenticacao() {
        if(autenticacao == null){
            autenticacao = new Autenticacao();
            autenticacao.setLogin("");
            autenticacao.setSenha("");
        }
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }
    
    public void autenticar() throws IOException
    {
       try{
        AutenticacaoCRUD crud = new AutenticacaoCRUD();;
        crud.setSession(FactoryHibernate.getSessionFactory().openSession());
        Autenticacao copy = new Autenticacao();
        copy = autenticacao;
        autenticacao = crud.autenticar(autenticacao);
        if(autenticacao != null && autenticacao.getLogin() != null && autenticacao.getSenha() != null)
        {
            Usuario usuario = buscarUsuario();
            List<Permissoes> permissoes = buscarPermissoesDeAcesso(usuario);
            List<Paginas> paginas = buscarPaginasDeAcesso(permissoes);
            List<String> paginasPermitidas = paginasPermitidasAcesso(paginas);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("autenticacao", autenticacao);
            session.setAttribute("paginasAcesso",paginasPermitidas);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/aadsp/faces/views/menu/Index.xhtml");
        }
        else
        {
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            autenticacao = crud.validarLogin(copy);
            if(autenticacao != null && autenticacao.getLogin() != null && autenticacao.getSenha() != null)
            {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO," ACESSO NEGADO  ",  "Senha incorreta!"));
            
            }
            else
            {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_WARN," ACESSO NEGADO  ",  "Não foi possível autenticar o usuário com os dados informados!"));
            }
        }
       }
       catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível realizar a autenticação no banco de dados!"));
       }
    }

    private List<String> paginasPermitidasAcesso(List<Paginas> paginas)
    {
        List<String> paginasPermitidas = new ArrayList<>();
        for(Paginas obj: paginas){
            paginasPermitidas.add(obj.getPagina());
        }
        return paginasPermitidas;
    }

    private List<Paginas> buscarPaginasDeAcesso(List<Permissoes> permissoes) throws Exception
    {
        List<Paginas> paginas = new ArrayList<>();
        for(Permissoes obj: permissoes)
        {
            PaginasCRUD paginasCrud = new PaginasCRUD();
            paginasCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
            Paginas pag = new Paginas();
            pag.setID(obj.getID_paginas());
            paginas.add(paginasCrud.consultarPorID(pag));
        }
        return paginas;
    }

    private List<Permissoes> buscarPermissoesDeAcesso(Usuario usuario) throws HibernateException
    {
        PermissoesCRUD permissoesCrud = new PermissoesCRUD();
        permissoesCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
        List<Permissoes> permissoes = new ArrayList<>();
        permissoes = permissoesCrud.listIDPaginasPermissaoUsuario(usuario);
        return permissoes;
    }


    private Usuario buscarUsuario() throws HibernateException, Exception
    {
        UsuarioCRUD usuarioCrud = new UsuarioCRUD();
        usuarioCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
        Usuario usuario = new Usuario();
        usuario.setID(autenticacao.getID_cadastroUsuario());
        usuario = usuarioCrud.consultarPorID(usuario);
        return usuario;
    }
    
    private static final long serialVersionUID = 5585493974059809141L;
    private Autenticacao autenticacao;
}
