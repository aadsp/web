package model.projeto;

import annotations.projeto.PontoComplexidadeContribuicao;
import java.util.List;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoComplexidadeContribuicaoModel extends ABaseModel
{

    public PontoComplexidadeContribuicao consultarPorID(PontoComplexidadeContribuicao pontoComplexidadeContribuicao)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeContribuicao where ID = :ID");
            consulta.setInteger("ID", pontoComplexidadeContribuicao.getID());
            return (PontoComplexidadeContribuicao) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoComplexidadeContribuicao> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeContribuicao");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoComplexidadeContribuicao> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeContribuicao where " + filtro);
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
