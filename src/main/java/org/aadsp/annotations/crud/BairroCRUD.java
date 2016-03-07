
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Bairro;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Felipe
 */
public class BairroCRUD implements ICrud{
    
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
    
    public Bairro consultarPorID(Bairro bairro)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Bairro where ID = :idParametro");
        consulta.setInteger("idParametro", bairro.getID());
        return (Bairro) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
}
