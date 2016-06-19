package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAP;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EAPModel implements ICRUD
{

    private final Session sessao;

    public EAPModel()
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

    public EAP consultarPorID(EAP eap)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAP where ID = :ID");
            consulta.setInteger("ID", eap.getID());
            return (EAP) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAP> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAP");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAP> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAP where " + filtro);
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
