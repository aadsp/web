package model.projeto;

import annotations.projeto.PontoContarTipoDadosFuncao;
import java.util.List;
import interfaces.ABaseModel;
import org.hibernate.Query;

public class PontoContarTipoDadosFuncaoModel extends ABaseModel
{

    public PontoContarTipoDadosFuncao consultarPorID(PontoContarTipoDadosFuncao pontoContarTipoDadosFuncao)
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarTipoDadosFuncao where ID = :ID");
            consulta.setInteger("ID", pontoContarTipoDadosFuncao.getID());
            return (PontoContarTipoDadosFuncao) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<PontoContarTipoDadosFuncao> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarTipoDadosFuncao");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public int contarQtdItens(PontoContarTipoDadosFuncao pontoContarTipoDadosFuncao, int sigla)
    {
        try
        {
            Query consulta = sessao.createQuery("select count(tp) from PontoContarTipoDadosFuncao tp where tp.projeto.id = :ID  and tp.tipoDados.sigla = :sigla");
            consulta.setInteger("ID", pontoContarTipoDadosFuncao.getID());
            consulta.setInteger("sigla", sigla);
            return (int) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoContarTipoDadosFuncao> listarPorProjeto(PontoContarTipoDadosFuncao pontoContarTipoDadosFuncao) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("select ctt from PontoContarTipoDadosFuncao ctt join ctt.projeto p where ctt.projeto.ID = :ID order by ctt.tipoDados.ID");
            consulta.setInteger("ID", pontoContarTipoDadosFuncao.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<PontoContarTipoDadosFuncao> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from PontoContarTipoDadosFuncao where " + filtro);
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
