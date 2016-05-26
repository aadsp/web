package org.aadsp.annotations;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.aadsp.annotations.model.AcessoModel;
import org.aadsp.annotations.model.FuncaoModel;
import org.aadsp.annotations.model.UsuarioModel;
import org.aadsp.interfaces.IAnnotations;
import org.aadsp.utils.Criptografia;
import org.aadsp.utils.Mensageiro;

@Entity
@Table(name = "ACESSO.ACESSO_AADSP_USUARIO")
public class Usuario implements Serializable, IAnnotations
{

    @Id
    @GeneratedValue
    @Column(name = "ID_usuario")
    private Integer ID;
    @Column(name = "nome")
    private String nome;
    @Column(name = "dataNascimento")
    private Date dataNascimento;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "email")
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "imagem")
    private String imagem;

    @OneToOne
    @JoinColumn(name = "ID_funcao")
    private Funcao funcao;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Date getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public Funcao getFuncao()
    {
        return funcao;
    }

    public void setFuncao(Funcao funcao)
    {
        this.funcao = funcao;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getImagem()
    {
        return imagem;
    }

    public void setImagem(String imagem)
    {
        this.imagem = imagem;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    @Override
    public void cadastrar()
    {
        UsuarioModel model = new UsuarioModel();
        model.salvar(this);
    }

    @Override
    public void editar()
    {
        UsuarioModel model = new UsuarioModel();
        model.atualizar(this);
    }

    @Override
    public void excluir()
    {
        UsuarioModel model = new UsuarioModel();
        model.excluir(this);
    }

    public void setSenha(String senha)
    {
        try
        {
            this.senha = Criptografia.codificarParaSSH(senha);
        } catch (NoSuchAlgorithmException ex)
        {
            Mensageiro.mensagemError("Não foi encontrado o algoritmo de criptografia!!");
        } catch (UnsupportedEncodingException ex)
        {
            Mensageiro.mensagemError("Não foi suportada a codificação de criptografia!!");
        }
    }

    public Usuario autenticar()
    {
        UsuarioModel modelo = new UsuarioModel();
        return modelo.autenticar(this);
    }

    public Usuario validarLogin()
    {
        UsuarioModel modelo = new UsuarioModel();
        return modelo.validarLogin(this);
    }

    public List<String> paginasAcesso() throws Exception
    {
        List<String> lista = new ArrayList<>();
        Acesso obj = new Acesso();
        obj.setFuncao(this.funcao);
        AcessoModel acessoModel = new AcessoModel();
        List<Acesso> listaAcesso = acessoModel.listar(obj);
        List<String> paginas = new ArrayList<>();

        for (Acesso acesso : listaAcesso)
        {
            Pagina pagina = new Pagina();
            pagina.setID(acesso.getPagina().getID());
            paginas.add(pagina.consultarNomePagina(pagina));
        }
        return paginas;

    }

    public String consultarFuncao() throws Exception
    {
        FuncaoModel model = new FuncaoModel();
        Funcao obj = new Funcao();
        obj.setID(this.funcao.getID());
        obj = model.consultarPorID(obj);
        return obj.getDescricao();
    }

    public List<Usuario> listar() throws Exception
    {
        UsuarioModel model = new UsuarioModel();
        return model.listar();
    }

    public Usuario consultar() throws Exception
    {
        UsuarioModel model = new UsuarioModel();
        return model.consultarPorID(this);
    }

    public Usuario consultarPorEmail() throws Exception
    {
        UsuarioModel model = new UsuarioModel();
        return model.consultarPorEmail(this);
    }

    public List<Usuario> listarPorFiltro(String filtro) throws Exception
    {
        UsuarioModel model = new UsuarioModel();
        return model.listarPorFiltro(filtro);
    }
}
