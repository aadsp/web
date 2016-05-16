
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Projeto;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProjetoModel implements ICRUD
{
private final Session sessao;
    
    public ProjetoModel()
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
    
    public Projeto consultarPorID(Projeto projeto)
    {
        try
        { 
            Query consulta = sessao.createQuery("from Projeto where ID = :ID");
            consulta.setInteger("ID", projeto.getID());
            return (Projeto) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    
    }
    
    public List<Projeto> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Projeto");
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
