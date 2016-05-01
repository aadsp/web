package org.aadsp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "Faces Servlet" })
public class ControleDeAcesso implements Filter {
	
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();        
        
        controlarAcesso(session, req, chain, request, response);
    }
    
    /**
     Metódo que controla o acesso dos usuário no sistema, este utiliza a URL do sistema verificando a ultima 
     * pagina e conforme a lista de páginas disponiveis ao usuário.
     * @param session deve ser fornecido o HTTPSession
     * @exception IOException exceção de entrada e saida
     * @exception ServletException é resultado de uma exceção do servelet
     */
    private void controlarAcesso(HttpSession session, HttpServletRequest req, FilterChain chain, ServletRequest request, ServletResponse response) throws IOException, ServletException
    {
        if ((session.getAttribute("usuario") != null)
                || (req.getRequestURI().endsWith("Index.xhtml"))
                || (req.getRequestURI().endsWith("acessoNegado.xhtml"))
                || (req.getRequestURI().endsWith("aadsp/"))
                || (req.getRequestURI().contains("bootstrap/"))
                || (req.getRequestURI().contains("chart/"))
                || (req.getRequestURI().contains("img/"))
                || (req.getRequestURI().contains("primefaces/"))
                || (req.getRequestURI().contains("javax.faces.resource/")))
        {
            if ((req.getRequestURI().endsWith("Index.xhtml"))
                    || (req.getRequestURI().endsWith("acessoNegado.xhtml"))
                    || (req.getRequestURI().endsWith("aadsp/"))
                    || (req.getRequestURI().contains("bootstrap/"))
                    || (req.getRequestURI().contains("chart/"))
                    || (req.getRequestURI().contains("img/"))
                    || (req.getRequestURI().contains("primefaces/"))
                    || (req.getRequestURI().contains("javax.faces.resource/")))
            {
                chain.doFilter(request, response);
            }
            else
            {
                List<String> paginaPermitida = new ArrayList<>();
                paginaPermitida = (List<String>) session.getAttribute("paginasAcesso");
                if(session.getAttribute("usuario") != null)
                {
                    for(String pag: paginaPermitida){
                        if(req.getRequestURI().contains(pag+".xhtml"))
                            chain.doFilter(request, response);    
                    }
                    
                }
                else
                {
                    redireciona("/web/faces/acessoNegado.xhtml", response);
                }
            }
        }
        else 
        {
            redireciona("/web/faces/Index.xhtml", response);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
	
    }

    public void destroy() {
    
    }
	
    private void redireciona(String url, ServletResponse response)throws IOException 
    {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);
    }
}