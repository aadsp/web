package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class StakeholderModel extends ABaseModel
{

    public Stakeholder consultarPorID(Stakeholder stakeholder)
    {
        try
        {
            Query consulta = sessao.createQuery("from Stakeholder where ID = :ID");
            consulta.setInteger("ID", stakeholder.getID());
            return (Stakeholder) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Stakeholder> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Stakeholder");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Stakeholder> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Stakeholder  where " + filtro);
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
