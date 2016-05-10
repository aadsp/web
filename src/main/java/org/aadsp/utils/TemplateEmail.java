
package org.aadsp.utils;

/**
 * Classe para armazenamento de template de email, estes estão em formado de string estruturados em HTML
 * @author Felipe
 */
public class TemplateEmail 
{
    public static String acessoIndevido(String nomeUsuario,String loginUsuario,String emailUsuario,String pagina){
        return "<html> "
                + "<table>"
                + "<tr><td><strong>Usuário:</strong></td><td>"+nomeUsuario+"</td></tr>"
                + "<tr><td><strong>Login:</strong></td><td>"+loginUsuario+"</td></tr>"
                + "<tr><td><strong>E-mail:</strong></td><td>"+emailUsuario+"</td></tr>"
                + "<tr><td><strong>Página:</strong></td><td>"+pagina+"</td></tr>"
                + "</table> "
                + "</html>";
    }
    
    /**
     * Metódo para estruturação em formato HTML de um email de erro
     * @param nomeUsuario nome do usuário em sessão 
     * @param loginUsuario login do usuário em sessão
     * @param emailUsuario email do usuário em sessão
     * @param mensagem mensagem proveniente do erro
     * @param pilha pilha gerada apartir o erro
     * @return Retorna uma string com formatação do email em html
     */
    public static String erro (String nomeUsuario,String loginUsuario,
                               String emailUsuario,String mensagem,String pilha){
        return "<html> "
                + "<table>"
                + "<tr><td><strong>Usuário:</strong></td><td>"+nomeUsuario+"</td></tr>"
                + "<tr><td><strong>Login:</strong></td><td>"+loginUsuario+"</td></tr>"
                + "<tr><td><strong>E-mail:</strong></td><td>"+emailUsuario+"</td></tr>"
                + "<tr><td><strong>Mensagem de Erro:</strong></td><td>"+mensagem+"</td></tr>"
                + "<tr><td><strong>Pilha do erro:</strong></td><td>"+pilha+"</td></tr>"
                + "</table> "
                + "</html>";
    }
    
    /**
     * Metódo para estruturação em formato HTML de um email de alteração de senha
     * @param nomeUsuario nome do usuário que a senha foi alterada
     * @param loginUsuario login do usuário que a senha foi alterada
     * @param senha nova senha definida ao usuário
     */
    public static String alteracaoSenha (String nomeUsuario,String loginUsuario,String senha){
        return "<html> "
                + "<table>"
                + "<tr><td><strong>Usuário:</strong></td><td>"+nomeUsuario+"</td></tr>"
                + "<tr><td><strong>Login:</strong></td><td>"+loginUsuario+"</td></tr>"
                + "<tr><td><strong>Nova Senha:</strong></td><td>"+senha+"</td></tr>"
                + "</table> "
                + "</html>";
    }
}
