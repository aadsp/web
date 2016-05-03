
package org.aadsp.controller.named.project;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Empresa;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Edição
 * @author Felipe Coelho
 * @version  01/05/2016
 */
@ViewScoped
@Named
public class EmpresaEditar extends ABaseNamed
{
    
    public EmpresaEditar()
    {
        this.empresa = new Empresa();
        carregarDadosIniciais();
    }
   
    private void carregarDadosIniciais()
    {
        try
        {
            int IDEmpresa = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("empresa")));
            this.empresa.setID(IDEmpresa);
            this.empresa = empresa.consultarPorID();
        }catch(Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }
    
    public void excluir()
    {
      try
      {
        empresa.excluir();
        Response.redirect("/web/faces/views/projeto/EmpresaConsultar.xhtml");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível excluir os dados deste stakeholder!");
      }
    }
    
    public void editar()
    {
      try
      {
        empresa.editar();
        Mensageiro.mensagemInfo("Dados da empresa atualizado com sucesso");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível atualizar os dados do empresa!");
      }
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    private Empresa empresa;
}
