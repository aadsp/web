package model;

import interfaces.ICRUD;
import org.hibernate.Session;
import org.hibernate.Transaction;


public abstract class ABaseModel implements ICRUD {

    @Override
    public void salvar(Object obj)
    {
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.save(obj);
            transacao.commit();
            sessao.close();
        } catch (Exception e) {
            sessao.close();
        }

    }

    @Override
    public void atualizar(Object obj) {
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.update(obj);
            transacao.commit();
            sessao.close();
        } catch (Exception e) {
            sessao.close();
        }

    }

    @Override
    public void excluir(Object obj) {
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.delete(obj);
            transacao.commit();
            sessao.close();
        } catch (Exception e) {
            sessao.close();
        }

    }

    public final Session sessao = FactoryHibernate.getSessionFactory().openSession();
}
