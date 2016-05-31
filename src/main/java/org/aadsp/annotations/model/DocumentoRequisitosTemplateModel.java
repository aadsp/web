package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.annotations.DocumentoRequisitosTemplate;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DocumentoRequisitosTemplateModel implements ICRUD
{

    private final Session sessao;

    public DocumentoRequisitosTemplateModel()
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

    public DocumentoRequisitosTemplate consultarPorID(DocumentoRequisitosTemplate documentoRequisitosTemplate)
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTemplate where ID = :ID");
            consulta.setInteger("ID", documentoRequisitosTemplate.getID());
            return (DocumentoRequisitosTemplate) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<DocumentoRequisitosTemplate> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTemplate");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitosTemplate> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTemplate where " + filtro);
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
