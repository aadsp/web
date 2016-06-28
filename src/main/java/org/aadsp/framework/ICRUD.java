package org.aadsp.framework;

/**
 * Classe para definir operações comums de persistencias
 */
public interface ICRUD
{

    public void salvar(Object obj);

    public void atualizar(Object obj);

    public void excluir(Object obj);
}
