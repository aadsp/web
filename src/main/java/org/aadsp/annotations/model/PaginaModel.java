
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Pagina;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PaginaModel implements ICRUD
{
private final Session sessao;
    
    public PaginaModel()
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
    
    public Pagina consultarPorID(Pagina pagina)
    {
        try
        { 
            Query consulta = sessao.createQuery("from Pagina where ID = :ID");
            consulta.setInteger("ID", pagina.getID());
            return (Pagina) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    
    }
    
    public List<Pagina> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Pagina");
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
