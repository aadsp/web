
package org.aadsp.controller.named;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Mensageiro;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Felipe
 */
@ViewScoped
@Named
public class UsuariosVisualizar extends ABaseNamed
{
    private PieChartModel pizzaModel1;
    private PieChartModel pizzaModel2;
    
    @PostConstruct
    public void init() {
        criandoModeloPizza1();
        criandoModeloPizza2();
    }

    public PieChartModel getPizzaModel1() {
        return pizzaModel1;
    }

    public PieChartModel getPizzaModel2() {
        return pizzaModel2;
    }
    
    
    
    private void criandoModeloPizza1() {
        try
        {
            pizzaModel1 = new PieChartModel();

            calculandoQuantidadeUsuarioPorFuncaoPizza1();

            pizzaModel1.setLegendPosition("w");
        }catch(Exception e)
        {
            Mensageiro.mensagemError("Falha ao carregar relatório 1 de funções por usuários");
        }
    }
    
    private void criandoModeloPizza2()
    {
       try
       {
        calculandoQuantidadeUsuarioPorFuncaoPizza2();
       }
       catch(Exception e)
       {
           Mensageiro.mensagemError("Falha ao carregar relatório 2 de funções por usuários");
       }
    }
    
    public void calculandoQuantidadeUsuarioPorFuncaoPizza1() throws Exception
    {
        Funcao funcao = new Funcao();
        Map<String,Integer> listaFuncoes = new HashMap<>();
        
        for(Funcao obj:funcao.listar())
        {
            if(!listaFuncoes.containsKey(obj.getDescricao()))
                listaFuncoes.put(obj.getDescricao(), 0);
        }
        
        Usuario usuario = new Usuario();
        for(Usuario obj: usuario.listar())
        {
            funcao.setID(obj.getId_funcao());
            funcao = funcao.consultarPorID();
            if(listaFuncoes.containsKey(funcao.getDescricao())){
                int qtd = listaFuncoes.get(funcao.getDescricao());
                qtd++;
                listaFuncoes.put(funcao.getDescricao(), qtd);
            }    
        }
        
        for (Map.Entry<String, Integer> pizzaMap : listaFuncoes.entrySet()) {
            String nomeFuncao = pizzaMap.getKey();
            Integer qtdFuncao = pizzaMap.getValue();
            pizzaModel1.set(nomeFuncao, qtdFuncao);
        }

    }
    
    public void calculandoQuantidadeUsuarioPorFuncaoPizza2() throws Exception
    {
        pizzaModel2 = new PieChartModel();
        
        Funcao funcao = new Funcao();
        Map<String,Integer> listaFuncoes = new HashMap<>();
        
        for(Funcao obj:funcao.listar())
        {
            if(!listaFuncoes.containsKey(obj.getDescricao()))
                listaFuncoes.put(obj.getDescricao(), 0);
        }
        
        Usuario usuario = new Usuario();
        for(Usuario obj: usuario.listar())
        {
            funcao.setID(obj.getId_funcao());
            funcao = funcao.consultarPorID();
            if(listaFuncoes.containsKey(funcao.getDescricao())){
                int qtd = listaFuncoes.get(funcao.getDescricao());
                qtd++;
                listaFuncoes.put(funcao.getDescricao(), qtd);
            }    
        }
        
        for (Map.Entry<String, Integer> pizzaMap : listaFuncoes.entrySet()) {
            String nomeFuncao = pizzaMap.getKey();
            Integer qtdFuncao = pizzaMap.getValue();
            pizzaModel2.set(nomeFuncao, qtdFuncao);
            
            pizzaModel2.setFill(false);
            pizzaModel2.setShowDataLabels(true);
        }
        
        
    }
}
