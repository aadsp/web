package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Responsavel;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResponsavelModel implements ICRUD
{

    private final Session sessao;

    public ResponsavelModel()
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

    public Responsavel consultar(Responsavel pagina)
    {
        try
        {
            Query consulta = sessao.createQuery("from Responsavel where ID = :ID");
            consulta.setInteger("ID", pagina.getID());
            return (Responsavel) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Responsavel> listarPorIDTap(Responsavel responsavel) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Responsavel where ID_tap = :ID_tap");
            consulta.setInteger("ID_tap", responsavel.getTap().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Responsavel consultarPorIDTapIDUsuario(Responsavel responsavel) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Responsavel where ID_tap = :ID_tap and ID_usuario = :ID_usuario");
            consulta.setInteger("ID_tap", responsavel.getTap().getID());
            consulta.setInteger("ID_usuario", responsavel.getUsuario().getID());
            return (Responsavel) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

}
