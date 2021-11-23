package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Cliente  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Length(min = 8, max = 20, message = "Senha com no mínimo 8 caracteres")
    private String senha;

    @NotNull
    @Length(min = 3, max = 50, message = "Nome com no máximo 50 caracteres")
    private String nome;

    @NotNull
    @Column(unique = true)
    @Length(min = 11, max = 14, message = "CPF = 11, CNPJ = 14")
    private String cpf_cnpj;

    @NotNull
    @Column(unique = true)
    @Length(min = 3, max = 14, message = "RG = 10, IE = 14")
    private String rg_ie;

    private LocalDate data_nascimento;
    public Cliente() {

    }

    public Cliente(String senha,String nome, String cpf_cnpj, String rg_ie, LocalDate data_nascimento) {
        this.senha = senha;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.rg_ie = rg_ie;
        this.data_nascimento = data_nascimento;
    }

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
    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    //HashCode e Equals
    @Override
    public int hashCode() {
        return Objects.hash(cpf_cnpj, id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(cpf_cnpj, other.cpf_cnpj) && Objects.equals(id, other.id);
    }
}