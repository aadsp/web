
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Acesso;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AcessoModel implements ICRUD
{
    private Session sessao;
    
    public AcessoModel()
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
    
    public List<Acesso> listar(Acesso acesso)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Acesso where ID_funcao = :ID_funcao");
            consulta.setInteger("ID_funcao", acesso.getID_funcao());
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
