package org.aadsp.annotations.model;

import java.util.List;
import org.aadsp.annotations.Usuario;
import org.aadsp.framework.ABaseModel;
import org.hibernate.Query;

public class UsuarioModel extends ABaseModel
{

    public Usuario consultarPorID(Usuario usuario) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario where ID = :id");
            consulta.setInteger("id", usuario.getID());
            return (Usuario) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Usuario consultarPorEmail(Usuario usuario) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario where email = :email");
            consulta.setString("email", usuario.getEmail());
            return (Usuario) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Usuario autenticar(Usuario usuario)
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario where login = :login and senha = :senha");
            consulta.setString("login", usuario.getLogin());
            consulta.setString("senha", usuario.getSenha());
            return (Usuario) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public Usuario validarLogin(Usuario usuario)
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario where login = :login");
            consulta.setString("login", usuario.getLogin());
            return (Usuario) consulta.uniqueResult();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }

    }

    public List<Usuario> listar() throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario");
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

    public List<Usuario> listarPorFiltro(String filtro) throws Exception
    {
        try
        {
            Query consulta = sessao.createQuery("from Usuario where " + filtro);
            return consulta.list();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            sessao.close();
        }
    }

}
