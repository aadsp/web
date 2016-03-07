
package org.aadsp.interfaces;

import org.hibernate.Session;

public interface ICrud {
    public void setSession(Session sessao);
    public void salvar(Object obj);
    public void atualizar(Object obj);
    public void excluir(Object obj);
}
