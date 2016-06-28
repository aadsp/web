package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.EAPPacote;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class EAPPacoteModel extends ABaseModel
{

    public EAPPacote consultarPorID(EAPPacote eapPacote)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPPacote where ID = :ID");
            consulta.setInteger("ID", eapPacote.getID());
            return (EAPPacote) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAPPacote> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPPacote");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPPacote> listarPorProjeto(EAPPacote eapPacote) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select ep from EAPPacote ep join ep.projeto p where p.ID = :IDProjeto");
            consulta.setInteger("IDProjeto", eapPacote.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAPPacote> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAPPacote where " + filtro);
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
