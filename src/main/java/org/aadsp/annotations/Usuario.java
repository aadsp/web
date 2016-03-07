
package org.aadsp.annotations;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO.AADSP_USUARIO_CADASTRO")
public class Usuario implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="nome") private String nome;
    @Column(name="dataNascimento") private Date dataNascimento;
    @Column(name="ID_usuarioTipo") private Integer id_usuarioTipo;
    @Column(name="cpf") private String cpf;
    @Column(name="rg") private String rg;
    @Column(name="email") private String email;
    @Column(name="ID_enderecoLogradouro") private Integer id_enderecoLogradouro;
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getId_usuarioTipo() {
        return id_usuarioTipo;
    }

    public void setId_usuarioTipo(Integer id_usuarioTipo) {
        this.id_usuarioTipo = id_usuarioTipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_enderecoLogradouro() {
        return id_enderecoLogradouro;
    }

    public void setId_enderecoLogradouro(Integer id_enderecoLogradouro) {
        this.id_enderecoLogradouro = id_enderecoLogradouro;
    }
}
