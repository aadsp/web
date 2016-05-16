
package org.aadsp.controller.named.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import org.aadsp.annotations.Projeto;
import org.aadsp.annotations.ReuniaoAta;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 * @author Felipe Coelho
 * @version  24/04/2016
 */
@ViewScoped
@Named
public class ATAConsultar extends ABaseNamed
{
    
   public ATAConsultar()
   {
       this.reuniaoAta = new ReuniaoAta();
       carregarDadosIniciais();
   }
   
   public void carregarDadosIniciais()
    {
       try{
        int IDProjeto = Integer.parseInt(Criptografia.decodificarBase64(Response.getParametroURL("Projeto")));
        reuniaoAta.setID_projeto(IDProjeto);
       }catch(Exception e)
       {
           Mensageiro.mensagemError("Erro ao carregar dados iniciais!!");
       }
    }
   
   public List<ReuniaoAta> listarAtas()
   {
       try{
       return this.reuniaoAta.listarPorProjeto();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar as Atas do projeto!!");
       }
       return null;
   }
   
   public void editar(Projeto projeto) 
   {
       try
       {
        Response.redirect("/web/faces/views/projetos/AtasEditar.xhtml?ATA="+ Criptografia.codificarParaBase64(projeto.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar Ata do Projeto!!");
       }
   }
   
   public void gerarPDF(ReuniaoAta reuniaoAta) throws JRException, IOException, SQLException
   {
      
   }
   
   private ReuniaoAta reuniaoAta;
    
}
