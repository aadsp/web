package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAPPacote;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EAPPacoteModel implements ICRUD
{

    private final Session sessao;

    public EAPPacoteModel()
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

    public EAPPacote consultarPorID(EAPPacote eapPacote)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPPacote where ID = :ID");
            consulta.setInteger("ID", eapPacote.getID());
            return (EAPPacote) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAPPacote> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPPacote");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPPacote> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPPacote where " + filtro);
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
