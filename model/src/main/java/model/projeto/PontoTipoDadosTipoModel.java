package model.projeto;

import annotations.projeto.PontoTipoDadosTipo;
import java.util.List;
import model.ABaseModel;
import org.hibernate.Query;

public class PontoTipoDadosTipoModel extends ABaseModel
{

    public PontoTipoDadosTipo consultarPorID(PontoTipoDadosTipo pontoTipoDadosTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoTipoTransacaoTipo where ID = :ID");
            consulta.setInteger("ID", pontoTipoDadosTipo.getID());
            return (PontoTipoDadosTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoTipoDadosTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoTipoDadosTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoTipoDadosTipo> listarPorFiltro(String filtro) throws Exception
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
