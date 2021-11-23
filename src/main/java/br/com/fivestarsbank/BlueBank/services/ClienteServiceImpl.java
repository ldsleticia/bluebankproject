package br.com.fivestarsbank.BlueBank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository cliente_repo;

    @Override
    public Cliente BuscarById(Integer id) {
        return this.cliente_repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente inexistente!"));
    }

    @Override
    public List<Cliente> Listar() {
        return this.cliente_repo.findAll();
    }

    @Override
    public Cliente Cadastrar(Cliente cliente) {
        return this.cliente_repo.save(cliente);
    }


}