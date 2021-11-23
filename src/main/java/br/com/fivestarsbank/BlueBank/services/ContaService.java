package br.com.fivestarsbank.BlueBank.services;

import br.com.fivestarsbank.BlueBank.models.Conta;

import java.util.List;

public interface ContaService {
    Conta BuscarById(Integer id);

    Conta Cadastro(Conta conta);

    List<Conta> ListaConta();

    List<Conta> BuscarByIdCliente(Integer id);

    Conta FechaConta(Integer id);
}
