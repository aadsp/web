package org.aadsp.controller.named;

import java.io.IOException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Mensageiro;


/**Classe principal do projeto, etapa de identificação do usuário por login e senha
 * @author Felipe Coelho
 * @version 24/04/2016
 */
@SessionScoped
@Named
public class Index extends ABaseNamed {
    
    /** Construtor base da classe com instancia de um usuário
     */
    public Index() {
        usuario = new Usuario();
        usuario.setLogin("");
        usuario.setSenha("");
    }
    
    /** Metódo de busca de um usuário para a pagina xhtml
     * @return  retorna um usuário em branco, caso não encontrado
     */
    public IUsuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setLogin("");
            usuario.setSenha("");
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**Metódo principal de autenticação do projeto, valida os dados de login e senha informados e encaminha o usuário autenticado
     * para a página principal de menu do projeto
     */
    public void autenticar() throws IOException {
        try {
            usuario = usuario.autenticar();

            if (usuario != null && usuario.getLogin() != null && usuario.getSenha() != null) {
                List<String> paginasPermitidas = usuario.paginasAcesso();

                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("paginasAcesso", paginasPermitidas);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/web/faces/views/menu/Index.xhtml");
            } else {
                usuario = usuario.validarLogin();
                if (usuario != null && usuario.getLogin() != null && usuario.getSenha() != null) {
                    Mensageiro.mensagemError("Senha incorreta!!");

                } else {
                    Mensageiro.mensagemError("Não foi possível autenticar o usuário com os dados informados!");
                }
            }
        } catch (Exception e) {
            Mensageiro.mensagemFatal("Não foi possível realizar a autenticação no banco de dados!");
        }
    }

    private static final long serialVersionUID = 5585493974059809141L;
    private IUsuario usuario;
}
