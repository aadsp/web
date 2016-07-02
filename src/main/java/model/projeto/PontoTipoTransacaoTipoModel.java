package model.projeto;

import java.util.List;
import annotations.projeto.PontoTipoTransacaoTipo;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoTipoTransacaoTipoModel extends ABaseModel
{

    public PontoTipoTransacaoTipo consultarPorID(PontoTipoTransacaoTipo pontoTipoTransacaoTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoTipoTransacaoTipo where ID = :ID");
            consulta.setInteger("ID", pontoTipoTransacaoTipo.getID());
            return (PontoTipoTransacaoTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoTipoTransacaoTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoTipoTransacaoTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoTipoTransacaoTipo> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoTipoTransacaoTipo where " + filtro);
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
