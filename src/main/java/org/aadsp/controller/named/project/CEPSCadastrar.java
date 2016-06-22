package org.aadsp.controller.named.project;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.apache.commons.mail.EmailException;

@ViewScoped
@Named
public class CEPSCadastrar extends ABaseNamed implements ICadastro
{

    public CEPSCadastrar()
    {
        this.controleDeCadastro = false;
        carregarDadosIniciais();
    }

    public void carregarDadosIniciais()
    {

    }

    @Override
    public boolean controleDeCadastro()
    {
        return controleDeCadastro;
    }

    public void cadastrar() throws MessagingException, EmailException
    {

    }

    private boolean controleDeCadastro;
}
