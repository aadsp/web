package controller.contributors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.tap.Stakeholder;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;


@ViewScoped
@Named
public class StakeholderEditar extends ABaseNamed
{

    public StakeholderEditar()
    {
        this.stakeholder = new Stakeholder();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDStakeholder = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Stakeholder")));
            this.stakeholder.setID(IDStakeholder);
            this.stakeholder = stakeholder.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            stakeholder.excluir();
            Response.redirect("/web/faces/views/colaboradores/StakeholderConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir os dados deste stakeholder!");
        }
    }

    public void editar()
    {
        try
        {
            stakeholder.editar();
            Mensageiro.mensagemInfo("Dados do Stakeholder atualizado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar os dados do Stakeholder!");
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
