package model.projeto;

import annotations.projeto.PontoComplexidadeSaidasExternas;
import java.util.List;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoComplexidadeSaidasExternasModel extends ABaseModel
{

    public PontoComplexidadeSaidasExternas consultarPorID(PontoComplexidadeSaidasExternas pontoComplexidadeSaidasExternas)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeSaidasExternas where ID = :ID");
            consulta.setInteger("ID", pontoComplexidadeSaidasExternas.getID());
            return (PontoComplexidadeSaidasExternas) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoComplexidadeSaidasExternas> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeSaidasExternas");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoComplexidadeSaidasExternas> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeSaidasExternas where " + filtro);
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
