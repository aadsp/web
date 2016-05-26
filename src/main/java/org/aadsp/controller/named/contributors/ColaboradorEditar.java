package org.aadsp.controller.named.contributors;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.Colaborador;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;


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
