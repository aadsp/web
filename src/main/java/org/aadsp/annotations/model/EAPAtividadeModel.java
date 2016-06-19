package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAPAtividade;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EAPAtividadeModel implements ICRUD
{

    private final Session sessao;

    public EAPAtividadeModel()
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

    public EAPAtividade consultarPorID(EAPAtividade eapAtividade)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPAtividade where ID = :ID");
            consulta.setInteger("ID", eapAtividade.getID());
            return (EAPAtividade) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAPAtividade> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPAtividade");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPAtividade> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPAtividade where " + filtro);
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
