
package org.aadsp.annotations.crud;

import java.util.List;
import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;


public class TipoUsuarioCRUD implements ICrud
{
    private Session sessao;
    
    @Override
    public void setSession(Session sessao) {
        this.sessao = sessao;
    }

    @Override
    public void salvar(Object obj) {
        sessao.save(obj);
    }

    @Override
    public void atualizar(Object obj) {
        sessao.update(obj);
    }

    @Override
    public void excluir(Object obj) {
        sessao.delete(obj);
    }
    
    public TipoUsuario consultarPorID(TipoUsuario tipoUsuario){
        Query consulta = sessao.createQuery("from TipoUsuario where ID = :idParametro");
        consulta.setInteger("idParametro", tipoUsuario.getID());
        return (TipoUsuario) consulta.uniqueResult();
    }
    
    public List<TipoUsuario> listar()throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from TipoUsuario");
            return consulta.list();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    }
}
