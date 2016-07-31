package model.projeto;

import java.util.List;
import annotations.projeto.PontoGrauDeInfluencia;
import model.ABaseModel;
import org.hibernate.Query;

public class PontoGrauDeInfluencialModel extends ABaseModel
{

    public PontoGrauDeInfluencia consultarPorID(PontoGrauDeInfluencia pontoGrauDeInfluencia)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoGrauDeInfluencia where ID = :ID");
            consulta.setInteger("ID", pontoGrauDeInfluencia.getID());
            return (PontoGrauDeInfluencia) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoGrauDeInfluencia> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoGrauDeInfluencia");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoGrauDeInfluencia> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoGrauDeInfluencia where " + filtro);
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
