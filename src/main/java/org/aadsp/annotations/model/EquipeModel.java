package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Equipe;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EquipeModel implements ICRUD
{

    private final Session sessao;

    public EquipeModel()
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

    public Equipe consultarPorID(Equipe equipe)
    {
        try
        {
            Query consulta = sessao.createQuery("from Equipe where ID = :ID");
            consulta.setInteger("ID", equipe.getID());
            return (Equipe) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Equipe> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Equipe");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Equipe> listarPorTAP(Equipe equipe) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Equipe where ID_tap = :ID_tap");
            consulta.setInteger("ID_tap", equipe.getTap().getID());
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
