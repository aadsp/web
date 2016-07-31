package model.acesso;

import java.util.List;
import annotations.acesso.Funcao;
import model.ABaseModel;
import org.hibernate.Query;

public class FuncaoModel extends ABaseModel
{

    public Funcao consultarPorID(Funcao funcao) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Funcao where ID = :ID");
            consulta.setInteger("ID", funcao.getID());
            return (Funcao) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Funcao> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Funcao");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Funcao> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Funcao where " + filtro);
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
