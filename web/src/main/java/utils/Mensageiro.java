/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import annotations.acesso.Usuario;
import org.apache.commons.mail.EmailException;

/**
 * Classe que controla as mensagens exibidas ao usuário, são definidas de acordo
 * com os metodos e severidades
 *
 * @author Felipe
 * @version 24/04/2016
 */
public class Mensageiro
{

    /**
     * Metódo para informar mensagens de INFORMAÇÃO, este tipo é considerado com
     * 1 - Nível de severidade, FUNÇÃO; Deve ser utilizada para somente exibição
     * de operações de sucesso pelo sistema
     *
     * @param subtitulo deve ser informado o subtitulo da mensagem à ser exibida
     * ao usuário
     */
    public static void mensagemInfo(String subtitulo)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "- INFORMAÇÃO -", subtitulo));
    }

    /**
     * Metódo para informar mensagens de ERRO, este tipo é considerado com 3 -
     * Nível de severidade FUNÇÃO; Deve ser utilizada para somente exibição de
     * erro ocasionados por operações de banco de dados
     *
     * @param subtitulo deve ser informado o subtitulo da mensagem à ser exibida
     * ao usuário
     */
    public static void mensagemError(String subtitulo)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "- ERRO -", subtitulo));
    }

    public static void mensagemError(String subtitulo, Usuario usuario, Exception e) throws MessagingException, EmailException
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "- ERRO NOTIFICADO -", subtitulo));
        StackTraceElement[] element = e.getStackTrace();
        Email.enviarEmailErroExcecao(subtitulo, usuario.getNome(), usuario.getEmail(), e.getMessage(), element[0].getMethodName());
    }

    /**
     * Metódo para informar mensagens de ATENÇÃO, este tipo é considerado com 1
     * - Nível de severidade FUNÇÃO; Deve ser utilizada para somente exibição de
     * operações onde necessita de validações pelo ferramenta
     *
     * @param subtitulo deve ser informado o subtitulo da mensagem à ser exibida
     * ao usuário
     */
    public static void mensagemWarn(String subtitulo)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "- ATENÇÃO -", subtitulo));
    }

    /**
     * Metódo para informar mensagens de ERROS FATAIS, este tipo é considerado
     * com 4 - Nível de severidade FUNÇÃO; Deve ser utilizada para somente
     * exibição de operações que comprometem a funcionalidade do sistema
     *
     * @param subtitulo deve ser informado o subtitulo da mensagem à ser exibida
     * ao usuário
     */
    public static void mensagemFatal(String subtitulo)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "- ERRO FATAL -", subtitulo));
    }
}
