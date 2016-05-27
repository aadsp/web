package org.aadsp.controller.named.project;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.DiagramaUML;
import org.aadsp.annotations.DiagramaUMLTipo;
import org.aadsp.annotations.Projeto;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ViewScoped
@Named
public class ProjetoEditar extends ABaseNamed
{

    public ProjetoEditar()
    {
        this.projeto = new Projeto();
        carregarDadosIniciais();
        criarGraficosTela();
        
    }
    
    private void criarGraficosTela()
    {
        graficoCusto = inicializarBarrasDoGrafico();
        graficoCusto.setTitle("CUSTO -  TAP / PROJETO");
        graficoCusto.setAnimate(true);
        graficoCusto.setLegendPosition("ne");
        
        Axis yAxis = graficoCusto.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
        yAxis = graficoCusto.getAxis(AxisType.Y);
        
        yAxis.setMin(0);
        if(projeto.getTap().getCusto() <= projeto.getInvestimento())
             yAxis.setMax(projeto.getInvestimento()*2);
        else
             yAxis.setMax(projeto.getTap().getCusto());
       
       
    }
    
    private BarChartModel inicializarBarrasDoGrafico() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries tap = new ChartSeries();
        tap.setLabel("TAP");
        tap.set("Custo R$", projeto.getTap().getCusto());
        
 
        ChartSeries proj= new ChartSeries();
        proj.setLabel("PROJETO");
        proj.set("Custo R$", projeto.getInvestimento());

 
        model.addSeries(tap);
        model.addSeries(proj);
         
        return model;
    }
    
    private void carregarDadosIniciais()
    {
        try
        {
            int IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
            this.projeto.setID(IDProjeto);
            this.projeto = projeto.consultarPorID();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
        }
    }

    public void excluir()
    {
        try
        {
            projeto.excluir();
            Response.redirect("/web/faces/views/projetos/ProjetoConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o projeto!");
        }
    }

    public void editar()
    {
        try
        {
            projeto.editar();
            Mensageiro.mensagemInfo("Projeto atualizado com sucesso");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar o projeto!");
        }
    }

    public void fileUploadImagem(FileUploadEvent event) throws Exception
    {
        imagem = event.getFile();
        novoNomeImagem = new java.util.Date().getTime() + "";

        caminhoImagemServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/img/diagramas/uml/" + novoNomeImagem;

        arquivoImagem = event.getFile().getContents();
    }

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public String getImagem()
    {
        if (imagem != null)
        {
            return imagem.getFileName();
        } else
        {
            return "Nenhuma imagem adicionada!";
        }
    }

    public int getTipoDiagramaSelecionado()
    {
        return tipoDiagramaSelecionado;
    }

    public void setTipoDiagramaSelecionado(int tipoDiagramaSelecionado)
    {
        this.tipoDiagramaSelecionado = tipoDiagramaSelecionado;
    }

    public Map<String, Integer> listarTiposDiagramUML() throws Exception
    {
        try
        {
            DiagramaUMLTipo tipo = new DiagramaUMLTipo();
            Map<String, Integer> mapTipos = new HashMap<>();

            for (DiagramaUMLTipo obj : tipo.listar())
            {
                mapTipos.put(obj.getDescricao(), obj.getID());
            }
            return mapTipos;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar os tipos de diagramas do projeto!");
        }
        return null;
    }

    public void salvarDiagrama()
    {
        try
        {
            if (tipoDiagramaSelecionado != 0)
            {
                DiagramaUML diagrama = new DiagramaUML();
                DiagramaUMLTipo tipoDiagrama = new DiagramaUMLTipo();

                FileOutputStream fos;
                fos = new FileOutputStream(caminhoImagemServidor);
                fos.write(arquivoImagem);
                fos.close();

                diagrama.setProjeto(projeto);
                tipoDiagrama.setID(tipoDiagramaSelecionado);
                diagrama.setImagem(novoNomeImagem);
                diagrama.setDiagramaUMLTipo(tipoDiagrama);
                diagrama.cadastrar();

                Response.redirect("/web/faces/views/projetos/ProjetoEditar.xhtml?Projeto=" + Criptografia.codificarParaBase64(projeto.getID().toString()));
            } else
            {
                Mensageiro.mensagemInfo("Não foi selecionado o tipo de diagrama UML!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao salvar diagrama UML");
        }

    }

    public List<DiagramaUML> listarDiagramasUMLDoProjeto()
    {
        try
        {
            DiagramaUML diagrama = new DiagramaUML();
            diagrama.setProjeto(projeto);
            
            return diagrama.listarPorIDProjeto();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar os diagramas do projeto!!");
        }
        return null;
    }
    
    public BarChartModel getGraficoCusto() {
        return graficoCusto;
    }
    

    private Projeto projeto;
    private UploadedFile imagem;
    private BarChartModel graficoCusto;
    private int tipoDiagramaSelecionado;
    private String caminhoImagemServidor;
    private byte[] arquivoImagem;
    private String novoNomeImagem;
}
