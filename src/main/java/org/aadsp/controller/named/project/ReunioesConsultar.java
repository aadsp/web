
package org.aadsp.controller.named.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRException;
import org.aadsp.annotations.Projeto;
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
public class ReunioesConsultar extends ABaseNamed
{
    
   public ReunioesConsultar()
   {
       this.projeto = new Projeto();
   }
   
   public List<Projeto> listarProjetos()
   {
       try{
       return this.projeto.listar();
       }catch(Exception e){
           Mensageiro.mensagemError("Erro ao listar os projetos!!");
       }
       return null;
   }
   
   public void editar(Projeto projeto) 
   {
       try
       {
        Response.redirect("/web/faces/views/projetos/ATAConsultar.xhtml?Projeto="+ Criptografia.codificarParaBase64(projeto.getID().toString()));
       }catch(Exception e)
       {
         Mensageiro.mensagemError("Erro ao selecionar Projeto!!");
       }
   }
   
   public void gerarPDF(Projeto projeto) throws JRException, IOException, SQLException
   {
      
   }
   
   private Projeto projeto;
    
}
