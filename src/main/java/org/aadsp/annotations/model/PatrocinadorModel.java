package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Patrocinador;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatrocinadorModel implements ICRUD
{

    private final Session sessao;

    public PatrocinadorModel()
    {
        this.sessao = FactoryHibernate.getSessionFactory().openSession();
    }

    @Override
    public void salvar(Object obj)
    {
        Transaction transacao = sessao.beginTransaction();
        sessao.save(obj);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void atualizar(Object obj)
    {
        Transaction transacao = sessao.beginTransaction();
        sessao.update(obj);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void excluir(Object obj)
    {
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(obj);
        transacao.commit();
        sessao.close();
    }

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
