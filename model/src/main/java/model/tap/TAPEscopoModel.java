package model.tap;

import java.util.List;
import annotations.tap.TAPEscopo;
import model.ABaseModel;
import org.hibernate.Query;

public class TAPEscopoModel extends ABaseModel
{

    public TAPEscopo consultarPorID(TAPEscopo tap)
    {
        try
        {
            Query consulta = sessao.createQuery("Select te from TAPEscopo te join te.tap t join te.escopoTipo e where te.ID = :ID");
            consulta.setInteger("ID", tap.getID());
            return (TAPEscopo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<TAPEscopo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select te from TAPEscopo te join te.tap t join te.escopoTipo e");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<TAPEscopo> listarIDTap(TAPEscopo tap) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select te from TAPEscopo te join te.tap t where t.ID = :ID_tap");
            consulta.setInteger("ID_tap", tap.getTap().getID());
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
