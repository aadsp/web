package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAPTipo;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EAPTipoModel implements ICRUD
{

    private final Session sessao;

    public EAPTipoModel()
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

    public EAPTipo consultarPorID(EAPTipo eapTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPTipo where ID = :ID");
            consulta.setInteger("ID", eapTipo.getID());
            return (EAPTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAPTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPTipo> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPTipo where " + filtro);
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
