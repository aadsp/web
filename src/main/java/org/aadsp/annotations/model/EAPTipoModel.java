package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAPTipo;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class EAPTipoModel extends ABaseModel
{

    public EAPTipo consultarPorID(EAPTipo eapTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPTipo where ID = :ID");
            consulta.setInteger("ID", eapTipo.getID());
            return (EAPTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAPTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPTipo> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPTipo where " + filtro);
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
