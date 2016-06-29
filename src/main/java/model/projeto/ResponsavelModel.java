package model.projeto;

import java.util.List;
import annotations.projeto.Responsavel;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class ResponsavelModel extends ABaseModel
{

    public Responsavel consultar(Responsavel pagina)
    {
        try
        {
            Query consulta = sessao.createQuery("from Responsavel where ID = :ID");
            consulta.setInteger("ID", pagina.getID());
            return (Responsavel) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Responsavel> listarPorIDTap(Responsavel responsavel) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Responsavel where ID_tap = :ID_tap");
            consulta.setInteger("ID_tap", responsavel.getTap().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Responsavel consultarPorIDTapIDUsuario(Responsavel responsavel) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Responsavel where ID_tap = :ID_tap and ID_usuario = :ID_usuario");
            consulta.setInteger("ID_tap", responsavel.getTap().getID());
            consulta.setInteger("ID_usuario", responsavel.getUsuario().getID());
            return (Responsavel) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

}
