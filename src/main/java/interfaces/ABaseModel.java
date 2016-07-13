/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import utils.FactoryHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Mensageiro;

/**
 *
 * @author Felipe
 */
public abstract class ABaseModel implements ICRUD {

    @Override
    public void salvar(Object obj) {
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.save(obj);
            transacao.commit();
            sessao.close();
        } catch (Exception e) {
            sessao.close();
            Mensageiro.mensagemError("Não foi possível realizar a operação de SALVAR no banco de dados!");
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
            Mensageiro.mensagemError("Não foi possível realizar a operação de ATUALIZAR no banco de dados!");
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
            Mensageiro.mensagemError("Não foi possível realizar a operação de EXCLUIR no banco de dados!");
        }

    }

    public final Session sessao = FactoryHibernate.getSessionFactory().openSession();
}
