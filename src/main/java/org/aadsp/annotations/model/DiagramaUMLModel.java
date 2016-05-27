package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.DiagramaUML;
import org.aadsp.interfaces.ICRUD;
import org.aadsp.utils.FactoryHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DiagramaUMLModel implements ICRUD
{

    private final Session sessao;

    public DiagramaUMLModel()
    {
        this.sessao = FactoryHibernate.getSessionFactory().openSession();
    }

    @Override
    public void salvar(Object obj)
    {
        Transaction transacao = sessao.beginTransaction();
        sessao.save(obj);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void atualizar(Object obj)
    {
        Transaction transacao = sessao.beginTransaction();
        sessao.update(obj);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void excluir(Object obj)
    {
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(obj);
        transacao.commit();
        sessao.close();
    }

    public List<DiagramaUML> listarPorIDProjeto(DiagramaUML diagramaUML) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("Select d from DiagramaUML d join d.projeto p join d.diagramaUMLTipo u where d.projeto.ID = :IDProjeto");
            consulta.setInteger("IDProjeto", diagramaUML.getProjeto().getID());
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<DiagramaUML> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from DiagramaUML");
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
