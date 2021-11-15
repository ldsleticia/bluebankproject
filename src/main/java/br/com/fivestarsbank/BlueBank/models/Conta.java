package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Conta    implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero_conta;

    @NotNull
    private Integer digito_conta;

    @NotNull
    private Integer agencia;

    @NotNull
    private Integer codigo_banco;

    @NotNull
    private LocalDateTime data_abertura;

    private LocalDateTime data_fechamento;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    public Conta(@NotNull Integer digito_conta, @NotNull Integer agencia, @NotNull Integer codigo_banco,
                 @NotNull LocalDateTime data_abertura, LocalDateTime data_fechamento, @NotNull Cliente cliente) {
        super();
        this.digito_conta = digito_conta;
        this.agencia = agencia;
        this.codigo_banco = codigo_banco;
        this.data_abertura = data_abertura;
        this.data_fechamento = data_fechamento;
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_conta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        return Objects.equals(numero_conta, other.numero_conta);
    }

    public Integer getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(Integer numero_conta) {
        this.numero_conta = numero_conta;
    }

    public Integer getDigito_conta() {
        return digito_conta;
    }

    public void setDigito_conta(Integer digito_conta) {
        this.digito_conta = digito_conta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getCodigo_banco() {
        return codigo_banco;
    }

    public void setCodigo_banco(Integer codigo_banco) {
        this.codigo_banco = codigo_banco;
    }

    public LocalDateTime getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(LocalDateTime data_abertura) {
        this.data_abertura = data_abertura;
    }

    public LocalDateTime getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(LocalDateTime data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}