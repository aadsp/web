package org.aadsp.controller.named.adm;

import java.io.File;
import java.io.FileOutputStream;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.interfaces.ICadastro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Session;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * @author Felipe Coelho
 * @version 25/04/2016
 */
@ViewScoped
@Named
public class AlterarImagem extends ABaseNamed implements ICadastro
{

    public void alterar()
    {
        try
        {

            Usuario usuario = (Usuario) Session.getAttribute("usuario");
                
            FileOutputStream fos;
            fos = new FileOutputStream(caminhoImagemServidor);
            fos.write(arquivoImagem);
            fos.close();
            
            String caminhoServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
            
            File file = new File(caminhoServidor + "/img/user/" + usuario.getImagem());
            file.delete();
            
            usuario.setImagem(novoNomeImagem);
            usuario.editar();
            
            Mensageiro.mensagemInfo("Imagem do usuário alterada com sucesso!!");

        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível alterar a senha!");
        }
    }
    
    public void fileUploadImagem(FileUploadEvent event) throws Exception
    {
        imagem = event.getFile();
        novoNomeImagem = new java.util.Date().getTime() + "";

        caminhoImagemServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/img/user/" + novoNomeImagem;

        arquivoImagem = event.getFile().getContents();
    }


    public UploadedFile getImagem()
    {
        return imagem;
    }
    
    private UploadedFile imagem;
    private String caminhoImagemServidor;
    private byte[] arquivoImagem;
    private String novoNomeImagem;

    @Override
    public boolean controleDeCadastro()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
