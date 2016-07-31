package model.projeto;

import annotations.projeto.PontoContarTipoTransacao;
import java.util.List;
import model.ABaseModel;
import org.hibernate.Query;

public class PontoContarTipoTransacaoModel extends ABaseModel
{

    public PontoContarTipoTransacao consultarPorID(PontoContarTipoTransacao pontoContarTipoTransacao)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoTipoTransacaoTipo where ID = :ID");
            consulta.setInteger("ID", pontoContarTipoTransacao.getID());
            return (PontoContarTipoTransacao) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoContarTipoTransacao> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarTipoTransacao");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoContarTipoTransacao> listarPorProjeto(PontoContarTipoTransacao pontoContarTipoTransacao) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select ctt from PontoContarTipoTransacao ctt join ctt.projeto p where ctt.projeto.ID = :ID order by ctt.tipoTransacao.ID");
            consulta.setInteger("ID", pontoContarTipoTransacao.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoContarTipoTransacao> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarTipoTransacao where " + filtro);
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
