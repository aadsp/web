
package org.aadsp.annotations.crud;

import java.util.List;
import org.aadsp.annotations.Paginas;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PaginasCRUD implements ICrud
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
    
    public Paginas consultarPorID(Paginas pagina)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Paginas where ID = :idParametro");
        consulta.setInteger("idParametro", pagina.getID());
        return (Paginas) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
    public List<Paginas> listar()throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from Paginas");
            return consulta.list();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
    
}
