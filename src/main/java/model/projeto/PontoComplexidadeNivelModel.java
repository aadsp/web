package model.projeto;

import java.util.List;
import annotations.acesso.Pagina;
import annotations.projeto.PontoComplexidadeNivel;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoComplexidadeNivelModel extends ABaseModel
{

    public PontoComplexidadeNivel consultarPorID(PontoComplexidadeNivel pontoComplexidadeNivel)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeNivel where ID = :ID");
            consulta.setInteger("ID", pontoComplexidadeNivel.getID());
            return (PontoComplexidadeNivel) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoComplexidadeNivel> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeNivel");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoComplexidadeNivel> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeNivel where " + filtro);
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
