package org.aadsp.controller.named.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.Empresa;
import org.aadsp.annotations.Equipe;
import org.aadsp.annotations.Funcao;
import org.aadsp.annotations.Patrocinador;
import org.aadsp.annotations.Responsavel;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.annotations.StakeholderTAP;
import org.aadsp.annotations.TAP;
import org.aadsp.annotations.TAPEscopo;
import org.aadsp.annotations.TAPEscopoArea;
import org.aadsp.annotations.TAPEscopoTipo;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

@ViewScoped
@Named
public class TAPEditar extends ABaseNamed
{

    public TAPEditar()
    {
        dataInicio = new Date(new Date().getTime());
        dataFim = new Date(new Date().getTime());
        tapEscopo = new TAPEscopo();
        this.tap = new TAP();
        tapAreas = new HashMap<>();
        tapTipos = new HashMap<>();
        carregarDadosIniciais();
    }

    public void carregarDadosIniciais()
    {
        try
        {
            int TAPID = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("TAP")));
            tap.setID(TAPID);
            tap = tap.consultar();
            dataFim = tap.getDataFim();
            dataInicio = tap.getDataInicio();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
        }
    }

    public void addEscopo() throws IOException
    {
        TAPEscopoArea escopoArea = new TAPEscopoArea();
        TAPEscopoTipo escopoTipo = new TAPEscopoTipo();
        escopoArea.setID(tapAreaSelecionado);
        escopoTipo.setID(tapTipoSelecionado);

        tapEscopo.setEscopoArea(escopoArea);
        tapEscopo.setEscopoTipo(escopoTipo);
        tapEscopo.setTap(tap);
        tapEscopo.cadastrar();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
    }

    public void addPatrocinador()
    {

    }

    public void addStakeholder(Stakeholder stakeholder)
    {
        try
        {
            StakeholderTAP stakeholderTap = new StakeholderTAP();
            stakeholderTap.setStakeholder(stakeholder);
            stakeholderTap.setTap(tap);
            stakeholderTap.cadastrar();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
    }

    public List<Funcao> listarFuncoes()
    {
        List<Funcao> listaFuncoesDisponiveis = new ArrayList<>();
        try
        {
            Equipe equipe = new Equipe();
            Funcao funcao = new Funcao();
            equipe.setTap(tap);
            List<Equipe> listaEquipe = equipe.listar();
            List<Funcao> listaFuncoe = funcao.listar();
            List<Integer> listaFuncoes = new ArrayList<>();

            for (Equipe ObjEquipe : listaEquipe)
            {
                listaFuncoes.add(ObjEquipe.getFuncao().getID());
            }
            for (Funcao ObjFuncao : listaFuncoe)
            {
                if (!listaFuncoes.contains(ObjFuncao.getID()))
                {
                    listaFuncoesDisponiveis.add(ObjFuncao);
                }
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
        return listaFuncoesDisponiveis;
    }

    public List<Equipe> listarEquipe()
    {
        Equipe equipe = new Equipe();
        try
        {
            equipe.setTap(tap);
            return equipe.listarPorTAP();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void removerEquipe(Equipe equipe)
    {
        try
        {
            equipe.excluir();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
    }

    public List<StakeholderTAP> listarStakeholderTAP()
    {
        try
        {
            StakeholderTAP stakeholderTap = new StakeholderTAP();
            stakeholderTap.setTap(tap);
            return stakeholderTap.listarPorIDTAP();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void removerStakeholderTAP(StakeholderTAP stakeholderTAP)
    {
        try
        {
            stakeholderTAP.excluir();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
    }

    public void addFuncoes(Funcao funcao) throws IOException
    {
        try
        {
            Equipe equipe = new Equipe();
            equipe.setFuncao(funcao);
            equipe.setTap(tap);
            equipe.cadastrar();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
    }

    public void editar()
    {
        try
        {
            tap.setDataCriacao(new java.sql.Date(new Date().getTime()));
            tap.editar();
            Mensageiro.mensagemInfo("O TAP foi atualizado com sucesso!");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível atualizar o TAP!");
        }
    }

    public void excluir()
    {
        try
        {
            tap.excluir();
            Response.redirect("/web/faces/views/projetos/TAPConsultar.xhtml");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível excluir o TAP!");
        }
    }

    public List<Usuario> listarUsuarios() throws Exception
    {
        Usuario usuario = new Usuario();
        Responsavel reponsavel = new Responsavel();
        reponsavel.setTap(tap);
        List<Usuario> listaUsuarios = usuario.listar();
        List<Usuario> listaUsuariosDisponivel = new ArrayList<>();

        List<Responsavel> listaResponsavel = reponsavel.listarPorIDTAP();

        List<Integer> listaIDUsuriosResponsavel = new ArrayList<>();

        for (Responsavel ObjResponsavel : listaResponsavel)
        {
            listaIDUsuriosResponsavel.add(ObjResponsavel.getUsuario().getID());
        }
        for (Usuario ObjUsuario : listaUsuarios)
        {
            if (!listaIDUsuriosResponsavel.contains(ObjUsuario.getID()))
            {
                listaUsuariosDisponivel.add(ObjUsuario);
            }
        }
        return listaUsuariosDisponivel;
    }

    public List<Usuario> listarResponsaveis() throws Exception
    {
        List<Usuario> listaUsuariosDisponivel = new ArrayList<>();
        try
        {
            Usuario usuario = new Usuario();
            Responsavel reponsavel = new Responsavel();
            reponsavel.setTap(tap);
            List<Usuario> listaUsuarios = usuario.listar();

            List<Responsavel> listaResponsavel = reponsavel.listarPorIDTAP();

            List<Integer> listaIDUsuriosResponsavel = new ArrayList<>();

            for (Responsavel ObjResponsavel : listaResponsavel)
            {
                listaIDUsuriosResponsavel.add(ObjResponsavel.getUsuario().getID());
            }
            for (Usuario ObjUsuario : listaUsuarios)
            {
                if (listaIDUsuriosResponsavel.contains(ObjUsuario.getID()))
                {
                    listaUsuariosDisponivel.add(ObjUsuario);
                }
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
        return listaUsuariosDisponivel;
    }

    public void removerResponsavel(Usuario usuario)
    {
        try
        {
            Responsavel responsavel = new Responsavel();
            responsavel.setUsuario(usuario);
            responsavel.setTap(tap);
            responsavel = responsavel.consultarReposanvelPorIDUsuario();
            responsavel.excluir();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
        }
    }

    public void addResponsavel(Usuario usuario)
    {
        try
        {
            Responsavel resposavel = new Responsavel();
            resposavel.setUsuario(usuario);
            resposavel.setTap(tap);
            resposavel.cadastrar();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não possível executar está operação exception:" + e.getMessage());
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

    public Map<String, Integer> getTAPAreas()
    {
        try
        {
            TAPEscopoArea area = new TAPEscopoArea();
            List<TAPEscopoArea> lista = area.listar();
            for (TAPEscopoArea obj : lista)
            {
                tapAreas.put(obj.getDescricao(), obj.getID());
            }
            return tapAreas;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return null;
    }

    public Map<String, Integer> getTAPTipos()
    {
        try
        {
            TAPEscopoTipo tipo = new TAPEscopoTipo();
            List<TAPEscopoTipo> lista = tipo.listar();
            for (TAPEscopoTipo obj : lista)
            {
                tapTipos.put(obj.getDescricao(), obj.getID());
            }
            return tapTipos;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return null;
    }

    public TAPEscopo getTapEscopo()
    {
        return tapEscopo;
    }

    public void setTapEscopo(TAPEscopo tapEscopo)
    {
        this.tapEscopo = tapEscopo;
    }

    public int getTapAreaSelecionado()
    {
        return tapAreaSelecionado;
    }

    public void setTapAreaSelecionado(int tapAreaSelecionado)
    {
        this.tapAreaSelecionado = tapAreaSelecionado;
    }

    public int getTapTipoSelecionado()
    {
        return tapTipoSelecionado;
    }

    public void setTapTipoSelecionado(int tapTipoSelecionado)
    {
        this.tapTipoSelecionado = tapTipoSelecionado;
    }

    public void removerEscopo(TAPEscopo escopo)
    {
        try
        {
            escopo.excluir();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
    }

    public List<TAPEscopo> listarEscopo() throws Exception
    {
        try
        {
            tapEscopo.setTap(tap);
            return tapEscopo.listarIDTap();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<Stakeholder> listarStakeholders()
    {
        List<Stakeholder> listaStakeholderDisponivel = new ArrayList<>();

        try
        {
            Stakeholder usuario = new Stakeholder();
            StakeholderTAP stakeholder = new StakeholderTAP();
            stakeholder.setTap(tap);

            List<Stakeholder> listaStakeholder = usuario.listar();

            List<StakeholderTAP> listaStakeholderTAP = stakeholder.listarPorIDTAP();

            List<Integer> listaIDStakeholder = new ArrayList<>();

            for (StakeholderTAP obj : listaStakeholderTAP)
            {
                listaIDStakeholder.add(obj.getStakeholder().getID());
            }
            for (Stakeholder obj : listaStakeholder)
            {
                if (!listaIDStakeholder.contains(obj.getID()))
                {
                    listaStakeholderDisponivel.add(obj);
                }
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return listaStakeholderDisponivel;
    }

    public List<Empresa> listarEmpresasPatrocinadora()
    {
        List<Empresa> listaEmpresaDisponivel = new ArrayList<>();
        try
        {
            Empresa empresa = new Empresa();
            Patrocinador patrocniador = new Patrocinador();
            patrocniador.setTap(tap);

            List<Empresa> listaEmpresas = empresa.listar();

            List<Patrocinador> listaPatrocinador = patrocniador.listarPorIDTAP();

            List<Integer> listaIDStakeholder = new ArrayList<>();

            for (Patrocinador obj : listaPatrocinador)
            {
                listaIDStakeholder.add(obj.getEmpresa().getID());
            }
            for (Empresa obj : listaEmpresas)
            {
                if (!listaIDStakeholder.contains(obj.getID()))
                {
                    listaEmpresaDisponivel.add(obj);
                }
            }

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return listaEmpresaDisponivel;
    }

    public List<Stakeholder> listarStakeholderPatrocinador() throws Exception
    {
        List<Stakeholder> listaStakeholderDisponivel = new ArrayList<>();
        try
        {
            Stakeholder stakeholder = new Stakeholder();
            Patrocinador patrocniador = new Patrocinador();
            patrocniador.setTap(tap);

            List<Stakeholder> listaStakeholder = stakeholder.listar();

            List<Patrocinador> listaPatrocinador = patrocniador.listarPorIDTAP();

            List<Integer> listaIDStakeholder = new ArrayList<>();

            for (Patrocinador obj : listaPatrocinador)
            {
                listaIDStakeholder.add(obj.getStakeholder().getID());
            }
            for (Stakeholder obj : listaStakeholder)
            {
                if (!listaIDStakeholder.contains(obj.getID()))
                {
                    listaStakeholderDisponivel.add(obj);
                }
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return listaStakeholderDisponivel;
    }

    public void addEmpresaPatrocinador(Empresa empresa)
    {
        try
        {
            Patrocinador patrocinador = new Patrocinador();
            patrocinador.setEmpresa(empresa);
            patrocinador.setTap(tap);
            patrocinador.cadastrar();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
    }

    public void addStakeholderPatrocinador(Stakeholder stakeholder)
    {
        try
        {
            Patrocinador patrocinador = new Patrocinador();
            patrocinador.setStakeholder(stakeholder);
            patrocinador.setTap(tap);
            patrocinador.cadastrar();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (IOException e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
    }

    public List<Patrocinador> listarEmpresasPatrocinadoras()
    {
        try
        {
            Patrocinador patrocinador = new Patrocinador();
            patrocinador.setTap(tap);
            return patrocinador.listarPorEmpresas();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<Patrocinador> listarStakeholderPatrocinadores()
    {
        try
        {
            Patrocinador patrocinador = new Patrocinador();
            patrocinador.setTap(tap);
            return patrocinador.listarPorStakeholder();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void removerEmpresaPatrocinadora(Patrocinador patrocinador)
    {
        try
        {
            patrocinador.excluir();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
    }

    public void removerStakeholderPatrocinador(Patrocinador patrocinador) throws IOException, Exception
    {
        try
        {
            patrocinador.excluir();
            Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP=" + Criptografia.codificarParaBase64(tap.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível executar esta operação exception: " + e.getMessage());
        }
    }

    private TAP tap;
    private Date dataInicio;
    private Date dataFim;
    private int tapAreaSelecionado;
    private int tapTipoSelecionado;
    private Map<String, Integer> tapAreas;
    private Map<String, Integer> tapTipos;
    private TAPEscopo tapEscopo;
}
