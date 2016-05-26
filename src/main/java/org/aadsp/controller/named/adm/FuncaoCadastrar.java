package org.aadsp.controller.named.adm;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Funcao;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;

/**
 * Classe que representa o objeto de tela Funcao Cadastro
 *
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class FuncaoCadastrar extends ABaseNamed implements ICadastro
{

    public FuncaoCadastrar()
    {
        this.funcao = new Funcao();
    }

    public boolean controleDeCadastro()
    {
        return this.funcao.getSigla() != null;
    }

    public void cadastrar()
    {
        try
        {
            funcao.cadastrar();
            Mensageiro.mensagemInfo("Função cadastrada com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível cadastrar a função!");
        }
    }

    public Funcao getFuncao()
    {
        return funcao;
    }

    public void setFuncao(Funcao funcao)
    {
        this.funcao = funcao;
    }
    private Funcao funcao;
}
