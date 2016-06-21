package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.RequisitosHistoria;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RequisitosHistoriaModel implements ICRUD
{

    private final Session sessao;

    public RequisitosHistoriaModel()
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

    public RequisitosHistoria consultarPorID(RequisitosHistoria requisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("from RequisitosHistoria where ID = :ID");
            consulta.setInteger("ID", requisitos.getID());
            return (RequisitosHistoria) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<RequisitosHistoria> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from RequisitosHistoria");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }
    
    public List<RequisitosHistoria> listarPorDocumentoRequisitos(RequisitosHistoria requisitos) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select r from RequisitosHistoria r join r.documentoRequisitos dr where dr.ID = :ID");
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

    public List<RequisitosHistoria> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from RequisitosHistoria where " + filtro);
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
