
package org.aadsp.controller.named;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.TipoUsuarioCRUD;
import org.aadsp.annotations.crud.UsuarioCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@SessionScoped
@Named
public class HeaderTemplate extends ABaseBean
{
    private Autenticacao autenticacao;
    private Usuario usuario;
    private TipoUsuario tipoUsuario;
    
    public HeaderTemplate()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        autenticacao = (Autenticacao) session.getAttribute("autenticacao");
        this.usuario = new Usuario();
        this.tipoUsuario = new TipoUsuario();
        usuario.setID(autenticacao.getID_cadastroUsuario());
        carregarDadosUsuario();
    }
    
    private void carregarDadosUsuario()
    {
        try{
        UsuarioCRUD crud = new UsuarioCRUD();
        crud.setSession(FactoryHibernate.getSessionFactory().openSession());
        usuario = crud.consultarPorID(usuario);
        tipoUsuario.setID(usuario.getId_usuarioTipo());
        carregarDadosTipoUsuario();
        }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível encontrar os dados do usuário!"));
        }
    }
    
    private void carregarDadosTipoUsuario()
    {
        TipoUsuarioCRUD crud = new TipoUsuarioCRUD();
        crud.setSession(FactoryHibernate.getSessionFactory().openSession());
        tipoUsuario = crud.consultarPorID(tipoUsuario);
    }
    
    public String getUsuarioNome(){
        return usuario.getNome();
    }
    
    public String getUsuarioFuncao(){
        return tipoUsuario.getDescricao();
    }
    
    
    public void closeSession() throws IOException
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../aadsp/faces/index.xhtml");
    }

}
