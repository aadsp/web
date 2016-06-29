package model.projeto;

import java.util.List;
import annotations.projeto.EAP;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class EAPModel extends ABaseModel
{

    public EAP consultarPorID(EAP eap)
    {
        try
        {
            Query consulta = sessao.createQuery("from EAP where ID = :ID");
            consulta.setInteger("ID", eap.getID());
            return (EAP) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<EAP> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from EAP");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAP> listarPorProjeto(EAP eap)
    {
        try
        {
            Query consulta = sessao.createQuery("select e from EAP e join e.projeto p join e.eapTipo t where p.ID = :IDProjeto");
            consulta.setInteger("IDProjeto", eap.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<EAP> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select e from EAP e join e.eapTipo t join e.projeto p where " + filtro);
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
