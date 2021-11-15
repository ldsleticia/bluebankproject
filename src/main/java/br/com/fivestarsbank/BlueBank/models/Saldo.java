package br.com.fivestarsbank.BlueBank.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Saldo implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime data;

    private Double saldo;

    private Integer id_conta;
}