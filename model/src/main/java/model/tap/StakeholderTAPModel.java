package model.tap;

import java.util.List;
import annotations.tap.StakeholderTAP;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class StakeholderTAPModel extends ABaseModel
{

    public StakeholderTAP consultar(StakeholderTAP stakeholdertap)
    {
        try
        {
            Query consulta = sessao.createQuery("from StakeholderTAP where ID = :ID");
            consulta.setInteger("ID", stakeholdertap.getID());
            return (StakeholderTAP) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public StakeholderTAP consultarPorID(StakeholderTAP stakeholdertap)
    {
        try
        {
            Query consulta = sessao.createQuery("from StakeholderTAP where ID = :ID");
            consulta.setInteger("ID", stakeholdertap.getID());
            return (StakeholderTAP) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<StakeholderTAP> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from StakeholderTAP");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<StakeholderTAP> listarPorIDTap(StakeholderTAP stakeholder) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select st from StakeholderTAP st JOIN st.stakeholder s join st.tap where st.tap.ID  = :ID_tap");
            consulta.setInteger("ID_tap", stakeholder.getTap().getID());
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
