package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DocumentoRequisitosModel implements ICRUD
{

    private final Session sessao;

    public DocumentoRequisitosModel()
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

    public DocumentoRequisitos consultarPorID(DocumentoRequisitos documentoRequisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitos where ID = :ID");
            consulta.setInteger("ID", documentoRequisitos.getID());
            return (DocumentoRequisitos) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public DocumentoRequisitos consultarPorIDProjeto(DocumentoRequisitos documentoRequisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("Select dr from DocumentoRequisitos dr  where dr.projeto.ID = :ID");
            consulta.setInteger("ID", documentoRequisitos.getProjeto().getID());
            return (DocumentoRequisitos) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitos> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitos");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitos> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitos where " + filtro);
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
