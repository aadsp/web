package org.aadsp.utils;

import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 * Classe para redirecionamento de páginas
 *
 * @author Felipe
 */
public class Response
{

    /**
     * Metódo estático para redirecionamento à uma determina URL, deverá ser
     * passada uma URL Válida
     *
     * @param URL deve ser informado a URL à qual quer ser redirecionado
     * @exception IOException é gerado uma exceção do tipo entrada e saida de
     * dados
     */
    public static void redirect(String URL) throws IOException
    {
        FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
    }

    /**
     * Metódo para captura de um atributo da URL em vigência
     *
     * @param atributo deverá ser informado o atributo que deseja capturar o seu
     * valor
     * @return É retornado o valor em formato string do atributo.
     */
    public static String getParametroURL(String atributo)
    {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(atributo);
    }
}
