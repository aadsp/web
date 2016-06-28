package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.TAPEscopoTipo;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class TAPEscopoTipoModel extends ABaseModel
{

    public TAPEscopoTipo consultarPorID(TAPEscopoTipo tap)
    {
        try
        {
            Query consulta = sessao.createQuery("from TAPEscopoTipo where ID = :ID");
            consulta.setInteger("ID", tap.getID());
            return (TAPEscopoTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<TAPEscopoTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAPEscopoTipo");
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
