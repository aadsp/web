/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import utils.Filtro;

/**
 *
 * @author Felipe
 */
public interface IConsulta
{
    public void criarFiltro();
    public Filtro getFiltro();
    public void setFiltro(Filtro filtro);
}
