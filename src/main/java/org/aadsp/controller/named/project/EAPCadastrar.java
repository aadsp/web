package org.aadsp.controller.named.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Acesso;
import org.aadsp.annotations.EAP;
import org.aadsp.annotations.EAPTipo;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Projeto;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Acesso Cadastro
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class EAPCadastrar extends ABaseNamed implements ICadastro
{

    public EAPCadastrar()
    {

    }

    @PostConstruct
    public void init()
    {
        this.eap = new EAP();
        this.projeto = new Projeto();
        this.tipoEAP = new EAPTipo();
        this.projetos = new HashMap<String, Integer>();
        this.eapTipos = new HashMap<String, Integer>();
        naocadastrado = true;
    }

    public boolean controleDeCadastro()
    {
        return naocadastrado;
    }

    public void cadastrar()
    {
        try
        {
            EAPTipo tipo = new EAPTipo();
            Projeto projeto = new Projeto();
            tipo.setID(tipoSelecionado);
            projeto.setID(projetoSelecionado);
            eap.setEapTipo(tipo);
            eap.setProjeto(projeto);
            eap.setDataCriacao(new java.sql.Date(new Date().getTime()));
            eap.cadastrar();
            Mensageiro.mensagemInfo("Cadastro realizado com sucesso!!");
            naocadastrado = false;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Esta função já foi adicionada à esta página!!");
        }
    }

    public void onProjetoSelecionado()
    {
        if (projetoSelecionado != 0)
        {
            this.eapTipos = new HashMap<String, Integer>();
            Projeto projeto = new Projeto();
            projeto.setID(projetoSelecionado);
            this.eap.setProjeto(projeto);
        }

    }

    public int getTipoSelecionado()
    {
        return tipoSelecionado;
    }

    public void setTipoSelecionado(int tipoSelecionado)
    {
        this.tipoSelecionado = tipoSelecionado;
    }

    public int getProjetoSelecionado()
    {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(int projetoSelecionado)
    {
        this.projetoSelecionado = projetoSelecionado;
    }

    public Map<String, Integer> getProjetos()
    {
        try
        {

            List<Projeto> lista = projeto.listar();
            for (Projeto obj : lista)
            {
                projetos.put(obj.getTap().getNome(), obj.getID());
            }
            return projetos;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os projetos!");
        }
        return null;
    }

    public Map<String, Integer> getEapTipos()
    {
        try
        {
            if (projetoSelecionado != 0)
            {
                List<EAPTipo> lista = tipoEAP.listar();
                List<EAP> eapProjetos = eap.listarPorProjeto();
                List<Integer> eapTiposProjeto = new ArrayList<>();

                for (EAP obj : eapProjetos)
                {
                    eapTiposProjeto.add(obj.getEapTipo().getID());
                }

                for (EAPTipo obj : lista)
                {
                    if (!eapTiposProjeto.contains(obj.getID()))
                    {
                        eapTipos.put(obj.getDescricao(), obj.getID());
                    }
                }
            }
            return eapTipos;

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar as Estruturas Analíticas desse projeto!");
        }
        return null;
    }

    private int tipoSelecionado;
    private int projetoSelecionado;
    private Projeto projeto;
    private EAPTipo tipoEAP;
    private Map<String, Integer> projetos;
    private Map<String, Integer> eapTipos;
    private EAP eap;
    private boolean naocadastrado;
}
