package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DocumentoRequisitosTemplate;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class DocumentoRequisitosTemplateModel extends ABaseModel
{

    public DocumentoRequisitosTemplate consultarPorID(DocumentoRequisitosTemplate documentoRequisitosTemplate)
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTemplate where ID = :ID");
            consulta.setInteger("ID", documentoRequisitosTemplate.getID());
            return (DocumentoRequisitosTemplate) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<DocumentoRequisitosTemplate> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTemplate");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitosTemplate> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTemplate where " + filtro);
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
