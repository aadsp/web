
package org.aadsp.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class RelatorioIReport 
{
    public  void gerarPDF(List lista, String caminhoRel) throws JRException, IOException
    {
       String caminhoLogo = "/br/com/epneves/imagens/logo_relatorio.png";  
       HashMap  parametros = new HashMap();
       
       InputStream relatorio = getClass().getResourceAsStream(caminhoRel);
       ImageIcon gto = new ImageIcon(getClass().getResource(caminhoLogo));  
       parametros.put("LOGO",gto.getImage()); 
       JRBeanCollectionDataSource colection = new JRBeanCollectionDataSource(lista);  
       JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, colection);  
       //adicione
      JasperExportManager.exportReportToPdfFile(impressao, "C:/arquivo.pdf");
      Runtime.getRuntime().exec("cmd /c start C:/arquivo.pdf");
      File file = new File("C:/arquivo.pdf");
      file.deleteOnExit();
    }
}
