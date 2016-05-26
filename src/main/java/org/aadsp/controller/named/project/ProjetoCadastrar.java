package org.aadsp.controller.named.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.annotations.Projeto;
import org.aadsp.annotations.TAP;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Session;
import org.apache.commons.mail.EmailException;

@ViewScoped
@Named
public class ProjetoCadastrar extends ABaseNamed implements ICadastro
{

    public ProjetoCadastrar()
    {
        this.projeto = new Projeto();
        dataInicio = new Date(new Date().getTime());
        dataFim = new Date(new Date().getTime());
    }

    @Override
    public boolean controleDeCadastro()
    {
        return this.projeto.getDataTermino() != null;
    }

    public void cadastrar() throws MessagingException, EmailException
    {
        try
        {
            if (!dataFim.equals(dataInicio))
            {
                projeto.setDataCadastro(new java.sql.Date(new Date().getTime()));
                projeto.cadastrar();
                Mensageiro.mensagemInfo("Projeto cadastrado com sucesso");
            } else
            {
                Mensageiro.mensagemError("Não é permitido cadastrar as datas de Início e Fim do projeto iguais!!");
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar o Projeto!", (Usuario) Session.getAttribute("usuario"), e);
        }
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public Date getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Date date)
    {
        dataInicio = date;
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.projeto.setDataInicio(dataSql);
    }

    public Date getDataFim()
    {
        return dataFim;
    }

    public void setDataFim(Date date)
    {
        dataFim = date;
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.projeto.setDataTermino(dataSql);
    }

    public Map<String, Integer> getTAPs()
    {
        try
        {
            TAP tap = new TAP();
            List<TAP> lista = tap.listar();

            List<Projeto> listaProjetos = projeto.listar();

            List<Integer> listIDProjetoUtilizados = new ArrayList<>();
            Map<String, Integer> tapMap = new HashMap<String, Integer>();

            for (Projeto obj : listaProjetos)
            {
                listIDProjetoUtilizados.add(obj.getTap().getID());
            }

            for (TAP obj : lista)
            {
                if (!listIDProjetoUtilizados.contains(obj.getID()))
                {
                    tapMap.put(Integer.toString(obj.getID()) + " - " + obj.getNome(), obj.getID());
                }
            }
            return tapMap;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os projetos utilizados!");
        }
        return null;
    }

    public int getTapSelecionado()
    {
        return projeto.getTap().getID();
    }

    public void setTapSelecionado(int tapSelecionado)
    {
        TAP tap = new TAP();
        tap.setID(tapSelecionado);
        projeto.setTap(tap);
    }

    private Projeto projeto;
    private Date dataInicio;
    private int tapSelecionado;
    private Date dataFim;
}
