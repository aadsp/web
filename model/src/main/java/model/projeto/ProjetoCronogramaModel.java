package model.projeto;

import java.util.List;
import annotations.projeto.Projeto;
import annotations.projeto.ProjetoCronograma;
import model.ABaseModel;
import org.hibernate.Query;

public class ProjetoCronogramaModel extends ABaseModel
{

    public ProjetoCronograma consultarPorID(ProjetoCronograma projetoCronograma)
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from ProjetoCronograma c where c.ID = :ID");
            consulta.setInteger("ID", projetoCronograma.getID());
            return (ProjetoCronograma) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoCronograma> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from ProjetoCronograma");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<ProjetoCronograma> listarPorProjeto(ProjetoCronograma projetoCronograma) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from ProjetoCronograma c join c.projeto p where p.ID = :ID order by c.dataInicio asc");
            consulta.setInteger("ID", projetoCronograma.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public boolean verificarPeriodoInProjeto(ProjetoCronograma projetoCronograma)
    {
        try
        {
            Query consulta = sessao.createQuery("Select p from Projeto p where p.ID = :IDProjeto and  (p.dataInicio <= :dataInicio and p.dataTermino>= :dataTermino )");
            consulta.setInteger("IDProjeto", projetoCronograma.getProjeto().getID());
            consulta.setDate("dataInicio", projetoCronograma.getDataInicio());
            consulta.setDate("dataTermino", projetoCronograma.getDataTermino());
            Projeto projeto = (Projeto) consulta.uniqueResult();
            if (projeto != null)
            {
                return true;
            }

        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
        return false;
    }

    public List<ProjetoCronograma> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select c from ProjetoCronograma c "
                    + "join c.projeto p where " + filtro);
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
