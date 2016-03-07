
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Cidade;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Felipe
 */
public class CidadeCRUD implements ICrud
{
    private Session sessao;
   
    @Override
    public void setSession(Session sessao) {
        this.sessao = sessao;
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
    
    public Cidade consultarPorID(Cidade cidade)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Cidade where ID = :idParametro");
        consulta.setInteger("idParametro", cidade.getID());
        return (Cidade) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
}
