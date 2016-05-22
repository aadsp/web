
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;


public class UsuarioModel implements ICRUD
{
    private final Session sessao;
    
    public UsuarioModel()
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
    
    public Usuario consultarPorID(Usuario usuario)throws Exception
    {
        try{   
            Query consulta = sessao.createQuery("from Usuario where ID = :id");
            consulta.setInteger("id", usuario.getID());
            return (Usuario) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public Usuario consultarPorEmail(Usuario usuario)throws Exception
    {
        try{   
            Query consulta = sessao.createQuery("from Usuario where email = :email");
            consulta.setString("email", usuario.getEmail());
            return (Usuario) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public Usuario autenticar(Usuario usuario)
    {
        try
        {  
            Query consulta = sessao.createQuery("from Usuario where login = :login and senha = :senha");
            consulta.setString("login", usuario.getLogin());
            consulta.setString("senha", usuario.getSenha());
            return (Usuario) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public Usuario validarLogin(Usuario usuario)
    {
        try
        { 
            Query consulta = sessao.createQuery("from Usuario where login = :login");
            consulta.setString("login", usuario.getLogin());
            return (Usuario) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    
    }
    
    public List<Usuario> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario");
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
    
    public List<Usuario> listarPorFiltro(String filtro)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario where " + filtro);
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
