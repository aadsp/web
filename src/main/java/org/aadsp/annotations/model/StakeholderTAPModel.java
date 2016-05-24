
package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.StakeholderTAP;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StakeholderTAPModel implements ICRUD
{
private final Session sessao;
    
    public StakeholderTAPModel()
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
    
    public StakeholderTAP consultar(StakeholderTAP stakeholdertap)
    {
        try
        { 
            Query consulta = sessao.createQuery("from StakeholderTAP where ID = :ID");
            consulta.setInteger("ID", stakeholdertap.getID());
            return (StakeholderTAP) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    
    }
    
    public StakeholderTAP consultarPorID(StakeholderTAP stakeholdertap)
    {
        try
        { 
            Query consulta = sessao.createQuery("from StakeholderTAP where ID = :ID");
            consulta.setInteger("ID", stakeholdertap.getID());
            return (StakeholderTAP) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }finally{
            sessao.close();
        }
    
    }
    
    public List<StakeholderTAP> listar()throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from StakeholderTAP");
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
    
    public List<StakeholderTAP> listarPorIDTap(StakeholderTAP stakeholder)throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select st from StakeholderTAP st JOIN st.stakeholder s join st.tap where st.tap.ID  = :ID_tap");
            consulta.setInteger("ID_tap",stakeholder.getTap().getID());
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