package utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe
 */
public class Filtro implements Serializable
{

    public Filtro()
    {
        addOperadorCondicional();
        this.atributo = new HashMap<>();
        this.atributoClasse = new HashMap<>();
        this.filtro = "TODOS";
        this.caminhoServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
    }

    private void addOperadorCondicional()
    {
        this.operadorCondicional = new HashMap<>();
        operadorCondicional.put("E", "AND");
        operadorCondicional.put("OU", "OR");
    }

    private void addOperadorLogico()
    {
        if(filtro.equals("TODOS") && !atributoSelecionado.equals("FILTRAR POR")){
            filtro = null;
        }
            
        this.operadorLogico = new HashMap<>();
        operadorLogico.put("IGUAL", "=");
        operadorLogico.put("DIFERENTE", "<>");
        operadorLogico.put("MAIOR OU IGUAL", ">=");
        operadorLogico.put("MENOR OU IGUAL", "<=");
        operadorLogico.put("SEMELHANTE", "LIKE");
        operadorLogico.put("MAIOR", ">");
        operadorLogico.put("MENOR", "<");
    }

    public void onAtributoSelecionado() throws ClassNotFoundException
    {
        addOperadorLogico();
        
        if (atributoSelecionado != null && !atributoSelecionado.equals("FILTRAR POR"))
        {
            String atributoAnotacao = atributoSelecionado;
            if (atributoSelecionado.contains("."))
            {
                String objMapeamento = Character.toString(atributoAnotacao.charAt(0));
                atributoAnotacao = atributoAnotacao.replace(objMapeamento + ".", "");
            }

            String nomeClasseAtributo = atributoClasse.get(atributoSelecionado);
            String tipoAtributo = "";
            for (Field atributoClasse : Class.forName("annotations."  + nomeClasseAtributo).getDeclaredFields())
            {
                if (atributoClasse.getName().equals(atributoAnotacao))
                {
                    tipoAtributo = atributoClasse.getType().getName();

                }
            }

            tipoAtributo = tipoAtributo.replace("java.lang.", "");

            if (tipoAtributo.equals("String"))
            {
                operadorLogico.remove("MAIOR OU IGUAL");
                operadorLogico.remove("MENOR OU IGUAL");
                operadorLogico.remove("MAIOR");
                operadorLogico.remove("MENOR");
            } else
            {
                operadorLogico.remove("SEMELHANTE");
            }

            if (filtro == null)
            {
                filtro = "( " + atributoSelecionado;
            } else if (!filtro.endsWith(") ") && operadorCondicionalSelecionada != null)
            {
                filtro = filtro + " " + operadorCondicionalSelecionada + " ( " + atributoSelecionado;
            }
        }

    }

    public void onOperadorLogicoSelecionado()
    {
        if (operadorLogicoSelecionado != null)
        {
            if (filtro != null)
            {
                if (!filtro.endsWith("=")
                        && !filtro.endsWith(">=") && !filtro.endsWith("<=")
                        && !filtro.endsWith(">") && !filtro.endsWith("<")
                        && !filtro.endsWith("<>") && !filtro.endsWith("LIKE"))
                {
                    filtro = filtro + " " + operadorLogicoSelecionado;
                }
            }
        }
    }

    public Map<String, String> getOperadorCondicional()
    {
        return operadorCondicional;
    }

    public void setOperadorCondicional(Map<String, String> operadorCondicional)
    {
        this.operadorCondicional = operadorCondicional;
    }

    public String getOperadorCondicionalSelecionada()
    {
        return operadorCondicionalSelecionada;
    }

    public void setOperadorCondicionalSelecionada(String operadorCondicionalSelecionada)
    {
        this.operadorCondicionalSelecionada = operadorCondicionalSelecionada;
    }

    public Map<String, String> getAtributo()
    {
        return atributo;
    }

    public void setAtributo(Map<String, String> atributo, Map<String, String> atributoClasse)
    {
        this.atributo = atributo;
        this.atributoClasse = atributoClasse;
    }

    public String getAtributoSelecionado()
    {
        return atributoSelecionado;
    }

    public void setAtributoSelecionado(String atributoSelecionado)
    {
        this.atributoSelecionado = atributoSelecionado;
    }

    public Map<String, String> getOperadorLogico()
    {
        return operadorLogico;
    }

    public void setOperadorLogico(Map<String, String> operadorLogico)
    {
        this.operadorLogico = operadorLogico;
    }

    public String getOperadorLogicoSelecionado()
    {
        return operadorLogicoSelecionado;
    }

    public void setOperadorLogicoSelecionado(String operadorLogicoSelecionado)
    {
        this.operadorLogicoSelecionado = operadorLogicoSelecionado;
    }

    public String getAtributoFiltro()
    {
        return atributoFiltro;
    }

    public void setAtributoFiltro(String atributoFiltro)
    {
        this.atributoFiltro = atributoFiltro;
    }

    public boolean getOnAtributoSelecionado()
    {
        return atributoSelecionado != null;
    }

    public void removerFiltro()
    {
        this.filtro = "TODOS";
    }

    public void filtrar() throws ClassNotFoundException
    {
        if (operadorLogicoSelecionado != null && !atributoSelecionado.equals("FILTRAR POR"))
        {
            if (filtro != null && atributoFiltro != null && operadorLogicoSelecionado != null)
            {
                if (filtro.startsWith("(") && !filtro.endsWith(")")
                        && !atributoFiltro.equals(" ") && !atributoFiltro.equals("")
                        && (filtro.endsWith("=") || filtro.endsWith(")")
                        || filtro.endsWith(">=") || filtro.endsWith("<=")
                        || filtro.endsWith(">") || filtro.endsWith("<")
                        || filtro.endsWith("<>") || filtro.endsWith("LIKE")))
                {

                    String atributoAnotacao = atributoSelecionado;
                    if (atributoSelecionado.contains("."))
                    {
                        String objMapeamento = Character.toString(atributoAnotacao.charAt(0));
                        atributoAnotacao = atributoAnotacao.replace(objMapeamento + ".", "");
                    }
                    
                    String nomeClasseAtributo = atributoClasse.get(atributoSelecionado);
                    String tipoAtributo = "";
                    for (Field atributoClasse : Class.forName("annotations." + nomeClasseAtributo).getDeclaredFields())
                    {
                        if (atributoClasse.getName().equals(atributoAnotacao))
                        {
                            tipoAtributo = atributoClasse.getType().getName();

                        }
                    }
                    tipoAtributo = tipoAtributo.replace("java.lang.", "");
                    if (tipoAtributo.equals("String"))
                    {
                        if (filtro.endsWith("LIKE"))
                        {
                            filtro = filtro + " '%" + atributoFiltro + "%')";
                        } else
                        {
                            filtro = filtro + " '" + atributoFiltro + "')";
                        }
                    } else
                    {
                        filtro = filtro + " " + atributoFiltro + ")";
                    }
                }
            }
        }
    }

    public String getFiltro()
    {
        return filtro;
    }

    public void setFiltro(String filtro)
    {
        this.filtro = filtro;
    }

    private Map<String, String> operadorCondicional;
    private String operadorCondicionalSelecionada;
    private Map<String, String> atributo;
    private Map<String, String> atributoClasse;
    private String atributoSelecionado;
    private Map<String, String> operadorLogico;
    private String operadorLogicoSelecionado;
    private String atributoFiltro;
    public String filtro;
    private String caminhoServidor;
}
