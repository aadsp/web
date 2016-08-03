package model.projeto;

import java.util.List;
import annotations.projeto.PontoContarFatorDeAjuste;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoContarFatorDeAjusteModel extends ABaseModel
{

    public PontoContarFatorDeAjuste consultarPorID(PontoContarFatorDeAjuste pontoContarFatorDeAjuste)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarFatorDeAjuste where ID = :ID");
            consulta.setInteger("ID", pontoContarFatorDeAjuste.getID());
            return (PontoContarFatorDeAjuste) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoContarFatorDeAjuste> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarFatorDeAjuste");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }
    
    public List<PontoContarFatorDeAjuste> listarPorProjeto(PontoContarFatorDeAjuste pontoContarFatorDeAjuste) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select pfa from PontoContarFatorDeAjuste pfa where pfa.projeto.ID = :ID");
            consulta.setInteger("ID", pontoContarFatorDeAjuste.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoContarFatorDeAjuste> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarFatorDeAjuste where " + filtro);
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
