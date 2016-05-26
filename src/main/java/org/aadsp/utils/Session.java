package org.aadsp.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Esta é uma classe para armazenamento de dados em sessão no sistema
 *
 * @author Felipe
 */
public class Session
{

    /**
     * Metodo para armazenar um atributo na sessão do usuário
     *
     * @param Attribute Deve ser informado o nome do atributo à ser armazenado
     * na Sessão
     * @param object Deve ser informado o objeto à ser armazenado na sessão
     */
    public static void setAttribute(String Attribute, Object object)
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(Attribute, object);
    }

    /**
     * Metodo para buscar um atributo armazenado na sessão do usuário
     *
     * @param Attribute Deve ser informado o nome do atributo armazenado na
     * Sessão
     * @return Object retorna uma objeto que pode ser qualquer objeto armazenado
     * pelo usuário na sessão
     */
    public static Object getAttribute(String Attribute)
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        return session.getAttribute(Attribute);
    }
}
