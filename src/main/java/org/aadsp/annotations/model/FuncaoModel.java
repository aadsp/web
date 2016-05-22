
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Funcao;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class FuncaoModel implements ICRUD
{
     private final Session sessao;
    
    public FuncaoModel()
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
    
    public Funcao consultarPorID(Funcao funcao)throws Exception
    {
        try{   
            Query consulta = sessao.createQuery("from Funcao where ID = :ID");
            consulta.setInteger("ID", funcao.getID());
            return (Funcao) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public List<Funcao> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Funcao");
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
    
    public List<Funcao> listarPorFiltro(String filtro)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Funcao where " + filtro);
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
