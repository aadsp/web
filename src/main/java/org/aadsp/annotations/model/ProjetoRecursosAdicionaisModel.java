package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.ProjetoRecursosAdicionais;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjetoRecursosAdicionaisModel implements ICRUD
{

    private final Session sessao;

    public ProjetoRecursosAdicionaisModel()
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

    public ProjetoRecursosAdicionais consultarPorID(ProjetoRecursosAdicionais projetoRecursosAdicionais)
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoRecursosAdicionais where ID = :ID");
            consulta.setInteger("ID", projetoRecursosAdicionais.getID());
            return (ProjetoRecursosAdicionais) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<ProjetoRecursosAdicionais> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoRecursosAdicionais");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }
    
    public List<ProjetoRecursosAdicionais> listarPorProjeto(ProjetoRecursosAdicionais projetoRecursosAdicionais) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select ra from ProjetoRecursosAdicionais ra join ra.projeto p where p.ID = :ID");
             consulta.setInteger("ID", projetoRecursosAdicionais.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoRecursosAdicionais> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoRecursosAdicionais where " + filtro);
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
