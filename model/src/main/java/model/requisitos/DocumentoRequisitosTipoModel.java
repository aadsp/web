package model.requisitos;

import java.util.List;
import annotations.requisitos.DocumentoRequisitosTipo;
import model.ABaseModel;
import org.hibernate.Query;

public class DocumentoRequisitosTipoModel extends ABaseModel
{

    public DocumentoRequisitosTipo consultarPorID(DocumentoRequisitosTipo documentoRequisitosTipo)
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTipo where ID = :ID");
            consulta.setInteger("ID", documentoRequisitosTipo.getID());
            return (DocumentoRequisitosTipo) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<DocumentoRequisitosTipo> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTipo");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DocumentoRequisitosTipo> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DocumentoRequisitosTipo where " + filtro);
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
