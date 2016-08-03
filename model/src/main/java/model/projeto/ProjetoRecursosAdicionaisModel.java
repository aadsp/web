package model.projeto;

import java.util.List;
import annotations.projeto.ProjetoRecursosAdicionais;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class ProjetoRecursosAdicionaisModel extends ABaseModel
{

    public ProjetoRecursosAdicionais consultarPorID(ProjetoRecursosAdicionais projetoRecursosAdicionais)
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoRecursosAdicionais where ID = :ID");
            consulta.setInteger("ID", projetoRecursosAdicionais.getID());
            return (ProjetoRecursosAdicionais) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<ProjetoRecursosAdicionais> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoRecursosAdicionais");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoRecursosAdicionais> listarPorProjeto(ProjetoRecursosAdicionais projetoRecursosAdicionais) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select ra from ProjetoRecursosAdicionais ra join ra.projeto p where p.ID = :ID");
            consulta.setInteger("ID", projetoRecursosAdicionais.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoRecursosAdicionais> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoRecursosAdicionais where " + filtro);
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
