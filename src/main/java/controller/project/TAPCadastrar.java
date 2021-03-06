package controller.project;

import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import annotations.tap.TAP;
import interfaces.ABaseNamed;
import interfaces.ICadastro;
import utils.Mensageiro;

@ViewScoped
@Named
public class TAPCadastrar extends ABaseNamed implements ICadastro
{

    public TAPCadastrar()
    {
        dataInicio = new Date(new Date().getTime());
        dataFim = new Date(new Date().getTime());
        this.tap = new TAP();
    }

    public boolean controleDeCadastro()
    {
        return this.tap.getNome() != null;
    }

    public void cadastrar()
    {
        try
        {
            tap.setDataCriacao(new java.sql.Date(new Date().getTime()));
            tap.cadastrar();
            Mensageiro.mensagemInfo("O TAP foi cadastrado com sucesso!");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar o TAP!");
        }
    }

    public Date getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Date date) throws ParseException
    {
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.tap.setDataInicio(dataSql);
    }

    public TAP getTap()
    {
        return tap;
    }

    public void setTap(TAP tap)
    {
        this.tap = tap;
    }

    public Date getDataFim()
    {
        return dataFim;
    }

    public void setDataFim(Date date)
    {
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.tap.setDataFim(dataSql);
    }

    private TAP tap;
    private Date dataInicio;
    private Date dataFim;
}
