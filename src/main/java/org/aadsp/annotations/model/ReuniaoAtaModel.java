
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.ReuniaoAta;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReuniaoAtaModel implements ICRUD
{
     private final Session sessao;
    
    public ReuniaoAtaModel()
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
    
    public ReuniaoAta consultarPorID(ReuniaoAta reuniaoAta)throws Exception
    {
        try{   
            Query consulta = sessao.createQuery("from ReuniaoAta where ID = :ID");
            consulta.setInteger("ID", reuniaoAta.getID());
            return (ReuniaoAta) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public List<ReuniaoAta> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ReuniaoAta");
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
    
    public List<ReuniaoAta> listarPorProjeto(ReuniaoAta reuniaoAta)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ReuniaoAta where ID_projeto = :ID_projeto");
            consulta.setInteger("ID_projeto", reuniaoAta.getID_projeto());
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
