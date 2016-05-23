
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Empresa;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmpresaModel implements ICRUD
{
private final Session sessao;
    
    public EmpresaModel()
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
    
    public Empresa consultarPorID(Empresa empresa)
    {
        try
        { 
            Query consulta = sessao.createQuery("from Empresa where ID = :ID");
            consulta.setInteger("ID", empresa.getID());
            return (Empresa) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    
    }
    
    public List<Empresa> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Empresa");
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
    
    public List<Empresa> listarPorFiltro(String filtro)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Empresa where " + filtro);
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
