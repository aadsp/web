package model.requisitos;

import java.util.List;
import annotations.requisitos.RequisitosHistoria;
import model.ABaseModel;
import org.hibernate.Query;

public class RequisitosHistoriaModel extends ABaseModel
{

    public RequisitosHistoria consultarPorID(RequisitosHistoria requisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("from RequisitosHistoria where ID = :ID");
            consulta.setInteger("ID", requisitos.getID());
            return (RequisitosHistoria) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<RequisitosHistoria> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from RequisitosHistoria");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<RequisitosHistoria> listarPorDocumentoRequisitos(RequisitosHistoria requisitos) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select r from RequisitosHistoria r join r.documentoRequisitos dr where dr.ID = :ID");
            consulta.setInteger("ID", requisitos.getDocumentoRequisitos().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<RequisitosHistoria> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from RequisitosHistoria where " + filtro);
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
