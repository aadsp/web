package org.aadsp.controller.named;

import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.interfaces.IUsuario;


@SessionScoped
@Named
public class Index extends ABaseBean
{   
    
    public Index()
    {
       usuario = new Usuario();
       usuario.setLogin("");
       usuario.setSenha("");
    }

    public IUsuario getUsuario()
    {
        if(usuario == null)
        {
            usuario = new Usuario();
            usuario.setLogin("");
            usuario.setSenha("");
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void autenticar() throws IOException
    {
       try
       {
        usuario = usuario.autenticar();
        
        if(usuario != null && usuario.getLogin() != null && usuario.getSenha() != null)
        {
            List<String> paginasPermitidas = usuario.paginasAcesso();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("paginasAcesso",paginasPermitidas);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/web/faces/views/menu/Index.xhtml");
        }
        else
        {
            usuario = usuario.validarLogin();
            if(usuario != null && usuario.getLogin() != null && usuario.getSenha() != null)
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
    
    private static final long serialVersionUID = 5585493974059809141L;
    private IUsuario usuario;
}
