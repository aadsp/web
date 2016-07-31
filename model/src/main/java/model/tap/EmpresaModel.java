package model.tap;

import java.util.List;
import annotations.tap.Empresa;
import model.ABaseModel;
import org.hibernate.Query;

public class EmpresaModel extends ABaseModel
{

    public Empresa consultarPorID(Empresa empresa)
    {
        try
        {
            Query consulta = sessao.createQuery("from Empresa where ID = :ID");
            consulta.setInteger("ID", empresa.getID());
            return (Empresa) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Empresa> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Empresa");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Empresa> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Empresa where " + filtro);
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
