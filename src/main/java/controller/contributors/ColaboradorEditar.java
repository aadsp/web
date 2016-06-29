package controller.contributors;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import annotations.acesso.colaborador.Colaborador;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;


@ViewScoped
@Named
public class ColaboradorEditar extends ABaseNamed
{

    public ColaboradorEditar()
    {
        this.colaborador = new Colaborador();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDColaborador = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("colaborador")));
            this.colaborador.setID(IDColaborador);
            this.colaborador = colaborador.consultar();
            data = colaborador.getDataContrato();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            colaborador.excluir();
            Response.redirect("/web/faces/views/colaboradores/ColaboradorConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir os dados deste colaborador!");
        }
    }

    public void editar()
    {
        try
        {
            colaborador.editar();
            Mensageiro.mensagemInfo("Dados do colaborador atualizado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar os dados do colaborador!");
        }
    }

    public Colaborador getColaborador()
    {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador)
    {
        this.colaborador = colaborador;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date date) throws ParseException
    {
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.colaborador.setDataContrato(dataSql);
    }

    private Colaborador colaborador;
    private Date data;
}
