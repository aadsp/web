package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Colaborador;
import org.aadsp.framework.ABaseModel;
import org.aadsp.framework.IFilter;
import org.hibernate.Query;

public class ColaboradorModel extends ABaseModel
{
    public Colaborador consultarPorID(Colaborador colaborador)
    {
        try
        {
            Query consulta = sessao.createQuery("from Colaborador where ID = :ID");
            consulta.setInteger("ID", colaborador.getID());
            return (Colaborador) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Colaborador> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Colaborador");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Colaborador> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from Colaborador c join c.usuario.funcao f join c.usuario u where " + filtro);
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
