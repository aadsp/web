package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DiagramaUMLTipo;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class DiagramaUMLTipoModel extends ABaseModel
{

    public DiagramaUMLTipo consultarPorID(DiagramaUMLTipo diagramaUMLTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUMLTipo where ID = :ID");
            consulta.setInteger("ID", diagramaUMLTipo.getID());
            return (DiagramaUMLTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<DiagramaUMLTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUMLTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DiagramaUMLTipo> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUMLTipo where " + filtro);
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
