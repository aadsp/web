package org.aadsp.controller.named.project;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.DiagramaUML;
import org.aadsp.annotations.DiagramaUMLTipo;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.annotations.Projeto;
import org.aadsp.annotations.ProjetoTela;
import org.aadsp.annotations.RequisitosHistoria;
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
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ViewScoped
@Named
public class ProjetoEditar extends ABaseNamed
{

    public ProjetoEditar()
    {
        this.projeto = new Projeto();
        carregarDadosIniciais();
        criarGraficosTela();
        dataInicio = new Date(projeto.getDataInicio().getTime());
        dataFim = new Date(projeto.getDataTermino().getTime());
    }

    private void criarGraficosTela()
    {

        graficoCronograma = inicializarGraficoCronograma();
        graficoCronograma.setTitle("Cronograma do projeto");
        graficoCronograma.setAnimate(true);
        graficoCronograma.setLegendPosition("se");

        graficoCusto = inicializarGraficoCusto();
        graficoCusto.setTitle("CUSTO -  TAP / PROJETO");
        graficoCusto.setAnimate(true);
        graficoCusto.setLegendPosition("ne");

        Axis yAxis = graficoCusto.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
        yAxis = graficoCusto.getAxis(AxisType.Y);

        yAxis.setMin(0);
        if (projeto.getTap().getCusto() <= projeto.getInvestimento())
        {
            yAxis.setMax(projeto.getInvestimento() * 2);
        } else
        {
            yAxis.setMax(projeto.getTap().getCusto());
        }

    }

    private LineChartModel inicializarGraficoCronograma()
    {
        LineChartModel model = new LineChartModel();
        SimpleDateFormat formatoAnoMesDia = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();

        LineChartSeries tap = new LineChartSeries();
        tap.setLabel("Tap");
        calendar.setTime(projeto.getTap().getDataInicio());
        tap.set(formatoAnoMesDia.format(projeto.getTap().getDataInicio()), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(projeto.getTap().getDataFim());
        tap.set(formatoAnoMesDia.format(projeto.getTap().getDataFim()), calendar.get(Calendar.DAY_OF_MONTH));

        LineChartSeries proj = new LineChartSeries();
        proj.setLabel("Projeto");
        calendar.setTime(projeto.getDataInicio());
        proj.set(formatoAnoMesDia.format(projeto.getDataInicio()), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(projeto.getDataTermino());
        proj.set(formatoAnoMesDia.format(projeto.getDataTermino()), calendar.get(Calendar.DAY_OF_MONTH));

        model.addSeries(tap);
        model.addSeries(proj);

        model.setTitle("Zoom para detalhamento");
        model.setZoom(true);
        model.getAxis(AxisType.Y).setLabel("Dia");
        DateAxis axis = new DateAxis("Mês / Ano");
        axis.setTickAngle(0);
        axis.setMax(formatoAnoMesDia.format(projeto.getDataTermino()));
        axis.setTickFormat("%b, %y");

        model.getAxes().put(AxisType.X, axis);
        return model;
    }

    private BarChartModel inicializarGraficoCusto()
    {
        BarChartModel model = new BarChartModel();

        ChartSeries tap = new ChartSeries();
        tap.setLabel("TAP");
        tap.set("Custo R$", projeto.getTap().getCusto());

        ChartSeries proj = new ChartSeries();
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

    public Projeto getProjeto()
    {
        return projeto;
    }

    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }

    public BarChartModel getGraficoCusto()
    {
        return graficoCusto;
    }

    public LineChartModel getGraficoCronograma()
    {
        return graficoCronograma;
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

    public RequisitosHistoria getRequisito()
    {
        return requisito;
    }

    public void setRequisito(RequisitosHistoria requisito)
    {
        this.requisito = requisito;
    }

   
    private Projeto projeto;
    private RequisitosHistoria requisito;
    private BarChartModel graficoCusto;
    private LineChartModel graficoCronograma;
    private Date dataInicio;
    private Date dataFim;
}
