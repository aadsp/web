package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.TAPEscopoTipo;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TAPEscopoTipoModel implements ICRUD
{

    private final Session sessao;

    public TAPEscopoTipoModel()
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
