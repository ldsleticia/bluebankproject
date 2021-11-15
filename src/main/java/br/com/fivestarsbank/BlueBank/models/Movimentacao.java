package br.com.fivestarsbank.BlueBank.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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
    private String tipo_transacao;

    @NotNull
    private LocalDateTime data_transacao;

    @NotNull
    private Double valor;

    @NotNull
    @Max(value = 1, message = "C para crédito, D para Débito")
    private char credito_debito;

    @NotNull
    private String descricao;

    @NotNull
    @ManyToOne
    private Conta numero_conta;

    public Movimentacao (){

    }

    public Movimentacao(String tipo_transacao, LocalDateTime data_transacao, Double valor, char credito_debito, String descricao) {
        this.tipo_transacao = tipo_transacao;
        this.data_transacao = data_transacao;
        this.valor = valor;
        this.credito_debito = credito_debito;
        this.descricao = descricao;
    }

    public String getTipo_transacao() {
        return tipo_transacao;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return credito_debito == that.credito_debito && tipo_transacao.equals(that.tipo_transacao) && data_transacao.equals(that.data_transacao) && valor.equals(that.valor) && descricao.equals(that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo_transacao, data_transacao, valor, credito_debito, descricao);
    }
}
