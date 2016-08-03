package controller.adm;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.ABaseNamed;
import interfaces.IUsuario;
import utils.Mensageiro;

/**
 * Classe principal do template, resposável por exibir informações do usuário
 * autenticado
 *
 * @author Felipe Coelho
 * @version 24/04/2016
 */
@SessionScoped
@Named
public class HeaderTemplate extends ABaseNamed {

    /**
     * Busca o usuário na sessão para informar seus dados no painel principal
     */
    public HeaderTemplate() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            usuario = (IUsuario) session.getAttribute("usuario");
            
        } catch (Exception e) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../web/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(HeaderTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getUsuarioNome() {
        return usuario.getNome();
    }

    public String getImagemUsuario() {
        if (usuario.getImagem() != null) {
            return "../../../img/user/" + usuario.getImagem();
        } else {
            return "../../../img/user/usuario.jpg";
        }
    }

    /**
     * Metódo de consulta da função de um usuário no sistema
     *
     * @return retorna uma string com o nome da função de um usuário
     */
    public String getUsuarioFuncao() {
        try {
            return usuario.consultarFuncao();
        } catch (Exception e) {
            Mensageiro.mensagemError("Não foi possível localizar os dados!");
        }
        return "";
    }

    /**
     * Metódo de encerramento de uma sessão do header, este metódo invalidará a
     * sessão corrente matando o usuário da sessão
     *
     * @throws java.io.IOException
     */
    public void closeSession() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../web/faces/index.xhtml");
        } catch (IOException e) {
            Mensageiro.mensagemError("O ocerreu o seguinte erro ao executar esta operação:" + e.getMessage());
        }
    }

    private IUsuario usuario;
}
