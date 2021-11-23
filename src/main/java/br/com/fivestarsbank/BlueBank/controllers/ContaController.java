package br.com.fivestarsbank.BlueBank.controllers;

import java.util.List;

import br.com.fivestarsbank.BlueBank.services.ContaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fivestarsbank.BlueBank.models.Conta;

@RestController
@RequestMapping(path="/conta")
public class ContaController {

    @Autowired
    private ContaServiceImpl conta_service;


    @GetMapping(path="/{id}")
    public List<Conta> BuscarByIdCliente(@PathVariable Integer id) {
        return this.conta_service.BuscarByIdCliente(id);
    }

    @GetMapping
    public List<Conta> ListaConta() {
        return this.conta_service.ListaConta();
    }

    @PostMapping(path="/cadastro")
    public Conta Cadastrar(@RequestBody Conta conta) {
        return this.conta_service.Cadastro(conta);
    }


    @GetMapping(path = "/fechar/{id}")
    public Conta FechaConta(@PathVariable Integer id){
     return conta_service.FechaConta(id);
    }

}