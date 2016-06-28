package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DocumentoRequisitos;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class DocumentoRequisitosModel extends ABaseModel
{

    public DocumentoRequisitos consultarPorID(DocumentoRequisitos documentoRequisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitos where ID = :ID");
            consulta.setInteger("ID", documentoRequisitos.getID());
            return (DocumentoRequisitos) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public DocumentoRequisitos consultarPorIDProjeto(DocumentoRequisitos documentoRequisitos)
    {
        try
        {
            Query consulta = sessao.createQuery("Select dr from DocumentoRequisitos dr  where dr.projeto.ID = :ID");
            consulta.setInteger("ID", documentoRequisitos.getProjeto().getID());
            return (DocumentoRequisitos) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitos> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitos");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitos> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitos where " + filtro);
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
