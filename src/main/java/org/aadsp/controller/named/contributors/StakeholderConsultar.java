package org.aadsp.controller.named.contributors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Stakeholder;
import org.aadsp.interfaces.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;

/**
 * Classe que representa o objeto de tela Pessoal Consulta
 *
 * @author Felipe Coelho
 * @version 02/05/2016
 */
@ViewScoped
@Named
public class StakeholderConsultar extends ABaseNamed {

    public StakeholderConsultar() {
        try {
            this.stakeholder = new Stakeholder();
            this.listaStakeholder = this.stakeholder.listar();
            this.filtro = new Filtro();
            criarFiltro();
        } catch (Exception e) {
            Mensageiro.mensagemError("Erro ao listar stakeholders cadastrados!!");
        }
    }
    
    private void criarFiltro() {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();
        
        atributo.put("Nome", "nome");
        atributo.put("RG", "rg");
        atributo.put("CPF", "cpf");
         atributo.put("E-mail", "email");
        
        atributoClasse.put("nome", "Stakeholder");
        atributoClasse.put("rg", "Stakeholder");
        atributoClasse.put("cpf", "Stakeholder");
        atributoClasse.put("email", "Stakeholder");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Stakeholder> getListarStakeholders() {
        return this.listaStakeholder;
    }

    public void editar(Stakeholder stakeholder) {
        try {
            Response.redirect("/web/faces/views/colaboradores/StakeholderEditar.xhtml?Stakeholder=" + Criptografia.codificarParaBase64(stakeholder.getID().toString()));
        } catch (Exception e) {
            Mensageiro.mensagemError("Erro ao selecionar Página!!");
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
                listaStakeholder = this.stakeholder.listarPorFiltro(filtro.filtro);
            }else
                listaStakeholder = this.stakeholder.listar();
        } catch (Exception e) {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Stakeholder stakeholder;
    private Filtro filtro;
    private List<Stakeholder> listaStakeholder;

}
