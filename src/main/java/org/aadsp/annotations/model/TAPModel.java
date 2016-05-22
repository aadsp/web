
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.TAP;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TAPModel implements ICRUD
{
     private final Session sessao;
    
    public TAPModel()
    {
       this.sessao = FactoryHibernate.getSessionFactory().openSession();
    }

    @Override
    public void salvar(Object obj) {
        Transaction transacao = sessao.beginTransaction();
        sessao.save(obj);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void atualizar(Object obj) {
        Transaction transacao = sessao.beginTransaction();
        sessao.update(obj);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void excluir(Object obj) {
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(obj);
        transacao.commit();
        sessao.close();
    }
    
    public TAP consultarPorID(TAP tap)throws Exception
    {
        try{   
            Query consulta = sessao.createQuery("from TAP where ID = :ID");
            consulta.setInteger("ID", tap.getID());
            return (TAP) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public List<TAP> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAP");
            return consulta.list();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            sessao.close();
        }
    }
    
     public List<TAP> listarPorFiltro(String filtro)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from TAP where " + filtro);
            return consulta.list();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            sessao.close();
        }
    }
}
