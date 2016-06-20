package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Requisitos;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RequisitosModel implements ICRUD
{

    private final Session sessao;

    public RequisitosModel()
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

    public Requisitos consultarPorID(Requisitos requisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("from Requisitos where ID = :ID");
            consulta.setInteger("ID", requisitos.getID());
            return (Requisitos) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Requisitos> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Requisitos");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }
    
    public List<Requisitos> listarPorDocumentoRequisitos(Requisitos requisitos) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select r from Requisitos r join r.documentoRequisitos dr where dr.ID = :ID");
            consulta.setInteger("ID", requisitos.getDocumentoRequisitos().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Requisitos> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Requisitos where " + filtro);
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
