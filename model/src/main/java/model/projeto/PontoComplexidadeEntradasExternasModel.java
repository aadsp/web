package model.projeto;

import annotations.projeto.PontoComplexidadeEntradasExternas;
import java.util.List;
import model.ABaseModel;
import org.hibernate.Query;

public class PontoComplexidadeEntradasExternasModel extends ABaseModel
{

    public PontoComplexidadeEntradasExternas consultarPorID(PontoComplexidadeEntradasExternas pontoComplexidadeEntradasExternas)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeEntradasExternas where ID = :ID");
            consulta.setInteger("ID", pontoComplexidadeEntradasExternas.getID());
            return (PontoComplexidadeEntradasExternas) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoComplexidadeEntradasExternas> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeEntradasExternas");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoComplexidadeEntradasExternas> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeEntradasExternas where " + filtro);
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
