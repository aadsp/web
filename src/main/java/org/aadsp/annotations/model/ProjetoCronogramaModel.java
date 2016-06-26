package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Projeto;
import org.aadsp.annotations.ProjetoCronograma;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjetoCronogramaModel implements ICRUD
{

    private final Session sessao;

    public ProjetoCronogramaModel()
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

    public ProjetoCronograma consultarPorID(ProjetoCronograma projetoCronograma)
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from ProjetoCronograma c where c.ID = :ID");
            consulta.setInteger("ID", projetoCronograma.getID());
            return (ProjetoCronograma) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoCronograma> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoCronograma");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }
    
    public List<ProjetoCronograma> listarPorProjeto(ProjetoCronograma projetoCronograma) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from ProjetoCronograma c join c.projeto p where p.ID = :ID");
             consulta.setInteger("ID", projetoCronograma.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }
    
    public boolean verificarPeriodoInProjeto(ProjetoCronograma projetoCronograma)
    {
        try
        {
            Query consulta = sessao.createQuery("Select p from Projeto p where p.ID = :IDProjeto and  (p.dataInicio <= :dataInicio and p.dataTermino>= :dataTermino )");
            consulta.setInteger("IDProjeto", projetoCronograma.getProjeto().getID());
            consulta.setDate("dataInicio", projetoCronograma.getDataInicio());
            consulta.setDate("dataTermino", projetoCronograma.getDataTermino());
            Projeto projeto = (Projeto) consulta.uniqueResult();
            if(projeto != null)
            {
               return true;
            }
            
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
        return false;
    }

    public List<ProjetoCronograma> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from ProjetoCronograma c "
                    + "join c.projeto p where " + filtro);
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
