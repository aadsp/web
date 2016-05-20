package org.aadsp.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Felipe
 */
public class Filtro {

    public Filtro() {
        addOperadorCondicional();
        addOperadorLogico();
        this.atributo = new HashMap<>();
        this.atributoClasse = new HashMap<>();
    }

    private void addOperadorCondicional() {
        this.operadorCondicional = new HashMap<>();
        operadorCondicional.put("E", "AND");
        operadorCondicional.put("OU", "OR");
    }

    private void addOperadorLogico() {
        this.operadorLogico = new HashMap<>();
        operadorLogico.put("IGUAL", "=");
        operadorLogico.put("DIFERENTE", "<>");
        operadorLogico.put("MAIOR OU IGUAL", ">=");
        operadorLogico.put("MENOR OU IGUAL", "<=");
        operadorLogico.put("SEMELHANTE", "LIKE");
        operadorLogico.put("MAIOR", ">");
        operadorLogico.put("MENOR", "<");
    }

    public void onAtributoSelecionado() throws ClassNotFoundException {
        addOperadorLogico();
        if (atributoSelecionado != null) {
            String nomeClasseAtributo = atributoClasse.get(atributoSelecionado);
            String tipoAtributo = "";
            for (Field atributoClasse : Class.forName("org.aadsp.annotations." + nomeClasseAtributo).getDeclaredFields()) {
                if (atributoClasse.getName().equals(atributoSelecionado)) {
                    tipoAtributo = atributoClasse.getType().getName();

                }
            }

            tipoAtributo = tipoAtributo.replace("java.lang.", "");

            if (tipoAtributo.equals("String")) {
                operadorLogico.remove("MAIOR OU IGUAL");
                operadorLogico.remove("MENOR OU IGUAL");
                operadorLogico.remove("MAIOR");
                operadorLogico.remove("MENOR");
            }else {
                operadorLogico.remove("SEMELHANTE");
            }

            if (filtro == null) {
                filtro = "( " + atributoSelecionado + " ";
            }else if(!filtro.endsWith(") ") && !atributoSelecionado.equals("FILTRAR POR"))
            {
                filtro = filtro + " " + operadorCondicionalSelecionada + " ( " + atributoSelecionado + " " +operadorLogicoSelecionado;
            }
        }else
        {
            operadorLogico.remove("IGUAL");
            operadorLogico.remove("DIFERENTE");
            operadorLogico.remove("MAIOR OU IGUAL");
            operadorLogico.remove("MENOR OU IGUAL");
            operadorLogico.remove("SEMELHANTE");
            operadorLogico.remove("MAIOR");
            operadorLogico.remove("MENOR");
        }

    }

    public void onOperadorLogicoSelecionado() {
        if (operadorLogicoSelecionado != null) {
            if (filtro != null) {
                if (filtro.endsWith(" ") && !filtro.endsWith("= ") 
                    && !filtro.endsWith(">= ") && !filtro.endsWith("<= ")
                    && !filtro.endsWith("> ")&& !filtro.endsWith("< ")
                    && !filtro.endsWith("<> ")&& !filtro.endsWith("LIKE ")) {
                        filtro = filtro + operadorLogicoSelecionado+" ";
                }
            }
        }
    }

    public Map<String, String> getOperadorCondicional() {
        return operadorCondicional;
    }

    public void setOperadorCondicional(Map<String, String> operadorCondicional) {
        this.operadorCondicional = operadorCondicional;
    }

    public String getOperadorCondicionalSelecionada() {
        return operadorCondicionalSelecionada;
    }

    public void setOperadorCondicionalSelecionada(String operadorCondicionalSelecionada) {
        this.operadorCondicionalSelecionada = operadorCondicionalSelecionada;
    }

    public Map<String, String> getAtributo() {
        return atributo;
    }

    public void setAtributo(Map<String, String> atributo, Map<String, String> atributoClasse) {
        this.atributo = atributo;
        this.atributoClasse = atributoClasse;
    }

    public String getAtributoSelecionado() {
        return atributoSelecionado;
    }

    public void setAtributoSelecionado(String atributoSelecionado) {
        this.atributoSelecionado = atributoSelecionado;
    }

    public Map<String, String> getOperadorLogico() {
        return operadorLogico;
    }

    public void setOperadorLogico(Map<String, String> operadorLogico) {
        this.operadorLogico = operadorLogico;
    }

    public String getOperadorLogicoSelecionado() {
        return operadorLogicoSelecionado;
    }

    public void setOperadorLogicoSelecionado(String operadorLogicoSelecionado) {
        this.operadorLogicoSelecionado = operadorLogicoSelecionado;
    }

    public String getAtributoFiltro() {
        return atributoFiltro;
    }

    public void setAtributoFiltro(String atributoFiltro) {
        this.atributoFiltro = atributoFiltro;
    }

    public boolean getOnAtributoSelecionado() {
        return atributoSelecionado != null;
    }
    
    public void removerFiltro(){
        filtro = null;
    }
    
    public void filtrar() throws ClassNotFoundException {
        if (operadorLogicoSelecionado != null) {
            if (filtro != null && atributoFiltro != null && operadorLogicoSelecionado != null) {
                if (filtro.startsWith("(") && !filtro.endsWith(")")
                        && !atributoFiltro.equals(" ") && !atributoFiltro.equals("")
                    && (filtro.endsWith("=") || filtro.endsWith(")")
                    || filtro.endsWith(">=") || filtro.endsWith("<=")
                    || filtro.endsWith(">")||filtro.endsWith("<")
                    || filtro.endsWith("<>")|| !filtro.endsWith("LIKE "))) {
                       
                    
                    
                    String nomeClasseAtributo = atributoClasse.get(atributoSelecionado);
                    String tipoAtributo = "";
                    for (Field atributoClasse : Class.forName("org.aadsp.annotations." + nomeClasseAtributo).getDeclaredFields()) {
                        if (atributoClasse.getName().equals(atributoSelecionado)) {
                            tipoAtributo = atributoClasse.getType().getName();

                        }
                    }
                    tipoAtributo = tipoAtributo.replace("java.lang.", "");
                    if(tipoAtributo.equals("String"))
                        filtro = filtro +" '"+atributoFiltro+"')";
                    else
                       filtro = filtro +" "+atributoFiltro+")";
                }
            }
        }
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Map<String, String> operadorCondicional;
    public String operadorCondicionalSelecionada;
    public Map<String, String> atributo;
    public Map<String, String> atributoClasse;
    public String atributoSelecionado;
    public Map<String, String> operadorLogico;
    public String operadorLogicoSelecionado;
    public String atributoFiltro;
    public String filtro;

}
