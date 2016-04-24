
package org.aadsp.controller.named;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.model.UsuarioModel;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.FactoryHibernate;


@SessionScoped
@Named
public class HeaderTemplate extends ABaseBean
{
    private IUsuario usuario;
    
    public HeaderTemplate()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        usuario = (Usuario) session.getAttribute("usuario");
    }
    
    
    
    public String getUsuarioNome(){
        return usuario.getNome();
    }
    
    public String getUsuarioFuncao(){
        try{
        return usuario.consultarFunacao();
        }catch(Exception e){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível localizar os dados!"));
        }
        return "";
    }
    
    
    public void closeSession() throws IOException
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../web/faces/index.xhtml");
    }

}
