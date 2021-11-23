package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Saldo implements Serializable {
    private static final long serialVersionUID = 1L;

    // inicialização da tabela saldo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDate data_saldo;

    @NotNull
    private Double saldo;

    @ManyToOne
    private Conta conta;

    //
    public Saldo(@NotNull LocalDate data_saldo,  @NotNull  Double saldo, Conta conta) {
        super();
        this.data_saldo = data_saldo;
        this.saldo = saldo;
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData_saldo() {
        return data_saldo;
    }

    public void setData_saldo(@NotNull LocalDate data_saldo) {
        this.data_saldo = data_saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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
        Saldo other = (Saldo) obj;
        return Objects.equals(id, other.id);
    }


}
