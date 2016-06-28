package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.ProjetoTela;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class ProjetoTelaModel extends ABaseModel
{

    public ProjetoTela consultarPorID(ProjetoTela projetoTela)
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoTela where ID = :ID");
            consulta.setInteger("ID", projetoTela.getID());
            return (ProjetoTela) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<ProjetoTela> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoTela");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoTela> listarPorProjeto(ProjetoTela projetoTela) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select pt  from ProjetoTela pt where pt.projeto.ID = :ID");
            consulta.setInteger("ID", projetoTela.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoTela> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoTela where " + filtro);
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
