package model.projeto;

import java.util.List;
import annotations.projeto.DiagramaUML;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class DiagramaUMLModel extends ABaseModel
{

    public List<DiagramaUML> listarPorIDProjeto(DiagramaUML diagramaUML) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select d from DiagramaUML d join d.projeto p join d.diagramaUMLTipo u where d.projeto.ID = :IDProjeto");
            consulta.setInteger("IDProjeto", diagramaUML.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DiagramaUML> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUML");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

}
