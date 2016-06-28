package org.aadsp.controller.named.contributors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.aadsp.annotations.Empresa;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Filtro;
import org.aadsp.utils.Mensageiro;
import org.aadsp.utils.Response;


@ViewScoped
@Named
public class EmpresaConsultar extends ABaseNamed
{

    public EmpresaConsultar()
    {
        try
        {
            this.empresa = new Empresa();
            this.listaEmpresa = this.empresa.listar();
            this.filtro = new Filtro();
            criarFiltro();
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao listar empresas cadastradas!!");
        }

    }

    private void criarFiltro()
    {
        Map<String, String> atributo = new HashMap<>();
        Map<String, String> atributoClasse = new HashMap<>();

        atributo.put("Razão Social", "razaoSocial");
        atributo.put("CNPJ", "cnpj");
        atributo.put("CPF", "cpf");
        atributo.put("E-mail", "email");

        atributoClasse.put("razaoSocial", "Empresa");
        atributoClasse.put("cnpj", "Empresa");
        atributoClasse.put("cpf", "Empresa");
        atributoClasse.put("email", "Empresa");
        filtro.setAtributo(atributo, atributoClasse);
    }

    public List<Empresa> getListarEmpresas()
    {
        return this.listaEmpresa;
    }

    public void editar(Empresa empresa)
    {
        try
        {
            Response.redirect("/web/faces/views/colaboradores/EmpresaEditar.xhtml?empresa=" + Criptografia.codificarParaBase64(empresa.getID().toString()));
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Erro ao selecionar empresa!!");
        }
    }

    public Filtro getFiltro()
    {
        return filtro;
    }

    public void setFiltro(Filtro filtro)
    {
        this.filtro = filtro;
    }

    public void filtroConsulta()
    {
        try
        {
            if (this.filtro.filtro.endsWith(")"))
            {
                listaEmpresa = this.empresa.listarPorFiltro(filtro.filtro);
            } else
            {
                listaEmpresa = this.empresa.listar();
            }
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar pelo filtro gerado!!");
        }
    }

    private Empresa empresa;
    private List<Empresa> listaEmpresa;
    private Filtro filtro;

}
