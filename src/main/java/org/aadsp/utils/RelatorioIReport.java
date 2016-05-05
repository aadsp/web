
package org.aadsp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


public class RelatorioIReport 
{
    public void gerarPDF(String nomeRelatorio,Map parameters) throws JRException, IOException
    {
         String caminhoServidor = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
       
         InputStream inputStream = new FileInputStream (caminhoServidor+"/reports/model/"+nomeRelatorio+".jrxml");
         
         JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
         JasperExportManager.exportReportToPdfFile(jasperPrint, caminhoServidor+"/reports/tmp/"+nomeRelatorio+".pdf");
         
         Response.redirect("../../reports/tmp/"+nomeRelatorio+".pdf");
         
         File file = new File(caminhoServidor+"/reports/tmp/"+nomeRelatorio+".pdf");
         file.deleteOnExit();
    }
}
