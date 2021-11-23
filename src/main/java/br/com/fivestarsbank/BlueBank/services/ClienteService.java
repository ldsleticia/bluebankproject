package br.com.fivestarsbank.BlueBank.services;

import java.util.List;

import br.com.fivestarsbank.BlueBank.models.Cliente;

public interface ClienteService {

    public Cliente BuscarById(Integer id);
    public List<Cliente> Listar();
    public Cliente Cadastrar(Cliente cliente);


}