package model.projeto;

import java.util.List;
import annotations.projeto.ReuniaoAta;
import model.ABaseModel;
import org.hibernate.Query;

public class ReuniaoAtaModel extends ABaseModel
{

    public ReuniaoAta consultarPorID(ReuniaoAta reuniaoAta) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ReuniaoAta where ID = :ID");
            consulta.setInteger("ID", reuniaoAta.getID());
            return (ReuniaoAta) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ReuniaoAta> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ReuniaoAta");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ReuniaoAta> listarPorProjeto(ReuniaoAta reuniaoAta) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select r from ReuniaoAta r join r.projeto p where p.ID = :ID");
            consulta.setInteger("ID", reuniaoAta.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ReuniaoAta> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select r from ReuniaoAta r join r.projeto p join r.colaborador c where " + filtro);
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
