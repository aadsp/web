package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.TAPEscopoArea;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TAPEscopoAreaModel implements ICRUD
{

    private final Session sessao;

    public TAPEscopoAreaModel()
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
