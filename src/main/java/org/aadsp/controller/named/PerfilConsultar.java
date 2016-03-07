package org.aadsp.controller.named;


import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.TipoUsuarioCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@ViewScoped
@Named
public class PerfilConsultar extends ABaseBean
{   
    private Usuario usuario;
    
    public PerfilConsultar()
    {
        this.usuario = new Usuario();
    }
    
    public List<TipoUsuario> getTiposUsuario()
    {
        try 
        {
            TipoUsuarioCRUD crud = new TipoUsuarioCRUD();
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            return crud.listar();
        } 
        catch (Exception ex) 
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível buscar a lista de usuários no banco de dados!"));
        }
        return null;
    }
    
    public void editar(TipoUsuario selecionado) throws IOException
    {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tipoUsuario", selecionado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/aadsp/faces/views/adm/PerfilCadastrar.xhtml");
    }

}
