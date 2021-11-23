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
public class Conta    implements Serializable {

    private static final long serialVersionUID = 1L;

    //inicialização da tabela de conta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer numero_conta;

    @NotNull
    private Integer digito_conta;

    @NotNull
    private Integer agencia;

    @NotNull
    private Integer codigo_banco;

    @NotNull
    private LocalDate data_abertura;

    private LocalDate data_fechamento;

    // relacionamento com a tabela de cliente
    @NotNull
    @ManyToOne
    private Cliente cliente;

    //
    public Conta(@NotNull Integer digito_conta, @NotNull Integer agencia, @NotNull Integer codigo_banco,
                 @NotNull LocalDate data_abertura, LocalDate data_fechamento, @NotNull Cliente cliente) {
        super();
        this.digito_conta = digito_conta;
        this.agencia = agencia;
        this.codigo_banco = codigo_banco;
        this.data_abertura = data_abertura;
        this.data_fechamento = data_fechamento;
        this.cliente = cliente;
    }


    // hashCode e equals
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



    //Getters e Setters
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


    public LocalDate getData_abertura() {
        return data_abertura;
    }


    public void setData_abertura(LocalDate data_abertura) {
        this.data_abertura = data_abertura;
    }


    public LocalDate getData_fechamento() {
        return data_fechamento;
    }


    public void setData_fechamento(LocalDate data_fechamento) {
        this.data_fechamento = data_fechamento;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}