package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Patrocinador;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class PatrocinadorModel extends ABaseModel
{

    public Patrocinador consultarPorID(Pagina pagina)
    {
        try
        {
            Query consulta = sessao.createQuery("from Patrocinador where ID = :ID");
            consulta.setInteger("ID", pagina.getID());
            return (Patrocinador) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Patrocinador> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Patrocinador");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Patrocinador consultarPorID(Patrocinador patrocinador) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Patrocinador where ID = :ID");
            consulta.setInteger("ID", patrocinador.getID());
            return (Patrocinador) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Patrocinador> listarPorIDTap(Patrocinador patrocinador) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select p from Patrocinador p join p.empresa e join p.stakeholder s JOIN p.tap t where t.ID = :ID_tap");
            consulta.setInteger("ID_tap", patrocinador.getTap().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Patrocinador> listarPorEmpresas(Patrocinador patrocinador) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Patrocinador where ID_tap = :ID_tap and ID_empresa != NULL");
            consulta.setInteger("ID_tap", patrocinador.getTap().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Patrocinador> listarPorStakeholder(Patrocinador patrocinador) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Patrocinador where ID_tap = :ID_tap and ID_stakeholder != NULL");
            consulta.setInteger("ID_tap", patrocinador.getTap().getID());
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
