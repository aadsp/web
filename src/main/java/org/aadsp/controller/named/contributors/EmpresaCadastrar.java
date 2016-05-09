
package org.aadsp.controller.named.contributors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Empresa;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;

@ViewScoped
@Named
public class EmpresaCadastrar extends ABaseNamed
{
    
    public EmpresaCadastrar()
    {
        this.empresa = new Empresa();
    }
   
    public boolean controleDeCadastro()
    {
        return this.empresa.getRazaoSocial()!= null;
    }
    
    public void cadastrar()
    {
      try
      {
        empresa.cadastrar();
        Mensageiro.mensagemInfo("Empresa cadastrada com sucesso!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível cadastrar a empresa!");
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
