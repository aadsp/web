package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Acesso;
import org.aadsp.annotations.Pagina;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AcessoModel implements ICRUD
{

    private final Session sessao;

    public AcessoModel()
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

    public List<Acesso> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Acesso");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Acesso> listar(Acesso acesso) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Acesso where ID_funcao = :ID_funcao");
            consulta.setInteger("ID_funcao", acesso.getFuncao().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Acesso consultar(Acesso acesso) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Acesso where ID = :ID");
            consulta.setInteger("ID", acesso.getID());
            return (Acesso) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Acesso registrada(Acesso acesso) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Acesso where ID_funcao = :ID_funcao and ID_pagina = :ID_pagina");
            consulta.setInteger("ID_funcao", acesso.getFuncao().getID());
            consulta.setInteger("ID_pagina", acesso.getPagina().getID());
            return (Acesso) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Acesso> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select a from Acesso a join a.funcao f join a.pagina p where " + filtro);
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
