package controller.contributors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.tap.Stakeholder;
import interfaces.ABaseNamed;
import interfaces.ICadastro;
import utils.Mensageiro;


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
