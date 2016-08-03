package model.acesso;

import java.util.List;
import annotations.acesso.Pagina;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PaginaModel extends ABaseModel
{

    public Pagina consultarPorID(Pagina pagina)
    {
        try
        {
            Query consulta = sessao.createQuery("from Pagina where ID = :ID");
            consulta.setInteger("ID", pagina.getID());
            return (Pagina) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Pagina> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Pagina");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Pagina> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Pagina where " + filtro);
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
