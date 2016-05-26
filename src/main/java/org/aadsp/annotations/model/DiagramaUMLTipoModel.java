package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DiagramaUMLTipo;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DiagramaUMLTipoModel implements ICRUD
{

    private final Session sessao;

    public DiagramaUMLTipoModel()
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

    public DiagramaUMLTipo consultarPorID(DiagramaUMLTipo diagramaUMLTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUMLTipo where ID = :ID");
            consulta.setInteger("ID", diagramaUMLTipo.getID());
            return (DiagramaUMLTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<DiagramaUMLTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUMLTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DiagramaUMLTipo> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUMLTipo where " + filtro);
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
