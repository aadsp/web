
package org.aadsp.annotations;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACESSO.AADSP_ACESSO_DADOS")
public class Autenticacao implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="login") private String login;
    @Column(name="senha") private String senha;
    @Column(name="ID_cadastroUsuario") private Integer ID_cadastroUsuario;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer id) {
        this.ID = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getID_cadastroUsuario() {
        return ID_cadastroUsuario;
    }

    public void setID_cadastroUsuario(Integer ID_cadastroUsuario) {
        this.ID_cadastroUsuario = ID_cadastroUsuario;
    }
}
