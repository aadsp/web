package model.tap;

import java.util.List;
import annotations.tap.TAP;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class TAPModel extends ABaseModel
{

    public TAP consultarPorID(TAP tap) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAP where ID = :ID");
            consulta.setInteger("ID", tap.getID());
            return (TAP) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<TAP> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAP");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<TAP> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAP where " + filtro);
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
