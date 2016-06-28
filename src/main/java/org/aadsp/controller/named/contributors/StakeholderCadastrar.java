package org.aadsp.controller.named.contributors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.framework.ICadastro;
import org.aadsp.utils.Mensageiro;


@ViewScoped
@Named
public class StakeholderCadastrar extends ABaseNamed implements ICadastro
{

    public StakeholderCadastrar()
    {
        this.stakeholder = new Stakeholder();
    }

    public boolean controleDeCadastro()
    {
        return this.stakeholder.getNome() != null;
    }

    public void cadastrar()
    {
        try
        {
            stakeholder.cadastrar();
            Mensageiro.mensagemInfo("Stakeholder cadastrado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar o staeholder!");
        }
    }

    public Stakeholder getStakeholder()
    {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder)
    {
        this.stakeholder = stakeholder;
    }

    private Stakeholder stakeholder;
}
