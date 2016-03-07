
package org.aadsp.annotations;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ENDERECO.SGPDS_ENDERECO_LOGRADOURO")
public class Logradouro implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_bairro") private Integer ID_bairro;
    @Column(name="nome") private String nome;
    @Column(name="cep") private String cep;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID_bairro() {
        return ID_bairro;
    }

    public void setID_bairro(Integer ID_bairro) {
        this.ID_bairro = ID_bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
