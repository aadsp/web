
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
import org.aadsp.annotations.Equipe;
import org.aadsp.annotations.Funcao;
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

/**
 * Classe que representa o objeto de tela TAP Cadastrar
 * @author Felipe Coelho
 * @version  25/04/2016
 */
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
       try{
        int TAPID = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("TAP")));
        tap.setID(TAPID);
        tap = tap.consultar();
        dataFim = tap.getDataFim();
        dataInicio = tap.getDataInicio();
       }catch(Exception e)
       {
           Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
       }
    }
    
    public void addEscopo() throws IOException
    {
        tapEscopo.setID_escopoArea(tapAreaSelecionado);
        tapEscopo.setID_escopoTipo(tapTipoSelecionado);
        tapEscopo.setID_tap(tap.getID());
        tapEscopo.cadastrar();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
    
    public void addPatrocinador()
    {
    
    }
    
    
    public void addStakeholder(Stakeholder stakeholder) throws IOException
    {
        StakeholderTAP stakeholderTap = new StakeholderTAP();
        stakeholderTap.setID_stakeholder(stakeholder.getID());
        stakeholderTap.setID_tap(tap.getID());
        stakeholderTap.cadastrar();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
    
    public List<Funcao> listarFuncoes() throws Exception
    {
        Equipe equipe = new Equipe();
        Funcao funcao = new Funcao();
        equipe.setID_tap(tap.getID());
        List<Equipe> listaEquipe = equipe.listar();
        List<Funcao> listaFuncoe = funcao.listar();
        List<Funcao> listaFuncoesDisponiveis = new ArrayList<>();
        
        List<Integer> listaFuncoes = new ArrayList<>();
        
        for(Equipe ObjEquipe: listaEquipe){
            listaFuncoes.add(ObjEquipe.getID_funcao());
        }
        for(Funcao ObjFuncao: listaFuncoe){
           if(!listaFuncoes.contains(ObjFuncao.getID()))
               listaFuncoesDisponiveis.add(ObjFuncao);
        }
        return listaFuncoesDisponiveis;
    }
    
    public List<Equipe> listarEquipe() throws Exception
    {
        Equipe equipe = new Equipe();
        equipe.setID_tap(tap.getID());
        return equipe.listarPorTAP();
    }
    
    public void removerEquipe(Equipe equipe) throws IOException
    {
        equipe.excluir();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
    
    public List<StakeholderTAP> listarStakeholderTAP() throws Exception
    {
        StakeholderTAP stakeholder = new StakeholderTAP();
        stakeholder.setID_tap(tap.getID());
        return stakeholder.listarPorIDTAP();
    }
    
    public void removerStakeholderTAP(StakeholderTAP stakeholderTAP) throws IOException
    {
        stakeholderTAP.excluir();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
    
    public void addFuncoes(Funcao funcao) throws IOException
    {
      Equipe equipe = new Equipe();
      equipe.setID_funcao(funcao.getID());
      equipe.setID_tap(tap.getID());
      equipe.cadastrar();
      Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
   
    public void editar()
    {
      try
      {
        tap.setDataCriacao(new java.sql.Date(new Date().getTime()));
        tap.atualizar();
        Mensageiro.mensagemInfo("O TAP foi atualizado com sucesso!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível atualizar o TAP!");
      }
    }
    
    public void excluir()
    {
      try
      {
        tap.deletar();
        Mensageiro.mensagemInfo("O TAP foi excluido com sucesso!");
      }catch(Exception e)
      {
          Mensageiro.mensagemError("Não foi possível excluir o TAP!");
      }
    }
    
    public List<Usuario> listarUsuarios() throws Exception 
    {
        Usuario usuario = new Usuario();
        Responsavel reponsavel = new Responsavel();
        reponsavel.setID_tap(tap.getID());
        List<Usuario> listaUsuarios = usuario.listar();
        List<Usuario> listaUsuariosDisponivel = new ArrayList<>();

        List<Responsavel> listaResponsavel = reponsavel.listarPorIDTAP();
        
        List<Integer> listaIDUsuriosResponsavel = new ArrayList<>();
        
        for(Responsavel ObjResponsavel: listaResponsavel){
            listaIDUsuriosResponsavel.add(ObjResponsavel.getID_usuario());
        }
        for(Usuario ObjUsuario: listaUsuarios){
           if(!listaIDUsuriosResponsavel.contains(ObjUsuario.getID()))
               listaUsuariosDisponivel.add(ObjUsuario);
        }
         return listaUsuariosDisponivel;
    }
    
    public List<Usuario> listarResponsaveis() throws Exception
    {
        Usuario usuario = new Usuario();
        Responsavel reponsavel = new Responsavel();
        reponsavel.setID_tap(tap.getID());
        List<Usuario> listaUsuarios = usuario.listar();
        List<Usuario> listaUsuariosDisponivel = new ArrayList<>();

        List<Responsavel> listaResponsavel = reponsavel.listarPorIDTAP();
        
        List<Integer> listaIDUsuriosResponsavel = new ArrayList<>();
        
        for(Responsavel ObjResponsavel: listaResponsavel){
            listaIDUsuriosResponsavel.add(ObjResponsavel.getID_usuario());
        }
        for(Usuario ObjUsuario: listaUsuarios){
           if(listaIDUsuriosResponsavel.contains(ObjUsuario.getID()))
               listaUsuariosDisponivel.add(ObjUsuario);
        }
         return listaUsuariosDisponivel;
    }        
    
    public void removerResponsavel(Usuario usuario) throws IOException, Exception
    {
        Responsavel responsavel = new Responsavel();
        responsavel.setID_usuario(usuario.getID());
        responsavel.setID_tap(tap.getID());
        responsavel = responsavel.consultarReposanvelPorIDUsuario();
        responsavel.excluir();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
            
    public void addResponsavel(Usuario usuario) throws IOException
    {
        Responsavel resposavel = new Responsavel();
        resposavel.setID_usuario(usuario.getID());
        resposavel.setID_tap(tap.getID());
        resposavel.cadastrar();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
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

    public TAP getTap() {
        return tap;
    }

    public void setTap(TAP tap) {
        this.tap = tap;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date date) 
    {
       java.sql.Date dataSql = new java.sql.Date(date.getTime());
       this.tap.setDataFim(dataSql);
    }
    
     public Map<String,Integer> getTAPAreas(){
       try{
          TAPEscopoArea area = new TAPEscopoArea();
          List<TAPEscopoArea> lista = area.listar();
       for(TAPEscopoArea obj: lista){
           tapAreas.put(obj.getDescricao(),obj.getID());
       }
       return tapAreas;
       }catch(Exception e){
           Mensageiro.mensagemError("Não foi possível consultar as funções no banco de dados!");
       }
        return null;
    }
    
    public Map<String,Integer> getTAPTipos(){
       try{
           TAPEscopoTipo tipo = new TAPEscopoTipo();
            List<TAPEscopoTipo> lista = tipo.listar();
       for(TAPEscopoTipo obj: lista){
           tapTipos.put(obj.getDescricao(),obj.getID());
       }
       return tapTipos;
       }catch(Exception e){
           Mensageiro.mensagemError("Não foi possível consultar as páginas no banco de dados!");
       }
        return null;
    }

    public TAPEscopo getTapEscopo() {
        return tapEscopo;
    }

    public void setTapEscopo(TAPEscopo tapEscopo) {
        this.tapEscopo = tapEscopo;
    }

    public int getTapAreaSelecionado() {
        return tapAreaSelecionado;
    }

    public void setTapAreaSelecionado(int tapAreaSelecionado) {
        this.tapAreaSelecionado = tapAreaSelecionado;
    }

    public int getTapTipoSelecionado() {
        return tapTipoSelecionado;
    }

    public void setTapTipoSelecionado(int tapTipoSelecionado) {
        this.tapTipoSelecionado = tapTipoSelecionado;
    }
    
    public void removerEscopo(TAPEscopo escopo) throws IOException
    {
        escopo.excluir();
        Response.redirect("/web/faces/views/projetos/TAPEditar.xhtml?TAP="+ Criptografia.codificarParaBase64(tap.getID().toString()));
    }
    
    public List<TAPEscopo> listarEscopo() throws Exception
    {
        return tapEscopo.listar();
    }
        
    public List<Stakeholder> listarStakeholders() throws Exception 
    {
        Stakeholder usuario = new Stakeholder();
        StakeholderTAP stakeholder = new StakeholderTAP();
        stakeholder.setID_tap(tap.getID());
        
        List<Stakeholder> listaStakeholder = usuario.listar();
        List<Stakeholder> listaStakeholderDisponivel = new ArrayList<>();

        List<StakeholderTAP> listaStakeholderTAP = stakeholder.listarPorIDTAP();
        
        List<Integer> listaIDStakeholder = new ArrayList<>();
        
        for(StakeholderTAP obj: listaStakeholderTAP){
            listaIDStakeholder.add(obj.getID_stakeholder());
        }
        for(Stakeholder obj: listaStakeholder){
           if(!listaIDStakeholder.contains(obj.getID()))
               listaStakeholderDisponivel.add(obj);
        }
         return listaStakeholderDisponivel;
    }
    
    
    private TAP tap;
    private Date dataInicio;
    private Date dataFim;
    private int tapAreaSelecionado;
    private int tapTipoSelecionado;
    private Map<String,Integer> tapAreas;
    private Map<String,Integer> tapTipos;
    private TAPEscopo tapEscopo;
}
