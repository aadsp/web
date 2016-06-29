package model.projeto;

import java.util.List;
import annotations.projeto.Equipe;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class EquipeModel extends ABaseModel
{

    public Equipe consultarPorID(Equipe equipe)
    {
        try
        {
            Query consulta = sessao.createQuery("from Equipe where ID = :ID");
            consulta.setInteger("ID", equipe.getID());
            return (Equipe) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Equipe> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Equipe");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Equipe> listarPorTAP(Equipe equipe) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Equipe where ID_tap = :ID_tap");
            consulta.setInteger("ID_tap", equipe.getTap().getID());
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
