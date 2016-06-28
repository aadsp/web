package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAPAtividade;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class EAPAtividadeModel extends ABaseModel
{

    public EAPAtividade consultarPorID(EAPAtividade eapAtividade)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPAtividade where ID = :ID");
            consulta.setInteger("ID", eapAtividade.getID());
            return (EAPAtividade) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAPAtividade> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPAtividade");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPAtividade> listarPorEAP(EAPAtividade eapAtividade) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select a from EAPAtividade a join a.eap e where e.ID = :IDEAP");
            consulta.setInteger("IDEAP", eapAtividade.getEap().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPAtividade> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPAtividade where " + filtro);
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

}
