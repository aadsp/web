
package interfaces;

import java.util.List;

public interface IUsuario
{
    public String getNome();
    
    public String getLogin();
    public String getSenha();
    public void setSenha(String login);
    public void setLogin(String login);
    public List<String> paginasAcesso() throws Exception;
    public String getImagem();
    public String consultarFuncao() throws Exception;
}
