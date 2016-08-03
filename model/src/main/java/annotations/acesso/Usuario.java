package annotations.acesso;

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
import model.acesso.AcessoModel;
import model.acesso.FuncaoModel;
import model.acesso.UsuarioModel;
import interfaces.IAnnotations;
import interfaces.IUsuario;

@Entity
@Table(name = "ACESSO.USUARIO")
public class Usuario implements Serializable, IAnnotations, IUsuario
{

    @Id
    @GeneratedValue
    @Column(name = "ID_usuario")
    private Integer ID;
    @Column(name = "nome", length = 70)
    private String nome;
    @Column(name = "dataNascimento")
    private Date dataNascimento;
    @Column(name = "cpf", length = 30)
    private String cpf;
    @Column(name = "rg", length = 30)
    private String rg;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "login", length = 30)
    private String login;
    @Column(name = "senha", length = 257)
    private String senha;
    @Column(name = "imagem", length = 100)
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
        this.senha = senha;
    }

    public Usuario autenticar() throws ExceptionInInitializerError
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
