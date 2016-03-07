
package org.aadsp.annotations.rn;

import org.aadsp.annotations.Bairro;
import org.aadsp.annotations.Cidade;
import org.aadsp.annotations.Estado;
import org.aadsp.annotations.Logradouro;
import org.aadsp.annotations.crud.BairroCRUD;
import org.aadsp.annotations.crud.CidadeCRUD;
import org.aadsp.annotations.crud.EstadoCRUD;
import org.aadsp.annotations.crud.LogradouroCRUD;
import org.aadsp.utils.FactoryHibernate;


public class EnderecoRN 
{
    private Logradouro logradouro;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    
    public EnderecoRN()
    {
        logradouro = new Logradouro();
        bairro = new Bairro();
        cidade = new Cidade();
        estado = new Estado();
    }
    
    public boolean consultarEndereco(Logradouro logradouro) throws Exception
    {
        try{
            LogradouroCRUD logradouroCrud = new LogradouroCRUD();
            EstadoCRUD estadoCrud = new EstadoCRUD();
            BairroCRUD bairroCrud = new BairroCRUD();
            CidadeCRUD cidadeCrud = new CidadeCRUD();
            logradouroCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
            estadoCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
            bairroCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
            cidadeCrud.setSession(FactoryHibernate.getSessionFactory().openSession());
            this.logradouro = logradouro;
            this.logradouro = logradouroCrud.consultarPorCEP(logradouro);
            this.bairro.setID(this.logradouro.getID_bairro());
            this.bairro = bairroCrud.consultarPorID(bairro);
            this.cidade.setID(bairro.getID_cidade());
            this.cidade = cidadeCrud.consultarPorID(cidade);
            this.estado.setID(cidade.getID_estado());
            this.estado = estadoCrud.consultarPorID(estado);
            return true;
        }catch(Exception e){
            throw  e;
        }
    }
    
    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
