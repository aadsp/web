
package org.aadsp.utils;

import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 * Classe para redirecionamento de páginas 
 * @author Felipe
 */
public class Response 
{
    public static void redirect(String URL) throws IOException
    {
        FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
    }
}
