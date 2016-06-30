package model.projeto;

import annotations.projeto.PontoComplexidadeArquivosInternos;
import java.util.List;
import annotations.projeto.PontoComplexidadeNivel;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoComplexidadeArquivosInternosModel extends ABaseModel
{

    public PontoComplexidadeArquivosInternos consultarPorID(PontoComplexidadeArquivosInternos pontoComplexidadeArquivosInternos)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeArquivosInternos where ID = :ID");
            consulta.setInteger("ID", pontoComplexidadeArquivosInternos.getID());
            return (PontoComplexidadeArquivosInternos) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoComplexidadeArquivosInternos> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeArquivosInternos");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoComplexidadeArquivosInternos> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoComplexidadeArquivosInternos where " + filtro);
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
