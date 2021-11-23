package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Length(min = 3, max = 120, message = "Logradouro com no máximo 120 caracteres")
    private String logradouro;

    @Length(max = 50, message = "Complemento com no máximo 50 caracteres")
    private String complemento;

    @NotNull
    @Length(min = 3, max = 30, message = "Bairro com no máximo 30 caracteres")
    private String bairro;

    @NotNull
    @Length(min = 8, max = 9, message = "CEP com 8 caracteres")
    private String cep;

    @NotNull
    @Length(min = 3, max = 50, message = "Cidade com no máximo 50 caracteres")
    private String cidade;

    @NotNull
    @Length(min = 2, max = 2, message = "Estado com no máximo 2 caracteres")
    private String estado;

    @NotNull
    @Length(min = 3, max = 30, message = "Pais com no máximo 30 caracteres")
    private String pais;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    public Endereco() {

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        return Objects.equals(id, other.id);
    }



    public Endereco(
            @NotNull @Length(min = 3, max = 120, message = "Logradouro com no máximo 120 caracteres") String logradouro,
            @Length(max = 50, message = "Complemento com no máximo 50 caracteres") String complemento,
            @NotNull @Length(min = 3, max = 30, message = "Bairro com no máximo 30 caracteres") String bairro,
            @NotNull @Length(min = 8, max = 9, message = "CEP com 8 caracteres") String cep,
            @NotNull @Length(min = 3, max = 50, message = "Cidade com no máximo 50 caracteres") String cidade,
            @NotNull @Length(min = 2, max = 2, message = "Estado com no máximo 2 caracteres") String estado,
            @NotNull @Length(min = 3, max = 30, message = "Pais com no máximo 30 caracteres") String pais,
            @NotNull Cliente cliente) {
        super();
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }


    public Cliente getcliente() {
        return cliente;
    }

    public void setcliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getLogradouro() {
        return logradouro;
    }


    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    public String getComplemento() {
        return complemento;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }
}

