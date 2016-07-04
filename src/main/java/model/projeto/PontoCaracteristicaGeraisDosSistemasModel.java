package model.projeto;

import annotations.projeto.PontoCaracteristicaGeraisDosSistemas;
import java.util.List;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoCaracteristicaGeraisDosSistemasModel extends ABaseModel
{

    public PontoCaracteristicaGeraisDosSistemas consultarPorID(PontoCaracteristicaGeraisDosSistemas pontoCaracteristicaGeraisDosSistemas)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoCaracteristicaGeraisDosSistemas where ID = :ID");
            consulta.setInteger("ID", pontoCaracteristicaGeraisDosSistemas.getID());
            return (PontoCaracteristicaGeraisDosSistemas) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoCaracteristicaGeraisDosSistemas> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoCaracteristicaGeraisDosSistemas");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoCaracteristicaGeraisDosSistemas> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoCaracteristicaGeraisDosSistemas where " + filtro);
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
