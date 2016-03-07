
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Logradouro;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LogradouroCRUD implements ICrud
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
    
    public Logradouro consultarPorID(Logradouro logradouro)throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from Logradouro where ID = :idParametro");
            consulta.setInteger("idParametro", logradouro.getID());
            return (Logradouro) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public Logradouro consultarPorCEP(Logradouro logradouro)throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from Logradouro where cep = :cepParametro");
            consulta.setString("cepParametro", logradouro.getCep());
            return (Logradouro) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    
}
