package br.com.fivestarsbank.BlueBank.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 2232461162022304394L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Length(min = 8, max = 20, message = "Senha com no mínimo 8 caracteres")
    private String senha;

    @NotEmpty
    @Length(min = 3, max = 50, message = "Nome com no máximo 50 caractéres")
    private String nome;

    @NotEmpty
    @Length(min = 11, max = 14, message = "CPF = 11 caractéres e CNP = 14 caractéres")
    private String cpf_cnpj;

    @NotEmpty
    @Length(min = 3, max = 14, message = "RG max = 10 caractéres e IE max = 14 caractéres")
    private String rg_ie;

    private Date data_nascimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRg_ie() {
        return rg_ie;
    }

    public void setRg_ie(String rg_ie) {
        this.rg_ie = rg_ie;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Cliente(){

    }

    //Cliente PJ
    public Cliente(String senha, String nome, String cpf_cnpj, String rg_ie){
        this.senha = senha;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.rg_ie = rg_ie;
    }

    //Cliente PF
    public Cliente(String senha, String nome, String cpf_cnpj, String rg_ie, Date data_nascimento){
        this(senha, nome, cpf_cnpj, rg_ie);
        this.data_nascimento = data_nascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(cpf_cnpj, cliente.cpf_cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf_cnpj);
    }
}
