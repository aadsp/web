package org.aadsp.controller.named.contributors;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.internet.ParseException;
import org.aadsp.annotations.Colaborador;
import org.aadsp.annotations.Usuario;
import org.aadsp.framework.ABaseNamed;
import org.aadsp.framework.ICadastro;
import org.aadsp.utils.Mensageiro;


@ViewScoped
@Named
public class ColaboradorCadastrar extends ABaseNamed implements ICadastro
{

    public ColaboradorCadastrar()
    {
        data = new Date(new Date().getTime());
        this.usuarios = new HashMap<String, Integer>();
        this.colaborador = new Colaborador();
        this.usuario = new Usuario();
    }

    public boolean controleDeCadastro()
    {
        return this.colaborador.getNumeroPIS() != null;
    }

    public void cadastrar()
    {
        try
        {
            Usuario usuario = new Usuario();
            usuario.setID(usuarioSelecionado);
            this.colaborador.setUsuario(usuario);
            this.colaborador.cadastrar();
            Mensageiro.mensagemInfo("Cadastro realizado com sucesso!!");
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível realizar o cadastro deste usuário!!");
        }
    }

    public Map<String, Integer> getUsuarios()
    {
        try
        {

            List<Usuario> lista = usuario.listar();
            List<Colaborador> listaColaborador = colaborador.listar();
            List<Integer> listaIDColaborador = new ArrayList<Integer>();

            for (Colaborador obj : listaColaborador)
            {
                listaIDColaborador.add(obj.getID());
            }

            for (Usuario obj : lista)
            {
                if (!listaIDColaborador.contains(obj.getID()))
                {
                    usuarios.put(obj.getNome(), obj.getID());
                }
            }
            return usuarios;
        } catch (Exception e)
        {
            Mensageiro.mensagemError("Não foi possível consultar os usuários no banco de dados!");
        }
        return null;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date date) throws ParseException
    {
        java.sql.Date dataSql = new java.sql.Date(date.getTime());
        this.colaborador.setDataContrato(dataSql);
    }

    public int getUsuarioSelecionado()
    {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(int usuarioSelecionado)
    {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public Colaborador getColaborador()
    {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador)
    {
        this.colaborador = colaborador;
    }

    private Map<String, Integer> usuarios;
    private int usuarioSelecionado;
    private Usuario usuario;
    private Colaborador colaborador;
    private Date data;
}
