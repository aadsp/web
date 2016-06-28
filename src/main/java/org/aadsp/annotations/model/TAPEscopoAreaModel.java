package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.TAPEscopoArea;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class TAPEscopoAreaModel extends ABaseModel
{

    public TAPEscopoArea consultarPorID(TAPEscopoArea tap)
    {
        try
        {
            Query consulta = sessao.createQuery("from TAPEscopoArea where ID = :ID");
            consulta.setInteger("ID", tap.getID());
            return (TAPEscopoArea) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<TAPEscopoArea> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAPEscopoArea");
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
