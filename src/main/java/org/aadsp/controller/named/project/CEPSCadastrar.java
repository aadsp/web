package org.aadsp.controller.named.project;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.apache.commons.mail.EmailException;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

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
    
    @PostConstruct
    public void init() {
        lazyEventModel = new LazyScheduleModel() {
             
            @Override
            public void loadEvents(Date start, Date end) {
                Date random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));
                 
                random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
            }   
        };
    }
    
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
    
    @Override
    public boolean controleDeCadastro()
    {
        return controleDeCadastro;
    }

    public void cadastrar() throws MessagingException, EmailException
    {

    }
     
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    private ScheduleModel lazyEventModel;
    private boolean controleDeCadastro;
}
