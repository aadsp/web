
package org.aadsp.controller.named;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Pessoal Cadastro
 * @author Felipe Coelho
 * @version  25/04/2016
 */
@ViewScoped
@Named
public class PessoalCadastrar extends ABaseBean
{   
    public PessoalCadastrar()
    {
        this.usuario = new Usuario();
        this.data = new Date(new Date().getTime());
    }
   
    public void cadastrar()
    {
      
    }
    
    public void setData(Date data) throws ParseException
    {
       java.sql.Date dataSql = new java.sql.Date(data.getTime());
       this.usuario.setDataNascimento(dataSql);
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
   
    private Usuario usuario;
    private Date data;
}
