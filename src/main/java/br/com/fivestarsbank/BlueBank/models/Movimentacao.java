package br.com.fivestarsbank.BlueBank.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = -5368117678079469752L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Length( max = 6, message = "Tipo da transação com máximo 6 caracteres")
    private String tipo_transacao;

    @NotNull
    private LocalDateTime data_transacao;

    @NotNull
    private Double valor;

    @NotNull
    @Max(value = 1, message = "C para crédito, D para Débito")
    private char credito_debito;

    @Length( max = 20, message = "Descrição com máximo 20 caracteres")
    private String descricao;

    @NotNull
    @ManyToOne
    private Conta conta;

    public Movimentacao (){

    }


    public Movimentacao(@NotNull String tipo_transacao, @NotNull LocalDateTime data_transacao, @NotNull Double valor,
                        @NotNull @Max(value = 1, message = "C para crédito, D para Débito") char credito_debito,
                        @NotNull String descricao, @NotNull Conta conta) {
        super();
        this.tipo_transacao = tipo_transacao;
        this.data_transacao = data_transacao;
        this.valor = valor;
        this.credito_debito = credito_debito;
        this.descricao = descricao;
        this.conta = conta;
    }


    public String getTipo_transacao() {
        return tipo_transacao;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Conta getConta() {
        return conta;
    }


    public void setConta(Conta conta) {
        this.conta = conta;
    }


    public void setTipo_transacao(String tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }

    public LocalDateTime getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(LocalDateTime data_transacao) {
        this.data_transacao = data_transacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public char getCredito_debito() {
        return credito_debito;
    }

    public void setCredito_debito(char credito_debito) {
        this.credito_debito = credito_debito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        Movimentacao other = (Movimentacao) obj;
        return Objects.equals(id, other.id);
    }

}
