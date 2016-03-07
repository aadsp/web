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
	
    
    
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();        
        
        controlarAcesso(session, req, chain, request, response);
    }

    private void controlarAcesso(HttpSession session, HttpServletRequest req, FilterChain chain, ServletRequest request, ServletResponse response) throws IOException, ServletException
    {
        if ((session.getAttribute("autenticacao") != null)
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
                if(session.getAttribute("autenticacao") != null)
                {
                    for(String pag: paginaPermitida){
                        if(req.getRequestURI().endsWith(pag))
                            chain.doFilter(request, response);    
                    }
                    redireciona("/aadsp/faces/acessoNegado.xhtml", response);
                }
            }
        }
        else 
        {
            redireciona("/aadsp/faces/Index.xhtml", response);
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