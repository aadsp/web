package controller.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import annotations.projeto.EAP;
import annotations.projeto.EAPAtividade;
import annotations.projeto.EAPPacote;
import annotations.projeto.EAPTipo;
import annotations.projeto.Projeto;
import interfaces.ABaseNamed;
import utils.Criptografia;
import utils.Mensageiro;
import utils.Response;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

/**
 * @author Felipe Coelho
 */
@ViewScoped
@Named
public class EAPEditar extends ABaseNamed
{

    public EAPEditar()
    {
        this.eap = new EAP();
        carregarDadosIniciais();
        this.tipoEAP = new EAPTipo();
        this.pacoteAtividade = new EAPPacote();
        this.pacotesAtividades = new HashMap<String, Integer>();
        this.eapTipos = new HashMap<String, Integer>();
        this.gerarVisualizacaoEAP();
    }

    private void carregarDadosIniciais()
    {
        try
        {
            int IDEAP = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("EAP")));
            this.eap.setID(IDEAP);
            this.eap = eap.consultarPorID();
            this.dataRealizacao = eap.getDataCriacao();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível carregar os dados iniciais da página");
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

    public void excluir()
    {
        try
        {
            eap.excluir();
            Response.redirect("/web/faces/views/projetos/EAPConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir a EAP, remova todas as atividades e tente novamente!");
        }
    }

    public void editar()
    {
        try
        {
            EAPTipo tipo = new EAPTipo();
            tipo.setID(tipoSelecionado);
            eap.setEapTipo(tipo);
            eap.editar();
            Mensageiro.mensagemInfo("EAP atualizada com sucesso!!");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar EAP!");
        }
    }

    public EAP getEap()
    {
        return eap;
    }

    public void setEap(EAP eap)
    {
        this.eap = eap;
    }

    public Date getDataRealizacao()
    {
        return dataRealizacao;
    }

    public void setDataCricao(Date date)
    {
        dataRealizacao = date;
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.eap.setDataCriacao(dataSql);
    }

    public Map<String, Integer> getEapTipos()
    {
        try
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
                if (!eapTiposProjeto.contains(obj.getID()) && !Objects.equals(eap.getEapTipo().getID(), obj.getID()))
                {
                    eapTipos.put(obj.getDescricao(), obj.getID());
                }
            }
            return eapTipos;

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar as Estruturas Analíticas desse projeto!");
        }
        return null;
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

    public String getTextoPacote()
    {
        return textoPacote;
    }

    public void setTextoPacote(String textoPacote)
    {
        this.textoPacote = textoPacote.toUpperCase();
    }

    public void salvarPacoteAtividade()
    {
        try
        {
            EAPPacote pacote = new EAPPacote();
            pacote.setProjeto(eap.getProjeto());
            pacote.setDescricao(textoPacote);
            pacote.cadastrar();
            Response.redirect("/web/faces/views/projetos/EAPEditar.xhtml?EAP=" + Criptografia.codificarParaBase64(eap.getID().toString()));

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao cadastrar um novo pacote de atividade!!");
        }
    }

    public void removerPacoteAtividade(EAPPacote pacote)
    {
        try
        {
            pacote.excluir();
            Response.redirect("/web/faces/views/projetos/EAPEditar.xhtml?EAP=" + Criptografia.codificarParaBase64(eap.getID().toString()));

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao remover pacote de atividade!!");
        }
    }

    public void removerAtividade(EAPAtividade atividade)
    {
        try
        {
            atividade.excluir();
            Response.redirect("/web/faces/views/projetos/EAPEditar.xhtml?EAP=" + Criptografia.codificarParaBase64(eap.getID().toString()));

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao remover atividade do pacote!!");
        }
    }

    public List<EAPPacote> listarPacotesAtividadesProjeto()
    {
        List<EAPPacote> lista = new ArrayList<>();
        try
        {
            EAPPacote pacote = new EAPPacote();
            pacote.setProjeto(eap.getProjeto());
            return pacote.listarPorProjeto();

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar pacotes de atividades!!");
        }
        return lista;
    }

    public Map<String, Integer> getEapPacotesAtividades()
    {
        try
        {
            pacoteAtividade.setProjeto(eap.getProjeto());
            List<EAPPacote> lista = pacoteAtividade.listarPorProjeto();

            for (EAPPacote obj : lista)
            {
                pacotesAtividades.put(obj.getDescricao(), obj.getID());
            }
            return pacotesAtividades;

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os pacotes de atividades desse projeto!");
        }
        return null;
    }

    public String getTextoAtividade()
    {
        return textoAtividade;
    }

    public void setTextoAtividade(String textoAtividade)
    {
        this.textoAtividade = textoAtividade.toUpperCase();
    }

    public int getPacoteSelecionado()
    {
        return pacoteSelecionado;
    }

    public void setPacoteSelecionado(int pacoteSelecionado)
    {
        this.pacoteSelecionado = pacoteSelecionado;
    }

    public void salvarAtividade()
    {
        try
        {
            if (pacoteSelecionado != 0)
            {
                EAPAtividade atividade = new EAPAtividade();
                atividade.setEap(eap);
                EAPPacote pacote = new EAPPacote();
                pacote.setID(pacoteSelecionado);
                pacote.consultarPorID();
                atividade.setEapPacote(pacote);
                atividade.setDescricao(textoAtividade);
                atividade.cadastrar();
                Response.redirect("/web/faces/views/projetos/EAPEditar.xhtml?EAP=" + Criptografia.codificarParaBase64(eap.getID().toString()));
            } else
            {
                Mensageiro.mensagemInfo("Deve ser selecionado um pacote para esta atividade!!");
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao cadastrar um nova atividade!!");
        }

    }

    public List<EAPAtividade> listarAtividadesEAP()
    {
        List<EAPAtividade> lista = new ArrayList<>();
        try
        {
            EAPAtividade atividade = new EAPAtividade();
            atividade.setEap(eap);
            lista = atividade.listarPorEAP();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível listar as atividades desta EAP!!");
        }
        return lista;
    }

    private void gerarVisualizacaoEAP()
    {
        try
        {
            visualizacaoEAP = new DefaultDiagramModel();
            visualizacaoEAP.setMaxConnections(-1);

            Element elementEAP = new Element("  " + eap.getEapTipo().getDescricao() + "  ", "20em", "6em");
            elementEAP.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM));

            visualizacaoEAP.addElement(elementEAP);

            List<EAPPacote> listaPacote = new ArrayList<>();
            EAPPacote pacote = new EAPPacote();
            pacote.setProjeto(eap.getProjeto());
            listaPacote = pacote.listarPorProjeto();
            int posicaoPacote = 10;
            for (EAPPacote obj : listaPacote)
            {

                Element elementPacote = new Element("  " + obj.getDescricao() + "  ", posicaoPacote + "em", "18em");
                elementPacote.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                elementPacote.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM));

                visualizacaoEAP.connect(new Connection(elementEAP.getEndPoints().get(0), elementPacote.getEndPoints().get(0)));
                visualizacaoEAP.addElement(elementPacote);

                List<EAPAtividade> listaAtividades = new ArrayList<>();
                int posicaoAtividade = 30;
                EAPAtividade atividade = new EAPAtividade();
                atividade.setEap(eap);
                listaAtividades = atividade.listarPorEAP();
                for (EAPAtividade objAtividade : listaAtividades)
                {
                    if (objAtividade.getEapPacote().getID() == obj.getID())
                    {
                        Element elementAtividade = new Element("  " + objAtividade.getDescricao() + "  ", posicaoPacote + "em", posicaoAtividade + "em");
                        elementAtividade.addEndPoint(new DotEndPoint(EndPointAnchor.LEFT));

                        visualizacaoEAP.connect(new Connection(elementPacote.getEndPoints().get(1), elementAtividade.getEndPoints().get(0)));
                        visualizacaoEAP.addElement(elementAtividade);

                        posicaoAtividade += 10;
                    }
                }

                posicaoPacote = +30;
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível projetar a visualização da EAP!!");
        }

    }

    public DefaultDiagramModel getVisualizacaoEAP()
    {
        return visualizacaoEAP;
    }

    private int pacoteSelecionado;
    private EAP eap;
    private String textoPacote;
    private String textoAtividade;
    private Date dataRealizacao;
    private int tipoSelecionado;
    private int projetoSelecionado;
    private EAPTipo tipoEAP;
    private EAPPacote pacoteAtividade;
    private Map<String, Integer> pacotesAtividades;
    private Map<String, Integer> eapTipos;
    private DefaultDiagramModel visualizacaoEAP;
}
