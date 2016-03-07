
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Autenticacao;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AutenticacaoCRUD implements ICrud{
    
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
    
    public Autenticacao autenticar(Autenticacao autenticacao) throws Exception{
        try{
            Query consulta = sessao.createQuery("from Autenticacao where login = :loginParametro and senha = :senhaParametro");
            consulta.setString("loginParametro", autenticacao.getLogin());
            consulta.setString("senhaParametro", autenticacao.getSenha());
            return (Autenticacao) consulta.uniqueResult();
        }catch(Exception e){
            throw  e;
        }finally{
            sessao.close();
        }
    }
    
    public Autenticacao validarLogin(Autenticacao autenticacao) throws Exception{
        try{
            Query consulta = sessao.createQuery("from Autenticacao where login = :loginParametro");
            consulta.setString("loginParametro", autenticacao.getLogin());
            return (Autenticacao) consulta.uniqueResult();
        }catch(Exception e){
            throw  e;
        }finally{
            sessao.close();
        }
    }

}
