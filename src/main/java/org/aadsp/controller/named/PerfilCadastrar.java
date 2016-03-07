package org.aadsp.controller.named;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.annotations.Paginas;
import org.aadsp.annotations.Permissoes;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.crud.PaginasCRUD;
import org.aadsp.annotations.crud.PermissoesCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@ViewScoped
@Named
public class PerfilCadastrar extends ABaseBean
{   
    private Permissoes permissoesAcesso;
    private TipoUsuario tipoUsuario;
    private List<Permissoes> permissoes;
    private List<Paginas> paginas;
    
    public PerfilCadastrar()
    {
        this.paginas = new ArrayList<>();
        this.permissoes = new ArrayList<>();
        this.permissoesAcesso = new Permissoes();
        this.tipoUsuario = new TipoUsuario();
        tipoUsuario = (TipoUsuario) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("tipoUsuario");
    }
    
    public List<Paginas> getPaginas() throws Exception
    {
        PaginasCRUD crud = new PaginasCRUD();
        crud.setSession(FactoryHibernate.getSessionFactory().openSession());
        paginas = crud.listar();
        
        for(Permissoes per: permissoes)
        {
            for(Paginas pag: paginas)
            {
                if(per.getID_paginas() == pag.getID())
                    paginas.remove(pag);
                
            }
        }
        return paginas;
    }
    
    public List<Paginas> getPemissoesDePaginasCadastradas()
    {
        try 
        {
            PermissoesCRUD crud = new PermissoesCRUD();
            PaginasCRUD pagCrud = new PaginasCRUD();
            pagCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            permissoes = crud.listarPorTipoUsuario(tipoUsuario);
            List<Paginas> listPagPermissoes = new ArrayList<>();
            for(Permissoes obj: permissoes)
            {
                Paginas pag = new Paginas();
                pag.setID(obj.getID_paginas());
                listPagPermissoes.add(pagCrud.consultarPorID(pag));
            }
            return listPagPermissoes;
        } 
        catch (Exception ex) 
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível buscar a lista de Permissões no banco de dados!"));
        }
        return null;
    }
    
    public void adicionar(Paginas pagina)
    {
        try
        {
            PermissoesCRUD crud = new PermissoesCRUD();
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            Permissoes permissao = new Permissoes();
            permissao.setID_paginas(pagina.getID());
            permissao.setID_usuarioTipo(tipoUsuario.getID());
            crud.salvar(permissao);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO," SUCESSO!!  ",  "Página adicionada ao Perfil!"));
        }
        catch(Exception e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível buscar a lista de Permissões no banco de dados!"));
        }
    
    }
    
    public void excluir(Permissoes permissaoAcesso){
    
    }

    public TipoUsuario getTipoUsuario()
    {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario)
    {
        this.tipoUsuario = tipoUsuario;
    }

    public Permissoes getPermissoesAcesso()
    {
        return permissoesAcesso;
    }

    public void setPermissoesAcesso(Permissoes permissoesAcesso)
    {
        this.permissoesAcesso = permissoesAcesso;
    }
    
}
