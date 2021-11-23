package br.com.fivestarsbank.BlueBank.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.repositories.ContaRepository;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepo;

    @Autowired
    private ClienteServiceImpl clienteservice;

    @Override
    public Conta BuscarById(Integer id) {
        return this.contaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta não cadastrada"));
    }

    @Override
    public List<Conta> ListaConta() {
        return contaRepo.findAll();
    }

    @Override
    public Conta Cadastro(Conta conta) {
        Integer idCliente = conta.getCliente().getId();
        Cliente cliente = clienteservice.BuscarById(idCliente);
        conta.setCliente(cliente);
        return this.contaRepo.save(conta);
    }


    @Override
    public Conta FechaConta(Integer id) {
        LocalDate data = LocalDate.now();
        Conta conta = BuscarById(id);
        conta.setData_fechamento(data);
        return conta;
    }

    @Override
    public List<Conta> BuscarByIdCliente(Integer id) {
        List<Conta> lista = new ArrayList<>();
        for(Conta i : ListaConta()) {
            if (id == i.getCliente().getId())lista.add(i);
        }
        return lista;
    }

}