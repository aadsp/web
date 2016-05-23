package org.aadsp.controller.named.contributors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Colaborador;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Colaborador Consulta
 *
 * @author Felipe Coelho
 * @version 08/05/2016
 */
@ViewScoped
@Named
public class ColaboradorConsultar extends ABaseNamed {

    public ColaboradorConsultar() {
        try {
            this.colaborador = new Colaborador();
            this.listaColaborador = this.colaborador.listar();
            this.filtro = new Filtro();
            criarFiltro();
        } catch (Exception e) {
            Mensageiro.mensagemError("Erro ao listar colaboradores cadastrados!!");
        }
    }

    private void criarFiltro() {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Nome", "u.nome");
        atributo.put("Função", "f.descricao");
        
        atributoClasse.put("u.nome", "Usuario");
        atributoClasse.put("f.descricao", "Funcao");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Colaborador> getListarColaboradores() {
        return this.listaColaborador;
    }

    public void editar(Colaborador colaborador) {
        try {
            Response.redirect("/web/faces/views/colaboradores/ColaboradorEditar.xhtml?colaborador=" + Criptografia.codificarParaBase64(colaborador.getID().toString()));
        } catch (Exception e) {
            Mensageiro.mensagemError("Erro ao selecionar colaborador!!");
        }
    }

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
    
    public void filtroConsulta() {
        try {
            if (this.filtro.filtro.endsWith(")")) {
                listaColaborador = this.colaborador.listarPorFiltro(filtro.filtro);
            }else
                listaColaborador = this.colaborador.listar();
        } catch (Exception e) {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Colaborador colaborador;
    private Filtro filtro;
    private List<Colaborador> listaColaborador;

}
